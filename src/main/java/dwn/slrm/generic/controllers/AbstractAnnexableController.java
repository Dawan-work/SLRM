package dwn.slrm.generic.controllers;

import dwn.slrm.generic.mappers.DtoMapper;
import dwn.slrm.generic.models.Annexable;
import dwn.slrm.generic.repositories.AnnexableRepository;
import dwn.slrm.generic.services.AbstractAnnexableService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

public class AbstractAnnexableController<Entity extends Annexable,
        DTO,
        Repository extends AnnexableRepository<Entity,Long>,
        Mapper extends DtoMapper<Entity,DTO>,
        Service extends AbstractAnnexableService<Entity,DTO, Repository,Mapper>> extends AbstractCrudController<Entity, DTO, Repository, Mapper, Service>{
    protected AbstractAnnexableController(Service service, String path) {
        super(service, path);
    }

    @PostMapping("/{id}")
    public String upload(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        service.addAnnexe(id, file);
        return redirect(path,id);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = service.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping(value = "/{id}")
    public String remove(@PathVariable(name = "id") long id) {
        service.deleteFileById(id);
        return redirect(path,id);
    }
}
