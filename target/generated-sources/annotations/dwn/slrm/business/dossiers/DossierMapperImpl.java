package dwn.slrm.business.dossiers;

import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.business.annexes.AnnexeDto;
import dwn.slrm.business.competences.Competence;
import dwn.slrm.business.competences.CompetenceDto;
import dwn.slrm.business.etudiants.Etudiant;
import dwn.slrm.business.etudiants.EtudiantDto;
import dwn.slrm.business.projets.Projet;
import dwn.slrm.business.projets.ProjetDto;
import dwn.slrm.business.resumes.Resume;
import dwn.slrm.business.resumes.ResumeDto;
import dwn.slrm.generic.enums.Langues;
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
public class DossierMapperImpl implements DossierMapper {

    @Override
    public DossierProjetDto toDto(DossierProjet entity) {
        if ( entity == null ) {
            return null;
        }

        DossierProjetDto dossierProjetDto = new DossierProjetDto();

        dossierProjetDto.setId( entity.getId() );
        dossierProjetDto.setVersion( entity.getVersion() );
        dossierProjetDto.setAnnee( entity.getAnnee() );
        dossierProjetDto.setCandidat( etudiantToEtudiantDto( entity.getCandidat() ) );
        dossierProjetDto.setProjet( projetToProjetDto( entity.getProjet() ) );
        dossierProjetDto.setResumes( resumeListToResumeDtoList( entity.getResumes() ) );
        dossierProjetDto.setAnnexes( annexeListToAnnexeDtoList( entity.getAnnexes() ) );

        return dossierProjetDto;
    }

    @Override
    public DossierProjet toEntity(DossierProjetDto dto) {
        if ( dto == null ) {
            return null;
        }

        DossierProjet dossierProjet = new DossierProjet();

        if ( dto.getId() != null ) {
            dossierProjet.setId( dto.getId() );
        }
        if ( dto.getVersion() != null ) {
            dossierProjet.setVersion( dto.getVersion() );
        }
        dossierProjet.setAnnexes( annexeDtoListToAnnexeList( dto.getAnnexes() ) );
        dossierProjet.setAnnee( dto.getAnnee() );
        dossierProjet.setCandidat( etudiantDtoToEtudiant( dto.getCandidat() ) );
        dossierProjet.setProjet( projetDtoToProjet( dto.getProjet() ) );
        dossierProjet.setResumes( resumeDtoListToResumeList( dto.getResumes() ) );

        return dossierProjet;
    }

    @Override
    public List<DossierProjetDto> toDTO(Iterable<DossierProjet> project) {
        if ( project == null ) {
            return new ArrayList<DossierProjetDto>();
        }

        List<DossierProjetDto> list = new ArrayList<DossierProjetDto>();
        for ( DossierProjet dossierProjet : project ) {
            list.add( toDto( dossierProjet ) );
        }

        return list;
    }

