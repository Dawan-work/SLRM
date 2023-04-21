package dwn.slrm.generic.controllers;

import dwn.slrm.generic.Constants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@ControllerAdvice
@RequestMapping
public class GlobalController {
    @GetMapping
    public String index() {
        return "index";
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
