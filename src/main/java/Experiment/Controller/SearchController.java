
package Experiment.Controller;

import Experiment.Entity.Experiment;
import Experiment.Entity.Material;
import Experiment.Repository.ExperimentRepository;
import Experiment.Repository.MaterialRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    
    @Autowired
    private ExperimentRepository experimentRepository;
    
    @Autowired
    private MaterialRepository materialRepository;
    
    private List<Experiment> found = new ArrayList<>();
    
    @GetMapping("/search")
    public String searchHome(Model model) {;
        model.addAttribute("experiments", found);
        return "search";
    }
    
    @PostMapping("/search/duration")
    public String searchDuration(@RequestParam String duration) {
        int durationInt = Integer.parseInt(duration);
        durationInt ++;
        found.clear();
        found = experimentRepository.findByDurationLessThan(durationInt);
        return "redirect:/search";
        
    }
    
    @PostMapping("/search/material")
    public String searchMaterial(@RequestParam String material) {
        List<Material> foundMaterial = materialRepository.findByNameIgnoreCase(material);
        
        found.clear();
        
        for (Material mater : foundMaterial) {
            Experiment exp = mater.getExperiment();
            found.add(exp);
        }
        
        return "redirect:/search";
    }
}
