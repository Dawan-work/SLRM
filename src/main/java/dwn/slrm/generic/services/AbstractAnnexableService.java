package dwn.slrm.generic.services;

import dwn.slrm.business.exceptions.FileStorageException;
import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.generic.mappers.DtoMapper;
import dwn.slrm.generic.models.Annexable;
import dwn.slrm.generic.repositories.AnnexableRepository;
import dwn.slrm.business.annexes.files.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public abstract class AbstractAnnexableService
        <
            Entity extends Annexable,
            DTO,
            Repository extends AnnexableRepository<Entity,Long>,
            Mapper extends DtoMapper<Entity,DTO>
        > extends AbstractCrudService<Entity, DTO, Repository, Mapper>
{
    @Autowired
    private FileStorageService storageService;

    public AbstractAnnexableService(Repository repository, Mapper mapper) {
        super(repository, mapper);
    }
    
    public void deleteFileById(long id) {
        Annexe m = storageService.getById(id);
        Entity a = repository.findByAnnexes_Id(id);
        a.getAnnexes().remove(m);
        repository.save(a);
        storageService.delete(m);
    }

    public DTO addAnnexe(long id, MultipartFile file) throws NullPointerException, FileStorageException {
        String fileName = Objects.requireNonNull(file.getOriginalFilename());
        Entity a = repository.getReferenceById(id);
        Annexe m = a.getAnnexes().stream().filter(Annexe -> Annexe.getName().contentEquals(fileName)).findAny().orElse(storageService.saveFile(file, 'A' + fileName));
        if (!a.getAnnexes().contains(m)) {
            a.getAnnexes().add(m);
            a = repository.saveAndFlush(a);
        }
        return mapper.toDto(a);
    }

    public Resource load(String filename) {
        return storageService.load(filename);
    }
}
