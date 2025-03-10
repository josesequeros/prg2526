







package ies.ed.solitario;
import java.util.List;




public class MontonPalo extends MontonComponent {
    public MontonPalo(){
        super();
        this.incy=0;
    }
    @Override
     public  boolean esValidoamontonar(CartaComponent carta) {
        if(this.getChildren().size()==0 && carta.getNumero()=='A')
            return true;
        else{
            CartaComponent ultima=(CartaComponent)this.getChildren().get(this.getChildren().size()-1);
            if(ultima.getPalo()==(carta.getPalo()) &&
            CartaComponent.esSiguiente( ultima,carta))
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
