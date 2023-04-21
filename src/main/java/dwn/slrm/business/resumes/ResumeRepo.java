package dwn.slrm.business.resumes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepo  extends JpaRepository<Resume,Long> {
}
