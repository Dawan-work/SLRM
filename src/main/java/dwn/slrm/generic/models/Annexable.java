package dwn.slrm.generic.models;

import dwn.slrm.business.annexes.Annexe;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Annexable extends BaseEntity {
    @OneToMany
    private List<Annexe> annexes;
}
