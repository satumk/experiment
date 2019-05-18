
package Experiment.Controller;

import Experiment.Entity.Account;
import Experiment.Repository.AccountRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @GetMapping("/register")
    public String view(@ModelAttribute Account account) {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        
        accountRepository.save(account);
        
        return "success";
    }
    
}
