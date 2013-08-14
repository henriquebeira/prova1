/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Wilson
 */
@FacesValidator("CNPJValidator")
public class CNPJValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cnpj = String.format("%014d", (Long) o);
        
        if (!cnpj.matches("\\d{11}")) {
            throw new ValidatorException(new FacesMessage("CNPJ \'" + cnpj + "\' em formato incorreto."));
        } else {
            long oitoDigitosAntes = Long.parseLong(cnpj.substring(0, 8));
            long quatroDigitosDepois = Long.parseLong(cnpj.substring(8, 12));
            
            if ((oitoDigitosAntes <= 0) || (quatroDigitosDepois <= 0)) {
                throw new ValidatorException(new FacesMessage("CNPJ \'" + cnpj + "\' inválido"));
            }
        }
    }
    
}
