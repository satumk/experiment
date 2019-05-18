
package Experiment.Entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material extends AbstractPersistable<Long>{
    
    private String name;
    private String amount;
    @ManyToOne
    private Experiment experiment;

}
