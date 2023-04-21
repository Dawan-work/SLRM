package dwn.slrm.business.resumes;

import dwn.slrm.generic.enums.Langues;

import java.io.Serializable;

/**
 * A DTO for the {@link Resume} entity
 */
public record ResumeDto(long id, int version, Langues langue, String texte, Long dossierId) implements Serializable {
}
