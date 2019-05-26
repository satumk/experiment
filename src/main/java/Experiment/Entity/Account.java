
package Experiment.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends AbstractPersistable<Long>{
    
    @NotEmpty
    @Size(min = 4, max = 20)
    private String name;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    @Size(min = 4, max = 20)
    @Column(unique = true)
    private String username;
    
    @NotEmpty
    @Size(min = 8, max = 100)
    private String password;
    
    @ManyToMany
    private List<Experiment> experiments = new ArrayList<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities = new ArrayList<>();
}
