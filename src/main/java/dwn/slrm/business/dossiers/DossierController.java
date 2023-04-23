package dwn.slrm.business.dossiers;

import dwn.slrm.business.projets.ProjetService;
import dwn.slrm.business.etudiants.EtudiantService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractAnnexableController;
import dwn.slrm.generic.controllers.AbstractCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(Constants.DOSSIERS_PATH)
public class DossierController extends AbstractAnnexableController<DossierProjet,DossierProjetDto, DossierRepository,DossierMapper,DossierService> {
    private final EtudiantService etudiantService;
    private final ProjetService projetService;
    public DossierController(DossierService service, EtudiantService etudiantService, ProjetService projetService) {
        super(service, Constants.DOSSIERS_PATH);
        this.etudiantService = etudiantService;
        this.projetService = projetService;
    }

    @Override
    @GetMapping("/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("students", etudiantService.all());
        model.addAttribute("projects", projetService.all());
        return super.get(id, model);
    }

    @Override
    @PostMapping
    public String save(@ModelAttribute("element") @Validated DossierProjetDto element, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("errors",result.getAllErrors());
            model.addAttribute("students", etudiantService.all());
            model.addAttribute("projects", projetService.all());
            return byIdPath;
        }
        return redirect(path,service.save(element).id);
    }
}
