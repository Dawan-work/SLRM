package dwn.slrm.business.annexes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:23:02+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class AnnexeMapperImpl implements AnnexeMapper {

    @Override
    public AnnexeDto toDto(Annexe entity) {
        if ( entity == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        String extension = null;
        String type = null;

        id = entity.getId();
        name = entity.getName();
        extension = entity.getExtension();
        type = entity.getType();

        AnnexeDto annexeDto = new AnnexeDto( id, name, extension, type );

        return annexeDto;
    }

    @Override
    public Annexe toEntity(AnnexeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Annexe annexe = new Annexe();

        annexe.setId( dto.id() );
        annexe.setName( dto.name() );
        annexe.setExtension( dto.extension() );
        annexe.setType( dto.type() );

        return annexe;
    }

    @Override
    public List<AnnexeDto> toDTO(Iterable<Annexe> project) {
        if ( project == null ) {
            return new ArrayList<AnnexeDto>();
        }

        List<AnnexeDto> list = new ArrayList<AnnexeDto>();
        for ( Annexe annexe : project ) {
            list.add( toDto( annexe ) );
        }

        return list;
    }

    @Override
    public List<Annexe> toEntity(Iterable<AnnexeDto> projects) {
        if ( projects == null ) {
            return new ArrayList<Annexe>();
        }

        List<Annexe> list = new ArrayList<Annexe>();
        for ( AnnexeDto annexeDto : projects ) {
            list.add( toEntity( annexeDto ) );
        }

        return list;
    }
}
