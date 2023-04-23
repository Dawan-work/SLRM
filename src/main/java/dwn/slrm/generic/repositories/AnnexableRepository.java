package dwn.slrm.generic.repositories;

import dwn.slrm.generic.models.Annexable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AnnexableRepository<Entity extends Annexable,ID> extends JpaRepository<Entity,ID> {
    Entity findByAnnexes_Id(long id);
}
