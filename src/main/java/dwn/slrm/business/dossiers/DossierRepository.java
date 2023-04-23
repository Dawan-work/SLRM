package dwn.slrm.business.dossiers;

import dwn.slrm.generic.repositories.AnnexableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepository extends AnnexableRepository<DossierProjet,Long> {
}
