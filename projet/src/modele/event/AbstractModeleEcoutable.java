package  event;
import java.util.ArrayList;

public abstract class AbstractModeleEcoutable  implements ModeleEcoutable{
    private ArrayList<EcouteurModele> ecouteurs = new ArrayList<>();
    
    public void ajouterEcouteur(EcouteurModele e){
        ecouteurs.add(e);
    }
    public void retirerEcouteur(EcouteurModele e){
        ecouteurs.remove(e);
    }
    
    protected void fireChangement(){
        for(EcouteurModele e : ecouteurs){
            e.modeleMiseAJour(this);
        }
    
    }
    
}
