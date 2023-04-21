package dwn.slrm.business.projets;

import dwn.slrm.generic.services.AbstractCrudService;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProjetService extends AbstractCrudService<Projet, ProjetDto, ProjetRepo, ProjetMapper> implements IAbstractCrudService<Projet,ProjetDto> {
    public ProjetService(ProjetRepo repository, ProjetMapper mapper) {
        super(repository, mapper);
    }

    public void addContent(long id) {
        repository.findById(id).ifPresent(projet -> {
            projet.getContenus().add("");
            repository.saveAndFlush(projet);
        });
    }

    public void removeContent(long id, int position) {
        repository.findById(id).ifPresent(projet -> {
            projet.getContenus().remove(position);
            repository.saveAndFlush(projet);
        });
    }
}
