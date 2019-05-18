
package Experiment.Entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GALLERY")
public class GalleryFileObject extends AbstractPersistable<Long> {
    
    @ManyToOne
    private Experiment experiment;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    //@Type(type="org.hibernate.type.BinaryType")  // enable for PostgreSQL
    private byte[] content;

    private String description;
}
