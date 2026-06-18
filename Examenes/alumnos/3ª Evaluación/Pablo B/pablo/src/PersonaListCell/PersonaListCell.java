/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaListCell;

/**
 *
 * @author pabbermor3
 */
public class PersonaListCell {

    import javafx.scene.control.ListCell ;
    import javafx.scene.image.Image ;
    import javafx.scene.image.ImageView ;
    import models.Persona ;

    public class PersonaListCell extends ListCell<Persona> {

        private final ImageView imageView = new ImageView();

        public PersonaListCell() {
            imageView.setFitHeight(32);
            imageView.setFitWidth(32);
            setGraphic(imageView);
        }

        
        protected void updateItem(Persona persona, boolean empty) {
            super.updateItem(persona, empty);
            if (empty || persona == null) {
                setText(null);
                setGraphic(null);
            } else {
                // Imagen según género de la persona xd
                String generoImg = "man".equalsIgnoreCase(persona.getGenero()) ? "man.png" : "woman.png";
                try {
                    Image img = new Image(getClass().getResourceAsStream("/imagenes/" + imagen));
                    imageView.setImage(img);
                } catch (Exception e) {
                    imageView.setImage(null);
                }

                setText(persona.getApellidos() + ", " + persona.getNombre() + " – " + persona.getPais());
                setGraphic(imageView);
            }
        }
    }
}
