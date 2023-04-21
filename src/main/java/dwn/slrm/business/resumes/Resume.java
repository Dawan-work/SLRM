package dwn.slrm.business.resumes;

import dwn.slrm.business.dossiers.DossierProjet;
import dwn.slrm.generic.enums.Langues;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume extends BaseEntity {
    private Langues langue;
    private String texte;
    @ManyToOne
    private DossierProjet dossier;
}
