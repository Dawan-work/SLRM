package dwn.slrm.generic.controllers;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.enums.Langues;
import dwn.slrm.generic.mappers.DtoMapper;
import dwn.slrm.generic.models.BaseEntity;
import dwn.slrm.generic.services.AbstractCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public abstract class AbstractCrudController<Entity extends BaseEntity,
        DTO,
        Repository extends JpaRepository<Entity,Long>,
        Mapper extends DtoMapper<Entity,DTO>,
        Service extends AbstractCrudService<Entity,DTO, Repository,Mapper>> {

    protected final Service service;
    protected final String path;
    protected final String allPath;
    protected final String byIdPath;

    protected AbstractCrudController(Service service, String path) {
        this.service = service;
        this.path = path;
        allPath = path + "/all";
        byIdPath = path + "/byId";
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("elements",service.all());
        return allPath;
    }
    @GetMapping("/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("element",service.get(id));
        return byIdPath;
    }
    @PostMapping
    public String save(@ModelAttribute("element") @Validated DTO element, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("element",element);
            return byIdPath;
        }
        service.save(element);
        return redirect(path);
    }
    @GetMapping("remove/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return  redirect(path);
    }

    protected String redirect(String path) {
        return "redirect:/" + path;
    }
    protected String redirect(String path, long id) {
        return redirect(path) + "/" + id;
    }

    @ModelAttribute("path")
    public String getPath() {
        return path;
    }
    @ModelAttribute("langues")
    public List<String> getLanges() {
        return Arrays.stream(Langues.values()).map(Enum::name).toList();
    }

    @ModelAttribute("paths")
    public static List<String> getPaths() {
        return GlobalController.getPaths();
    }
}
