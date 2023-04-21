package dwn.slrm.generic.mappers;

import dwn.slrm.generic.models.BaseEntity;

import java.util.List;
public interface DtoMapper<Entity,DTO>{

    DTO toDto(Entity entity);
    Entity toEntity(DTO dto);
    List<DTO> toDTO(Iterable<Entity> project);
    List<Entity> toEntity(Iterable<DTO> projects);
}