    @Override
    public List<DossierProjet> toEntity(Iterable<DossierProjetDto> projects) {
        if ( projects == null ) {
            return new ArrayList<DossierProjet>();
        }

        List<DossierProjet> list = new ArrayList<DossierProjet>();
        for ( DossierProjetDto dossierProjetDto : projects ) {
            list.add( toEntity( dossierProjetDto ) );
        }

        return list;
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

    protected ProjetDto projetToProjetDto(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDto projetDto = new ProjetDto();

        projetDto.setId( projet.getId() );
        projetDto.setVersion( projet.getVersion() );
        projetDto.setNom( projet.getNom() );
        List<String> list = projet.getContenus();
        if ( list != null ) {
            projetDto.setContenus( new ArrayList<String>( list ) );
        }
        projetDto.setCompetences( competenceListToCompetenceDtoList( projet.getCompetences() ) );
        projetDto.setParticipants( etudiantListToEtudiantDtoList( projet.getParticipants() ) );

        return projetDto;
    }

    protected ResumeDto resumeToResumeDto(Resume resume) {
        if ( resume == null ) {
            return null;
        }

        long id = 0L;
        int version = 0;
        Langues langue = null;
        String texte = null;

        id = resume.getId();
        version = resume.getVersion();
        langue = resume.getLangue();
        texte = resume.getTexte();

        Long dossierId = null;

        ResumeDto resumeDto = new ResumeDto( id, version, langue, texte, dossierId );

        return resumeDto;
    }

    protected List<ResumeDto> resumeListToResumeDtoList(List<Resume> list) {
        if ( list == null ) {
            return new ArrayList<ResumeDto>();
        }

        List<ResumeDto> list1 = new ArrayList<ResumeDto>( list.size() );
        for ( Resume resume : list ) {
            list1.add( resumeToResumeDto( resume ) );
        }

        return list1;
    }

    protected AnnexeDto annexeToAnnexeDto(Annexe annexe) {
        if ( annexe == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        String extension = null;
        String type = null;

        id = annexe.getId();
        name = annexe.getName();
        extension = annexe.getExtension();
        type = annexe.getType();

        AnnexeDto annexeDto = new AnnexeDto( id, name, extension, type );

        return annexeDto;
    }

    protected List<AnnexeDto> annexeListToAnnexeDtoList(List<Annexe> list) {
        if ( list == null ) {
            return new ArrayList<AnnexeDto>();
        }

        List<AnnexeDto> list1 = new ArrayList<AnnexeDto>( list.size() );
        for ( Annexe annexe : list ) {
            list1.add( annexeToAnnexeDto( annexe ) );
        }

        return list1;
    }

    protected Annexe annexeDtoToAnnexe(AnnexeDto annexeDto) {
        if ( annexeDto == null ) {
            return null;
        }

        Annexe annexe = new Annexe();

        annexe.setId( annexeDto.id() );
        annexe.setName( annexeDto.name() );
        annexe.setExtension( annexeDto.extension() );
        annexe.setType( annexeDto.type() );

        return annexe;
    }

    protected List<Annexe> annexeDtoListToAnnexeList(List<AnnexeDto> list) {
        if ( list == null ) {
            return new ArrayList<Annexe>();
        }

        List<Annexe> list1 = new ArrayList<Annexe>( list.size() );
        for ( AnnexeDto annexeDto : list ) {
            list1.add( annexeDtoToAnnexe( annexeDto ) );
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

    protected Projet projetDtoToProjet(ProjetDto projetDto) {
        if ( projetDto == null ) {
            return null;
        }

        Projet projet = new Projet();

        if ( projetDto.getId() != null ) {
            projet.setId( projetDto.getId() );
        }
        if ( projetDto.getVersion() != null ) {
            projet.setVersion( projetDto.getVersion() );
        }
        projet.setNom( projetDto.getNom() );
        List<String> list = projetDto.getContenus();
        if ( list != null ) {
            projet.setContenus( new ArrayList<String>( list ) );
        }
        projet.setCompetences( competenceDtoListToCompetenceList( projetDto.getCompetences() ) );
        projet.setParticipants( etudiantDtoListToEtudiantList( projetDto.getParticipants() ) );

        return projet;
    }

    protected Resume resumeDtoToResume(ResumeDto resumeDto) {
        if ( resumeDto == null ) {
            return null;
        }

        Resume resume = new Resume();

        resume.setId( resumeDto.id() );
        resume.setVersion( resumeDto.version() );
        resume.setLangue( resumeDto.langue() );
        resume.setTexte( resumeDto.texte() );

        return resume;
    }

    protected List<Resume> resumeDtoListToResumeList(List<ResumeDto> list) {
        if ( list == null ) {
            return new ArrayList<Resume>();
        }

        List<Resume> list1 = new ArrayList<Resume>( list.size() );
        for ( ResumeDto resumeDto : list ) {
            list1.add( resumeDtoToResume( resumeDto ) );
        }

        return list1;
    }
}
