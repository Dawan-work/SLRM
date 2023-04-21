package dwn.slrm.business.projets;

import dwn.slrm.business.competences.CompetenceService;
import dwn.slrm.business.etudiants.EtudiantService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(Constants.PROJETS_PATH)
public class ProjetController extends AbstractCrudController<Projet, ProjetDto, ProjetRepo, ProjetMapper, ProjetService> {
    private final EtudiantService etudiantService;
    private final CompetenceService competencesService;
    public ProjetController(ProjetService service, EtudiantService etudiantService, CompetenceService competencesService) {
        super(service, Constants.PROJETS_PATH);
        this.etudiantService = etudiantService;
        this.competencesService = competencesService;
    }

    @GetMapping("/addContent/{id}")
    public String addContent(@PathVariable long id) {
        service.addContent(id);
        return redirect(path,id);
    }
    @GetMapping("/removeContent/{id}/{position}")
    public String addContent(@PathVariable long id, @PathVariable int position) {
        service.removeContent(id,position);
        return redirect(path,id);
    }
    @Override
    @GetMapping("/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("students", etudiantService.all());
        model.addAttribute("comps", competencesService.all());
        return super.get(id, model);
    }

    @Override
    @PostMapping
    public String save(@ModelAttribute("element") @Validated ProjetDto element, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("students", etudiantService.all());
            model.addAttribute("comps", competencesService.all());
        }
        return super.save(element, result, model);
    }
}
