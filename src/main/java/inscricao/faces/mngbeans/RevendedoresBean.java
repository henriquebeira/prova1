package inscricao.faces.mngbeans;

import inscricao.entity.Revendedor;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RevendedoresBean implements Serializable {
    
   private ArrayList<Revendedor> listaCandidatos = new ArrayList<Revendedor>();   

    public ArrayList<Revendedor> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(ArrayList<Revendedor> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }   
}