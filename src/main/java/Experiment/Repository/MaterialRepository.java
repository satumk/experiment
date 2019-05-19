
package Experiment.Repository;

import Experiment.Entity.Experiment;
import Experiment.Entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{
      
}
