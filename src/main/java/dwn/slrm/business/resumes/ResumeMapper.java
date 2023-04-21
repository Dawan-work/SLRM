package dwn.slrm.business.resumes;

import dwn.slrm.generic.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ResumeMapper extends DtoMapper<Resume, ResumeDto> {

    @Mapping(source = "dossier.id", target = "dossierId")
    ResumeDto toDto(Resume resume);

    @Mapping(source = "dossierId", target = "dossier.id")
    Resume toEntity(ResumeDto resumeDto);
}
