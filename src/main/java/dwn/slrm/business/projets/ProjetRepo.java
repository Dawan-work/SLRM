package dwn.slrm.business.projets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepo  extends JpaRepository<Projet,Long> {
}
