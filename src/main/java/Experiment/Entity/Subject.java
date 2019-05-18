
package Experiment.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject extends AbstractPersistable<Long>{
    
    private String name;
    
    @OneToMany(mappedBy="subject")
    private List<Experiment> experiments = new ArrayList<>();
    
}
