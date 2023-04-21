package dwn.slrm.business.resumes;
import dwn.slrm.generic.services.AbstractCrudService;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ResumeService extends AbstractCrudService<Resume, ResumeDto, ResumeRepo, ResumeMapper> implements IAbstractCrudService<Resume,ResumeDto> {
    public ResumeService(ResumeRepo repository, ResumeMapper mapper) {
        super(repository, mapper);
    }
}
