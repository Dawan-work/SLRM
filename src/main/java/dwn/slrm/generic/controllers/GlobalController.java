package dwn.slrm.generic.controllers;

import dwn.slrm.business.annexes.files.FileStorageService;
import dwn.slrm.generic.Constants;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@ControllerAdvice
@RequestMapping
public class GlobalController {

    private final FileStorageService service;

    public GlobalController(FileStorageService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "index";
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = service.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    @ModelAttribute("paths")
    public static List<String> getPaths() {
        return Arrays.stream(Constants.class.getDeclaredFields()).map(field -> {
            try {
                return (String)field.get(null);
            } catch (Exception e) {
                return null;
            }
        }).filter(Objects::nonNull).toList();
    }
}
