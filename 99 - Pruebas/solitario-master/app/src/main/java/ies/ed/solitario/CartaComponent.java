/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.ed.solitario;

import ies.ed.solitario.utils.ZonaIntercambio;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 *
 * @author pedro
 */
public class CartaComponent extends ImageView {

    private Image anverso;
    private Image reverso;
    private char  palo;
    private char numero;
    public enum Color{
        ROJO,
        NEGRO
    }
    private Color color;
    private MontonComponent montonComponent;
    private final StringProperty anverso_path = new SimpleStringProperty();

    public CartaComponent() {
        super();

        //anverso = new Image(getClass().getResource("/png/1B.png").toString());
        reverso = new Image(getClass().getResource("/png/1B.png").toString());
        this.setImage(reverso);
        this.setFitHeight(126);//100
        this.setFitWidth(90);
        this.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {

                }

                event.consume();
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                //reverse();
            }

        });
        CartaComponent me=this;
        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(toString());
                ZonaIntercambio z= ZonaIntercambio.getInstance();
                z.setCarta(me);
                z.setOrigen(me.getMontonComponent());
                db.setContent(content);

                event.consume();
            }

        });

    }

    public CartaComponent(String path) {
        super();
      
          anverso = new Image("/png/2B.png");
          this.anverso_path.set(path);
         this.setImage(anverso);

    }
   
    public char getPalo() {
        return palo;
    }
    
    public void setPalo(char palo) {
        this.palo = palo;
        if(palo=='D' || palo=='H')
            this.color=Color.ROJO;
        else
            this.color=Color.NEGRO;
    }
    public Color getColor(){
        return this.color;
    }
    public static boolean esSiguiente(CartaComponent carta_actual,CartaComponent carta_siguiente){
        char actual=carta_actual.numero;
        char siguiente=carta_siguiente.numero;
        System.out.println("actual: "+actual+" siguiente: "+siguiente );
        if(actual=='A' && siguiente=='2'
        || actual=='9' && siguiente=='T' 
        || actual=='T' && siguiente=='J' 
        || actual=='J' && siguiente=='Q' || 
        actual=='Q' && siguiente=='K' ||
        //coincide en número
        (siguiente-'0')-(actual-'0')==1){
            return true;
        }else{

            return false;
        }
            
    }
    public char getNumero() {
        return numero;
    }

    public void setNumero(char numero) {
        this.numero = numero;
    }
    /**
     * @return the montonComponent
     */
    public MontonComponent getMontonComponent() {
        return montonComponent;
    }

    /**
     * @param montonComponent the montonComponent to set
     */
    public void setMontonComponent(MontonComponent montonComponent) {
        this.montonComponent = montonComponent;
    }
   
    public final StringProperty anversoProperty() {
        return this.anverso_path;
    }

    public final String getAnverso() {
        return anverso_path.get();
    }

    public final void setAnverso(String anversopath) {
        this.anverso_path.set(anversopath);
        anverso = new Image(getClass().getResource(anversopath).toString());
    }

    public void reverse() {
        if (this.getImage().equals(this.anverso)) {
            this.setImage(this.reverso);
        } else {
            this.setImage(this.anverso);
        }
    }
    public void tapar(){
        this.setImage(this.reverso);
    }
    public void destapar(){
        this.setImage(this.anverso);
    }
    

}
