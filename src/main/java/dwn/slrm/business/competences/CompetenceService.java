package dwn.slrm.business.competences;

import dwn.slrm.generic.services.AbstractCrudService;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService extends AbstractCrudService<Competence, CompetenceDto, CompetenceRepo, CompetenceMapper> implements IAbstractCrudService<Competence,CompetenceDto> {
    public CompetenceService(CompetenceRepo repository, CompetenceMapper mapper) {
        super(repository, mapper);
    }
}
