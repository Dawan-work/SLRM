package dwn.slrm.business.resumes;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractCrudController;
import dwn.slrm.generic.enums.Langues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(Constants.RESUMES_PATH)
public class ResumeController extends AbstractCrudController<Resume, ResumeDto, ResumeRepo, ResumeMapper, ResumeService> {
    public ResumeController(ResumeService service) {
        super(service, Constants.RESUMES_PATH);
    }
    @GetMapping("/create/{id}/{langue}")
    public String create(@PathVariable long id, @PathVariable Langues langue, Model model) {
        model.addAttribute("element", new ResumeDto(0,0, langue, "",id));
        return byIdPath;
    }

    @Override
    @PostMapping
    public String save(@ModelAttribute("element") @Validated ResumeDto element, BindingResult result, Model model) {
        String returnString = super.save(element, result, model);
        return returnString.contentEquals(byIdPath) ? returnString : redirect(Constants.DOSSIERS_PATH + "/" + element.dossierId());
    }
}
