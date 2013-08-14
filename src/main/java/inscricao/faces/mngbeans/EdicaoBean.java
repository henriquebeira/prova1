package inscricao.faces.mngbeans;

import inscricao.entity.Revendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;

@ManagedBean
@SessionScoped
public class EdicaoBean extends PageBean {
        
   private ListDataModel<Revendedor> listaCandidatosDataModel;
   private RevendedoresBean candidatosBean;

    public EdicaoBean() {
       candidatosBean = ((RevendedoresBean)getBean("candidatosBean"));
       listaCandidatosDataModel = new ListDataModel<>(((RevendedoresBean)getBean("candidatosBean")).getListaCandidatos());
    }      
    
   public ListDataModel<Revendedor> getCandidatoDataModel() {
       return listaCandidatosDataModel;
   } 
    
    public String excluirAction() {
        Revendedor candidato = listaCandidatosDataModel.getRowData();
        candidatosBean.getListaCandidatos().remove(candidato);
        listaCandidatosDataModel = new ListDataModel<>(((RevendedoresBean)getBean("candidatosBean")).getListaCandidatos());
        return null;
    }
    
    public String editarAction() {
        InscricaoBean inscricaoBean = (InscricaoBean) getBean("inscricaoBean");
        inscricaoBean.setCandidato(listaCandidatosDataModel.getRowData());
        return inscricaoBean.alterar();
    }
}