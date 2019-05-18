
package Experiment.Controller;

import Experiment.Entity.Experiment;
import Experiment.Repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExperimentController {
    
    @Autowired
    private ExperimentRepository experimentRepository;
    
    @GetMapping("/experiments")
    public String viewExperiments(Model model) {
        
        model.addAttribute("experiments", experimentRepository.findAll());
        
        return "experiments"; 
    }
    
    @PostMapping("/experiments")
    public String create(@RequestParam String name, @RequestParam Integer duration) {
        
        Experiment add = new Experiment();
        add.setName(name);
        add.setDuration(duration);
        
        experimentRepository.save(add);
        
        return "redirect:/experiments";
    }
}
