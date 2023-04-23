package dwn.slrm.business.projets;

import dwn.slrm.business.competences.Competence;
import dwn.slrm.business.competences.CompetenceDto;
import dwn.slrm.business.etudiants.Etudiant;
import dwn.slrm.business.etudiants.EtudiantDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:23:03+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Override
    public ProjetDto toDto(Projet entity) {
        if ( entity == null ) {
            return null;
        }

        ProjetDto projetDto = new ProjetDto();

        projetDto.setId( entity.getId() );
        projetDto.setVersion( entity.getVersion() );
        projetDto.setNom( entity.getNom() );
        List<String> list = entity.getContenus();
        if ( list != null ) {
            projetDto.setContenus( new ArrayList<String>( list ) );
        }
        projetDto.setCompetences( competenceListToCompetenceDtoList( entity.getCompetences() ) );
        projetDto.setParticipants( etudiantListToEtudiantDtoList( entity.getParticipants() ) );

        return projetDto;
    }

    @Override
    public Projet toEntity(ProjetDto dto) {
        if ( dto == null ) {
            return null;
        }

        Projet projet = new Projet();

        if ( dto.getId() != null ) {
            projet.setId( dto.getId() );
        }
        if ( dto.getVersion() != null ) {
            projet.setVersion( dto.getVersion() );
        }
        projet.setNom( dto.getNom() );
        List<String> list = dto.getContenus();
        if ( list != null ) {
            projet.setContenus( new ArrayList<String>( list ) );
        }
        projet.setCompetences( competenceDtoListToCompetenceList( dto.getCompetences() ) );
        projet.setParticipants( etudiantDtoListToEtudiantList( dto.getParticipants() ) );

        return projet;
    }

    @Override
    public List<ProjetDto> toDTO(Iterable<Projet> project) {
        if ( project == null ) {
            return new ArrayList<ProjetDto>();
        }

        List<ProjetDto> list = new ArrayList<ProjetDto>();
        for ( Projet projet : project ) {
            list.add( toDto( projet ) );
        }

        return list;
    }

    @Override
    public List<Projet> toEntity(Iterable<ProjetDto> projects) {
        if ( projects == null ) {
            return new ArrayList<Projet>();
        }

        List<Projet> list = new ArrayList<Projet>();
        for ( ProjetDto projetDto : projects ) {
            list.add( toEntity( projetDto ) );
        }

        return list;
    }

    protected CompetenceDto competenceToCompetenceDto(Competence competence) {
        if ( competence == null ) {
            return null;
        }

        CompetenceDto competenceDto = new CompetenceDto();

        competenceDto.setId( competence.getId() );
        competenceDto.setVersion( competence.getVersion() );
        competenceDto.setNom( competence.getNom() );

        return competenceDto;
    }

    protected List<CompetenceDto> competenceListToCompetenceDtoList(List<Competence> list) {
        if ( list == null ) {
            return new ArrayList<CompetenceDto>();
        }

        List<CompetenceDto> list1 = new ArrayList<CompetenceDto>( list.size() );
        for ( Competence competence : list ) {
            list1.add( competenceToCompetenceDto( competence ) );
        }

        return list1;
    }

    protected EtudiantDto etudiantToEtudiantDto(Etudiant etudiant) {
        if ( etudiant == null ) {
            return null;
        }

        EtudiantDto etudiantDto = new EtudiantDto();

        etudiantDto.setId( etudiant.getId() );
        etudiantDto.setVersion( etudiant.getVersion() );
        etudiantDto.setNom( etudiant.getNom() );
        etudiantDto.setPrenom( etudiant.getPrenom() );

        return etudiantDto;
    }

    protected List<EtudiantDto> etudiantListToEtudiantDtoList(List<Etudiant> list) {
        if ( list == null ) {
            return new ArrayList<EtudiantDto>();
        }

        List<EtudiantDto> list1 = new ArrayList<EtudiantDto>( list.size() );
        for ( Etudiant etudiant : list ) {
            list1.add( etudiantToEtudiantDto( etudiant ) );
        }

        return list1;
    }

    protected Competence competenceDtoToCompetence(CompetenceDto competenceDto) {
        if ( competenceDto == null ) {
            return null;
        }

        Competence competence = new Competence();

        if ( competenceDto.getId() != null ) {
            competence.setId( competenceDto.getId() );
        }
        competence.setVersion( competenceDto.getVersion() );
        competence.setNom( competenceDto.getNom() );

        return competence;
    }

    protected List<Competence> competenceDtoListToCompetenceList(List<CompetenceDto> list) {
        if ( list == null ) {
            return new ArrayList<Competence>();
        }

        List<Competence> list1 = new ArrayList<Competence>( list.size() );
        for ( CompetenceDto competenceDto : list ) {
            list1.add( competenceDtoToCompetence( competenceDto ) );
        }

        return list1;
    }

    protected Etudiant etudiantDtoToEtudiant(EtudiantDto etudiantDto) {
        if ( etudiantDto == null ) {
            return null;
        }

        Etudiant etudiant = new Etudiant();

        if ( etudiantDto.getId() != null ) {
            etudiant.setId( etudiantDto.getId() );
        }
        if ( etudiantDto.getVersion() != null ) {
            etudiant.setVersion( etudiantDto.getVersion() );
        }
        etudiant.setNom( etudiantDto.getNom() );
        etudiant.setPrenom( etudiantDto.getPrenom() );

        return etudiant;
    }

    protected List<Etudiant> etudiantDtoListToEtudiantList(List<EtudiantDto> list) {
        if ( list == null ) {
            return new ArrayList<Etudiant>();
        }

        List<Etudiant> list1 = new ArrayList<Etudiant>( list.size() );
        for ( EtudiantDto etudiantDto : list ) {
            list1.add( etudiantDtoToEtudiant( etudiantDto ) );
        }

        return list1;
    }
}
