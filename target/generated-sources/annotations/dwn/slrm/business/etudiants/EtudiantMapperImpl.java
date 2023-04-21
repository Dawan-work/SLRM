package dwn.slrm.business.etudiants;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T15:34:06+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class EtudiantMapperImpl implements EtudiantMapper {

    @Override
    public EtudiantDto toDto(Etudiant entity) {
        if ( entity == null ) {
            return null;
        }

        EtudiantDto etudiantDto = new EtudiantDto();

        etudiantDto.setId( entity.getId() );
        etudiantDto.setVersion( entity.getVersion() );
        etudiantDto.setNom( entity.getNom() );
        etudiantDto.setPrenom( entity.getPrenom() );

        return etudiantDto;
    }

    @Override
    public Etudiant toEntity(EtudiantDto dto) {
        if ( dto == null ) {
            return null;
        }

        Etudiant etudiant = new Etudiant();

        if ( dto.getId() != null ) {
            etudiant.setId( dto.getId() );
        }
        if ( dto.getVersion() != null ) {
            etudiant.setVersion( dto.getVersion() );
        }
        etudiant.setNom( dto.getNom() );
        etudiant.setPrenom( dto.getPrenom() );

        return etudiant;
    }

    @Override
    public List<EtudiantDto> toDTO(Iterable<Etudiant> project) {
        if ( project == null ) {
            return new ArrayList<EtudiantDto>();
        }

        List<EtudiantDto> list = new ArrayList<EtudiantDto>();
        for ( Etudiant etudiant : project ) {
            list.add( toDto( etudiant ) );
        }

        return list;
    }

    @Override
    public List<Etudiant> toEntity(Iterable<EtudiantDto> projects) {
        if ( projects == null ) {
            return new ArrayList<Etudiant>();
        }

        List<Etudiant> list = new ArrayList<Etudiant>();
        for ( EtudiantDto etudiantDto : projects ) {
            list.add( toEntity( etudiantDto ) );
        }

        return list;
    }
}
