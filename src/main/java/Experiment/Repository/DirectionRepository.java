
package Experiment.Repository;

import Experiment.Entity.Direction;
import Experiment.Entity.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long>{

    public void deleteByExperiment(Experiment exp);
    
}
