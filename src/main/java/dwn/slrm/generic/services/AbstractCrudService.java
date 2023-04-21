package dwn.slrm.generic.services;

import dwn.slrm.business.exceptions.ReflexionException;
import dwn.slrm.generic.GenericTools;
import dwn.slrm.generic.mappers.DtoMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.*;
import java.util.List;

public abstract class AbstractCrudService
        <
            Entity,
            DTO,
            Repository extends JpaRepository<Entity,Long>,
            Mapper extends DtoMapper<Entity,DTO>
        >
        implements IAbstractCrudService<Entity,DTO> {
    protected final Repository repository;
    protected final Mapper mapper;

    public AbstractCrudService(Repository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DTO> all() {
        return mapper.toDTO(repository.findAll());
    }

    public DTO get(long id) {
        return mapper.toDto(repository.findById(id).orElse(callEntityConstructor()));
    }
    public DTO save(DTO dto) {
        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }

    private Entity callEntityConstructor() {
        return GenericTools.callGenericConstructor(this.getClass(),0,0);
    }
}
