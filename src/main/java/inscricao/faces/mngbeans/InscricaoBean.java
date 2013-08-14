package inscricao.faces.mngbeans;

import inscricao.entity.Revendedor;
import inscricao.entity.Estado;
import inscricao.entity.Estado2;
import inscricao.entity.Regiao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;

@ManagedBean
@SessionScoped
public class InscricaoBean extends PageBean {
    private static final Estado[] estado = {
        new Estado(1, "São Paulo"),
        new Estado(2, "Paraná"),
        new Estado(3, "Santa Catarina"),
        new Estado(4, "Rio Grande do Sul"),
        new Estado(5, "Rio de Janeiro")
    };
    private static final Regiao[] regiao = {
        new Regiao(1, "Sul"),
        new Regiao(2, "Sudeste")
    };
    private static final Estado2[] estado2 = {
        new Estado2(1, "São Paulo"),
        new Estado2(2, "Paraná"),
        new Estado2(3, "Santa Catarina"),
        new Estado2(4, "Rio Grande do Sul"),
        new Estado2(5, "Rio de Janeiro")
    };
    private Revendedor novoCandidato = new Revendedor(); 
    private List<SelectItem> estadoItemList;
    private List<SelectItem> regiaoItemList;
    private List<SelectItem> estado2ItemList;
    private String valorConfirmar = "Continuar";
    private boolean mostraCNPJ = true;  
    
    public String alterar(){
        this.setMostraCNPJ(false);
        this.setValorConfirmar("Alterar");
        return "inscricao";
    }
    
    public String zerarFormulario(){
        novoCandidato = new Revendedor(); 
        this.setMostraCNPJ(true);
        this.setValorConfirmar("Confirmar Inscrição");
        return "inscricao";
    }    

    public Revendedor getNovoCandidato() {
        return novoCandidato;
    }

    public void setNovoCandidato(Revendedor novoCandidato) {
        this.novoCandidato = novoCandidato;
    }

    public String getValorConfirmar() {
        return valorConfirmar;
    }

    public void setValorConfirmar(String valorConfirmar) {
        this.valorConfirmar = valorConfirmar;
    }  

    public Revendedor getCandidato() {
        return novoCandidato;
    }

    public void setCandidato(Revendedor candidato) {
        this.novoCandidato = candidato;
    }

    public List<SelectItem> getEstadoItemList() {
        if (estadoItemList != null) return estadoItemList;
        estadoItemList = new ArrayList<>();
        for (Estado id: estado) {
            estadoItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return estadoItemList;
    }
    
    public List<SelectItem> getRegiaoItemList() {
        if (regiaoItemList != null) {
            return regiaoItemList;
        }
        regiaoItemList = new ArrayList<>();
        for (Regiao id : regiao) {
            regiaoItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return regiaoItemList;
    }
    
    public List<SelectItem> getEstado2ItemList() {
        if (estado2ItemList != null) {
            return estado2ItemList;
        }
        estado2ItemList = new ArrayList<>();
        for (Estado2 id : estado2) {
            estado2ItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return estadoItemList;
    }

    public String confirmaAction() {
        
        // Se estou inserindo um novo candidato
        if(mostraCNPJ){
            
            ArrayList<Revendedor> candidatos = ((RevendedoresBean)getBean("candidatosBean")).getListaCandidatos();        
            for(Revendedor candidato : candidatos){
                if(novoCandidato.getCnpj().equals(candidato.getCnpj())){
                    warn("Candidato já cadastrado!");                
                    return null;
                }
            }
            candidatos.add(novoCandidato);           
        } else { 
            
            // Se estou alterando um candidato
            this.setMostraCNPJ(true);
            this.setValorConfirmar("Confirmar Inscrição");
        }
        return "confirma";
    }
    
     public boolean isMostraCNPJ() {
        return !mostraCNPJ;
    }

    public void setMostraCNPJ(boolean mostraCNPJ) {
        this.mostraCNPJ = mostraCNPJ;
    }   
}
