package ies.ed.solitario;

import java.util.List;


public class MontonJuego extends MontonComponent {
    public MontonJuego(){
        super();
    }
    @Override
     public  boolean esValidoamontonar(CartaComponent carta) {
        if(this.getChildren().size()==0 && carta.getNumero()=='K')
            return true;
        else{
            CartaComponent ultima=(CartaComponent)this.getChildren().get(this.getChildren().size()-1);
            if(!ultima.getColor().equals(carta.getColor()) &&
            CartaComponent.esSiguiente( carta,ultima))
                return true;
            else{
                return false;
            }
        }
    }
    @Override
    public  boolean esValidoamontonar(List<CartaComponent> cartas) {
       return true;
      
    }
    
}
