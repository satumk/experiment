
package Experiment.Entity;

import Experiment.Entity.Experiment;
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
public class Direction extends AbstractPersistable<Long>{
    
    @ManyToOne
    private Experiment experiment;
    private String direction;
}
