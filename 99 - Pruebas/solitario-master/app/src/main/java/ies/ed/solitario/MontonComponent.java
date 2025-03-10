package ies.ed.solitario;

import ies.ed.solitario.CartaComponent;
import ies.ed.solitario.utils.ZonaIntercambio;

import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

/**
 *
 * @author pedro
 */
public class MontonComponent extends Pane {
    protected double startx = 0;
    protected  double starty = 0;
    protected  double incx = 0;
    protected  double incy = 20;

    public MontonComponent() {
        super();
        MontonComponent me = this;
        this.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                ((CartaComponent) getChildren().get(getChildren().size() - 1)).destapar();
                ;
            }

        });
        setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /*
                 * accept it only if it is not dragged from the same node
                 * and if it has a string data
                 */
                if (event.getGestureSource() != me
                        && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });

        setOnDragEntered(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != me
                        && event.getDragboard().hasString()) {
                    // otro.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {

                event.consume();
            }
        });

        setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();

                boolean success = false;
                if (db.hasString()) {
                    ZonaIntercambio z = ZonaIntercambio.getInstance();
                    //se valida el movimiento
                    System.out.println("validando"+esValidoamontonar(z.getCarta()));
                    if (!z.getOrigen().equals(me) && esValidoamontonar(z.getCarta())) {
                        z.getOrigen().desamontonar();
                        me.amontonar(z.getCarta());
                        z.clean();
                        success = true;
                    } else {
                        success = false;
                    }
                }
                event.setDropCompleted(success);

                event.consume();
            }
        });

    }

    public void amontonar(CartaComponent carta) {
        this.getChildren().add(carta);
        carta.setLayoutX(this.startx + this.getChildren().size() * incx);
        carta.setLayoutY(this.starty + this.getChildren().size() * incy);
        carta.setMontonComponent(this);
    }
   
    public void amontonar(List<CartaComponent> cartas) {
        for(int i=cartas.size()-1;i>=0;i--){
            this.amontonar(cartas.get(i));

        }
      
    }
   
    public CartaComponent desamontonar(){
        if(this.getChildren().size()==0)
        return null;
        else{
            //CartaComponent c=(CartaComponent)this.getChildren().get(this.getChildren().size()-1));
            CartaComponent c=(CartaComponent)this.getChildren().remove((this.getChildren().size()-1));
           
            c.setMontonComponent(null);
            return c;

        }
    }

   
    public List<CartaComponent> desamontonar(int index){
        if(this.getChildren().size()==0)
            return null;
        else{
            List<CartaComponent> cartas= new ArrayList<>();
            for(int i=this.getChildren().size()-1;i>=index;i--){
                cartas.set(this.getChildren().size()-index, this.desamontonar());
            
            }
            return cartas;

        }
    }

    public  boolean esValidoamontonar(CartaComponent carta) {
      return true;
    }
   
    public  boolean esValidoamontonar(List<CartaComponent> cartas) {
       return true;
      
    }
  
}
