
package Experiment.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Experiment extends AbstractPersistable<Long>{
    
    @NotEmpty
    @Size(min = 4, max = 50)
    @Column(unique = true)
    private String name;
    
    @NotEmpty
    @ManyToOne
    private Subject subject;
    
    @OneToMany(mappedBy="experiment")
    private List<Direction> directions = new ArrayList<>();
    
    @OneToMany(mappedBy="experiment")
    private List<Material> materials = new ArrayList<>();
   
    private String explanation;
    private String notes;
   
    @OneToMany(mappedBy = "experiment", fetch = FetchType.LAZY)
    List<GalleryFileObject> gallery = new ArrayList<>();
    

}
