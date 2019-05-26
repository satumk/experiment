
package Experiment.Service;

import Experiment.Entity.Account;
import Experiment.Repository.AccountRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }
        
        if (account.getAuthorities().contains("ADMIN")) {
            return new org.springframework.security.core.userdetails.User(
            account.getUsername(),
            account.getPassword(),
            true,
            true,
            true,
            true,
            Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN")));
        } else {
            return new org.springframework.security.core.userdetails.User(
            account.getUsername(),
            account.getPassword(),
            true,
            true,
            true,
            true,
            Arrays.asList(new SimpleGrantedAuthority("USER")));
        }
        
    }
}
