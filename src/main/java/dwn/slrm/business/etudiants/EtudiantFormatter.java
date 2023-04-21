package dwn.slrm.business.etudiants;

import dwn.slrm.generic.formatters.AbstractFormatter;
import org.springframework.stereotype.Component;

@Component
public class EtudiantFormatter /*implements Formatter<EtudiantDto> {
    @Override
    public EtudiantDto parse(String text, Locale locale) throws ParseException {
        EtudiantDto e = new EtudiantDto();
        e.setId(Long.parseLong(text));
        return e;
    }

    @Override
    public String print(EtudiantDto object, Locale locale) {
        return object.getId().toString();
    }
}*/ implements AbstractFormatter<EtudiantDto> {}
