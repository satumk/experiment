
package Experiment.Controller;

import Experiment.Entity.Experiment;
import Experiment.Repository.ExperimentRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExperimentController {
    
    @Autowired
    private ExperimentRepository experimentRepository;
    
    @ModelAttribute
    private Experiment getExperiment() {
        
        return new Experiment();
    }
    
    @GetMapping("/experiments")
    public String viewExperiments(Model model) {
        
        model.addAttribute("experiments", experimentRepository.findAll());
        
        return "experiments"; 
    }
    
    @PostMapping("/experiments")
    public String create(@Valid @ModelAttribute Experiment experiment, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "experiments";
        }
        
        experimentRepository.save(experiment);
        
        return "redirect:/experiments";
    }
}
