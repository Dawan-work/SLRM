package dwn.slrm.business.etudiants;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(Constants.ETUDIANTS_PATH)
public class EtudiantController extends AbstractCrudController<Etudiant, EtudiantDto, EtudiantRepo, EtudiantMapper, EtudiantService> {
    public EtudiantController(EtudiantService service) {
        super(service, Constants.ETUDIANTS_PATH);
    }
}
