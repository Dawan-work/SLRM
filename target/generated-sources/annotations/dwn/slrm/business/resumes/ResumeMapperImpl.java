package dwn.slrm.business.resumes;

import dwn.slrm.business.dossiers.DossierProjet;
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
public class ResumeMapperImpl implements ResumeMapper {

    @Override
    public List<ResumeDto> toDTO(Iterable<Resume> project) {
        if ( project == null ) {
            return new ArrayList<ResumeDto>();
        }

        List<ResumeDto> list = new ArrayList<ResumeDto>();
        for ( Resume resume : project ) {
            list.add( toDto( resume ) );
        }

        return list;
    }

    @Override
    public List<Resume> toEntity(Iterable<ResumeDto> projects) {
        if ( projects == null ) {
            return new ArrayList<Resume>();
        }

        List<Resume> list = new ArrayList<Resume>();
        for ( ResumeDto resumeDto : projects ) {
            list.add( toEntity( resumeDto ) );
        }

        return list;
    }

    @Override
    public ResumeDto toDto(Resume resume) {
        if ( resume == null ) {
            return null;
        }

        Long dossierId = null;
        long id = 0L;
        int version = 0;
        Langues langue = null;
        String texte = null;

        dossierId = resumeDossierId( resume );
        id = resume.getId();
        version = resume.getVersion();
        langue = resume.getLangue();
        texte = resume.getTexte();

        ResumeDto resumeDto = new ResumeDto( id, version, langue, texte, dossierId );

        return resumeDto;
    }

    @Override
    public Resume toEntity(ResumeDto resumeDto) {
        if ( resumeDto == null ) {
            return null;
        }

        Resume resume = new Resume();

        resume.setDossier( resumeDtoToDossierProjet( resumeDto ) );
        resume.setId( resumeDto.id() );
        resume.setVersion( resumeDto.version() );
        resume.setLangue( resumeDto.langue() );
        resume.setTexte( resumeDto.texte() );

        return resume;
    }

    private Long resumeDossierId(Resume resume) {
        if ( resume == null ) {
            return null;
        }
        DossierProjet dossier = resume.getDossier();
        if ( dossier == null ) {
            return null;
        }
        long id = dossier.getId();
        return id;
    }

    protected DossierProjet resumeDtoToDossierProjet(ResumeDto resumeDto) {
        if ( resumeDto == null ) {
            return null;
        }

        DossierProjet dossierProjet = new DossierProjet();

        if ( resumeDto.dossierId() != null ) {
            dossierProjet.setId( resumeDto.dossierId() );
        }

        return dossierProjet;
    }
}
