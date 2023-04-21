package dwn.slrm.business.competences;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T15:34:05+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CompetenceMapperImpl implements CompetenceMapper {

    @Override
    public CompetenceDto toDto(Competence entity) {
        if ( entity == null ) {
            return null;
        }

        CompetenceDto competenceDto = new CompetenceDto();

        competenceDto.setId( entity.getId() );
        competenceDto.setVersion( entity.getVersion() );
        competenceDto.setNom( entity.getNom() );

        return competenceDto;
    }

    @Override
    public Competence toEntity(CompetenceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Competence competence = new Competence();

        if ( dto.getId() != null ) {
            competence.setId( dto.getId() );
        }
        competence.setVersion( dto.getVersion() );
        competence.setNom( dto.getNom() );

        return competence;
    }

    @Override
    public List<CompetenceDto> toDTO(Iterable<Competence> project) {
        if ( project == null ) {
            return new ArrayList<CompetenceDto>();
        }

        List<CompetenceDto> list = new ArrayList<CompetenceDto>();
        for ( Competence competence : project ) {
            list.add( toDto( competence ) );
        }

        return list;
    }

    @Override
    public List<Competence> toEntity(Iterable<CompetenceDto> projects) {
        if ( projects == null ) {
            return new ArrayList<Competence>();
        }

        List<Competence> list = new ArrayList<Competence>();
        for ( CompetenceDto competenceDto : projects ) {
            list.add( toEntity( competenceDto ) );
        }

        return list;
    }
}
