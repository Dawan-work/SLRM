package dwn.slrm.business.etudiants;

import dwn.slrm.generic.services.AbstractCrudService;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService extends AbstractCrudService<Etudiant, EtudiantDto, EtudiantRepo, EtudiantMapper> implements IAbstractCrudService<Etudiant,EtudiantDto> {

    public EtudiantService(EtudiantRepo repository, EtudiantMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<EtudiantDto> all() {
        return mapper.toDTO(repository.findAll().stream().filter(Etudiant::isActive).toList());
    }

    @Override
    public EtudiantDto save(EtudiantDto etudiantDto) {
        Optional<Etudiant> byNomAndPrenom = repository.findByNomAndPrenom(etudiantDto.getNom(), etudiantDto.getPrenom());
        return byNomAndPrenom
                .map(etudiant -> {
                    if(!etudiant.isActive()){
                        etudiant.setActive(true);
                        etudiant = repository.save(etudiant);
                    }
                    return mapper.toDto(etudiant);
                })
                .orElseGet(() -> super.save(etudiantDto));
    }
}
