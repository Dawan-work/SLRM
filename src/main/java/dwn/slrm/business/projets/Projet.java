package dwn.slrm.business.projets;

import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.business.competences.Competence;
import dwn.slrm.business.etudiants.Etudiant;
import dwn.slrm.generic.models.Annexable;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet extends BaseEntity {
    private String nom;
    @ElementCollection
    private List<String> contenus;
    @ManyToMany
    private List<Competence> competences;
    @ManyToMany
    private List<Etudiant> participants;
}
