
package Experiment.Repository;

import Experiment.Entity.Experiment;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long>{

    public List<Experiment> findByDurationLessThan(int durationInt);

}
