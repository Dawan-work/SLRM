package dwn.slrm.business.dossiers;

import dwn.slrm.generic.services.IAbstractCrudService;
import dwn.slrm.generic.services.AbstractAnnexableService;
import org.springframework.stereotype.Service;

@Service
public class DossierService extends AbstractAnnexableService<DossierProjet,DossierProjetDto, DossierRepository,DossierMapper> implements IAbstractCrudService<DossierProjet,DossierProjetDto> {
    public DossierService(DossierRepository repository, DossierMapper mapper) {
        super(repository, mapper);
    }
}
