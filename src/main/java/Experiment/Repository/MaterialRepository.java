
package Experiment.Repository;

import Experiment.Entity.Experiment;
import Experiment.Entity.Material;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

    public List<Material> findByNameIgnoreCase(String material);

    public void deleteByExperiment(Experiment exp);
      
}
