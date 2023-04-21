package dwn.slrm.generic.services;

import java.util.List;

public interface IAbstractCrudService<Entity,DTO> {
    List<DTO> all();
    DTO get(long id);
    DTO save(DTO entity);
    void delete(long id);
}
