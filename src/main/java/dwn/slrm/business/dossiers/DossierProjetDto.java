package dwn.slrm.business.dossiers;

import dwn.slrm.business.annexes.AnnexeDto;
import dwn.slrm.business.etudiants.EtudiantDto;
import dwn.slrm.business.projets.ProjetDto;
import dwn.slrm.business.resumes.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link DossierProjet} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DossierProjetDto  implements Serializable {
        Long id;
        Integer version;
        String annee;
        EtudiantDto candidat;
        ProjetDto projet;
        List<ResumeDto> resumes;
        List<AnnexeDto> annexes;
}
