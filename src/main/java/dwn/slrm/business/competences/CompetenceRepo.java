package dwn.slrm.business.competences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepo extends JpaRepository<Competence,Long> {
}
