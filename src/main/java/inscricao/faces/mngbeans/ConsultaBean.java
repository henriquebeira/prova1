package inscricao.faces.mngbeans;

import inscricao.entity.Revendedor;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;

@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {
    private String cpf = "";

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }  
    
    public String consultar() {   
        
        ArrayList<Revendedor> candidatos = ((RevendedoresBean)getBean("candidatosBean")).getListaCandidatos();    
        InscricaoBean inscricaoBean = (InscricaoBean)getBean("inscricaoBean");
        
        for(Revendedor candidato : candidatos){
                if(cpf.equals(candidato.getCnpj().toString())){                    
                    inscricaoBean.setNovoCandidato(candidato);
                    return inscricaoBean.alterar();
                }
            }
        warn("Candidato não encontrado!"); 
        return "consulta";
    }    
}
