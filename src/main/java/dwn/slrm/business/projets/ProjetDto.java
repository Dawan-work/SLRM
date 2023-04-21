package dwn.slrm.business.projets;

import dwn.slrm.business.competences.CompetenceDto;
import dwn.slrm.business.etudiants.EtudiantDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjetDto implements Serializable {
    Long id;
    Integer version;
    String nom;
    List<String> contenus;
    List<CompetenceDto> competences;
    List<EtudiantDto> participants;
}
