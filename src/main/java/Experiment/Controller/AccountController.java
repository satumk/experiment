
package Experiment.Controller;

import Experiment.Entity.Account;
import Experiment.Repository.AccountRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @GetMapping("/register")
    public String view(@ModelAttribute Account account) {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute Account account, BindingResult bindingResult, @RequestParam String adminReason) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
/*        
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            return "redirect:/";
        }
*/
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.getAuthorities().add("USER");
        
        if (!adminReason.isEmpty()) {
            account.getAuthorities().add("ADMIN");
        }
        
        accountRepository.save(account);
        
        return "success";
    }
    
    @GetMapping("/owninfo")
    public String ownInfo(Model model) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Account current = accountRepository.findByUsername(username);
        
        model.addAttribute("name", current.getName());
        model.addAttribute("email", current.getEmail());
        model.addAttribute("username", current.getUsername());
        model.addAttribute("experiments", current.getExperiments());
        
        return "owninfo";
    }
    
}
