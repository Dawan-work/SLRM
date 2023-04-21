package dwn.slrm.business.etudiants;

import dwn.slrm.generic.mappers.DtoMapper;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface EtudiantMapper extends DtoMapper<Etudiant, EtudiantDto> {
}
