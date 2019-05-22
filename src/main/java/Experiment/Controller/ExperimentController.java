
package Experiment.Controller;

import Experiment.Entity.Direction;
import Experiment.Entity.Experiment;
import Experiment.Entity.Material;
import Experiment.Repository.DirectionRepository;
import Experiment.Repository.ExperimentRepository;
import Experiment.Repository.MaterialRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExperimentController {
    
    @Autowired
    private ExperimentRepository experimentRepository;
    
    @Autowired 
    private DirectionRepository directionRepository;
    
    @Autowired
    private MaterialRepository materialRepository;
    
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
    
    @GetMapping("/experiments/{id}")
    public String getExperiment(Model model, @PathVariable Long id) {
        
        Experiment exp = experimentRepository.getOne(id);
        
        model.addAttribute("name", exp.getName());
        model.addAttribute("subject", exp.getSubject());
        model.addAttribute("duration", exp.getDuration());
        model.addAttribute("materials", exp.getMaterials());
        model.addAttribute("directions", exp.getDirections());
        model.addAttribute("explanation", exp.getExplanation());
        model.addAttribute("notes", exp.getNotes());

        return "experiment";
    }
    
    @PostMapping("/experiments/{id}/subject")
    public String addSubject(@PathVariable Long id, @RequestParam String subjectAdd) {
        
        Experiment exp = experimentRepository.getOne(id);
        exp.setSubject(subjectAdd);
        
        experimentRepository.save(exp);
        
        return "redirect:/experiments/" + exp.getId();
    }
    
    @PostMapping("/experiments/{id}/material")
    public String addMaterial(@PathVariable Long id, @RequestParam String materialAdd, @RequestParam String quantityAdd) {
        
        Experiment exp = experimentRepository.getOne(id);
        
        Material addNew = new Material();
        addNew.setName(materialAdd);
        addNew.setAmount(quantityAdd);
        addNew.setExperiment(exp);
        
        materialRepository.save(addNew);
        
        return "redirect:/experiments/" + exp.getId();
    }
    
    @PostMapping("/experiments/{id}/direction")
    public String addDirection(@PathVariable Long id, @RequestParam String directionAdd) {
        
        Experiment exp = experimentRepository.getOne(id);
        
        Direction addNew = new Direction();
        addNew.setDirection(directionAdd);
        addNew.setExperiment(exp);
        
        directionRepository.save(addNew);
        
        return "redirect:/experiments/" + exp.getId();
    }
    
    @PostMapping("/experiments/{id}/explanation")
    public String addExplanation(@PathVariable Long id, @RequestParam String explanationAdd) {
        
        Experiment exp = experimentRepository.getOne(id);
        
        exp.setExplanation(explanationAdd);
        
        experimentRepository.save(exp);
        
        return "redirect:/experiments/" + exp.getId();
    }
    
    @PostMapping("/experiments/{id}/notes")
    public String addNotes(@PathVariable Long id, @RequestParam String notesAdd) {
        
        Experiment exp = experimentRepository.getOne(id);
        
        exp.setNotes(notesAdd);
        
        experimentRepository.save(exp);
        
        return "redirect:/experiments/" + exp.getId();
    }
}
