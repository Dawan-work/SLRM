package dwn.slrm.business.etudiants;

import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends BaseEntity {
    private String nom;
    private String prenom;
    private boolean active = true;
}
