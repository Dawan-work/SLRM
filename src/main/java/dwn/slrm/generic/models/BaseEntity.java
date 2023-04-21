package dwn.slrm.generic.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * The type Base entity.
 */
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;
}
