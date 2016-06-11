package validations;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("noLettersHerePls")
public class NoLettersHerePls implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		boolean valido = false;
		String parametro = (String) arg2;
		for (int i = 0; i < parametro.length(); i++) {
			valido = Character.isAlphabetic(parametro.charAt(i));
		}
		if (!valido) {
			throw new  ValidatorException(new FacesMessage("Debe ser un número Bitch!"));
		}
	}
}
