package dwn.slrm.business.competences;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(Constants.COMPETENCES_PATH)
public class CompetenceController extends AbstractCrudController<Competence, CompetenceDto, CompetenceRepo, CompetenceMapper, CompetenceService> {
    public CompetenceController(CompetenceService service) {
        super(service, Constants.COMPETENCES_PATH);
    }
}
