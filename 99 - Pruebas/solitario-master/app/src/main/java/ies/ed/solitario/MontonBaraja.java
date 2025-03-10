package ies.ed.solitario;

import java.util.ArrayList;
import java.util.List;

public class MontonBaraja extends MontonComponent {
    public MontonBaraja(){
        super();
        this.incy=0;
    }
    
    public List<CartaComponent> vaciar(){
        ArrayList<CartaComponent> cartas= new ArrayList<>();
        System.out.println("Antes de "+this.getChildren().size());
        for(int i=this.getChildren().size()-1;i>=0;i--){
            cartas.add(this.desamontonar());
        }
        System.out.println("Devuelve "+cartas.size());
        return cartas;
    }
}
