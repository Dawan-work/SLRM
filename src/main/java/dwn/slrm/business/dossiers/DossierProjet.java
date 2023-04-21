package dwn.slrm.business.dossiers;

import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.generic.models.Annexable;
import dwn.slrm.generic.models.BaseEntity;
import dwn.slrm.business.etudiants.Etudiant;
import dwn.slrm.business.projets.Projet;
import dwn.slrm.business.resumes.Resume;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierProjet extends Annexable {
    private String annee;
    @ManyToOne
    private Etudiant candidat;
    @ManyToOne
    private Projet projet;
    @OneToMany(mappedBy = "dossier", orphanRemoval = true)
    private List<Resume> resumes;
}
