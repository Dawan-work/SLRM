package dwn.slrm.business.competences;

import dwn.slrm.generic.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompetenceMapper extends DtoMapper<Competence,CompetenceDto> {
}
