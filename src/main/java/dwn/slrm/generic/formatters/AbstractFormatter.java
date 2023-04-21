package dwn.slrm.generic.formatters;

import dwn.slrm.business.exceptions.ReflexionException;
import dwn.slrm.generic.GenericTools;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;

public interface AbstractFormatter<DTO> extends Formatter<DTO> {
    @Override
    default DTO parse(String text, Locale locale) throws ParseException {
        DTO dto = GenericTools.callGenericConstructor(this.getClass(),0,0);
        try {
            Objects.requireNonNull(dto.getClass().getDeclaredMethod("setId", Long.class))
                    .invoke(dto,Long.parseLong(text));
            return dto;
        } catch (Exception e) {
            throw new ReflexionException(e.getMessage());
        }
    }

    @Override
    default String print(DTO object, Locale locale) {
        try {
            return Objects.toString(
                    Objects.requireNonNull(object.getClass().getDeclaredMethod("getId"))
                            .invoke(object),
                    "0");
        } catch (Exception e) {
            throw new ReflexionException(e.getMessage());
        }
    }
}
