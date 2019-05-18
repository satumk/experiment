
package Experiment.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author satu
 */
@Controller
public class DefaultController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
}