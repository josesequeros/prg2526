package ies.ed.solitario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.checkerframework.common.value.qual.ArrayLen;

import ies.ed.solitario.utils.ZonaIntercambio;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class BarajaComponent extends Pane {
    private double startx = 0;
    private double starty = 0;
    private double incx = 0;
    private double incy = 0;
    private static char palos[] = { 'C', 'D', 'H', 'S' };
    private static String path = "/png/";
    private static String extension = ".png";
    private static String reverso = path + "2D." + extension;
    private static char numeros[] = { 'A', '2', '3', '4', '5', '6', '7', '8', '9',
            'T', 'J', 'Q', 'K' };

    public BarajaComponent() {
        super();
        this.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                getChildren().remove(getChildren().size() - 1);
            }

        });
        // this.createCartas(true);
    }

    public void createCartas(boolean barajar) {
        ArrayList<CartaComponent> cc = new ArrayList<>();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < palos.length; j++) {
                CartaComponent c = new CartaComponent();
                c.setAnverso(BarajaComponent.path + numeros[i] + palos[j] + BarajaComponent.extension);
                c.setPalo(palos[j]);
                c.setNumero(numeros[i]);
                cc.add(c);
                c.tapar();
            }
        }

        if (barajar) {
            Collections.shuffle(cc);
        }

        for (int i = 0; i < cc.size(); i++) {
            CartaComponent c = cc.get(i);
            // c.reverse();
            addCartaComponent(c);

        }

    }

    public void addCartaComponent(CartaComponent carta) {
        this.getChildren().add(carta);
        carta.setLayoutX(this.startx + this.getChildren().size() * incx);
        carta.setLayoutY(this.starty + this.getChildren().size() * incy);
        carta.setMontonComponent(null);
    }

    public CartaComponent destaparCarta() {
        CartaComponent c;
        if (this.getChildren().size() > 0) {
            c = (CartaComponent) this.getChildren().remove(this.getChildren().size() - 1);
            c.reverse();
            return c;
        } else
            return null;
    }

    public void rellenar(List<CartaComponent> cartas) {
        // Collections.reverse(cartas);
        cartas.forEach(c -> {
            c.reverse();
            addCartaComponent(c);
        });
    }

    public CartaComponent getCartaCima() {
        if (this.getChildren().size() > 0)
            return (CartaComponent) this.getChildren().remove(this.getChildren().size() - 1);

        else
            return null;

    }

}
