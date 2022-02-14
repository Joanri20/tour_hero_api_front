package co.udea.hero.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Helper to simplify accessing i18n messages in code.
 */
@Component
public class Messages {
	
	@Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    public String get(String code) {
        try {
            return accessor.getMessage(code);
        } catch (NoSuchMessageException exception) {
            return "No hay mensaje disponible para mostrar.";
        }
        
    }

}