package inscricao.faces.mngbeans;

import inscricao.entity.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;

@ManagedBean
@RequestScoped
public class LoginBean extends PageBean {
    
    private Login login = new Login();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }    
    
    public String confirmaAction() {
        
        // Verifica se a senha bate com uma senha hardcoded
        if (login.getLogin().trim().equals("charao") && login.getSenha().trim().equals("charao")) {
            return "inicio";
        }
        return null;
    }    
}