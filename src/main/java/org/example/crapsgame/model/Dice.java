package org.example.crapsgame.model;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Random;

public class Dice {
    private int value;
    private Image image;

    public Dice() {
        roll(); // Lanza el dado al instanciarlo
    }

    public void roll() {
        Random rand = new Random();
        value = rand.nextInt(6) + 1; // Genera un número entre 1 y 6
        image = getDiceImage(value);
    }

    public Image getImage() {
        return image;
    }

    private Image getDiceImage(int value) {
        // Cambiar la ruta a la nomenclatura correcta
        String imagePath = String.format("/org/example/crapsgame/images/dices/dice%d.png", value);
        InputStream imageStream = getClass().getResourceAsStream(imagePath);

        if (imageStream == null) {
            System.err.println("No se pudo encontrar la imagen en la ruta: " + imagePath);
            throw new RuntimeException("No se pudo encontrar la imagen: " + imagePath);
        }

        return new Image(imageStream);
    }


    public int getValue() { // Mueve este método dentro de la clase
        return value;
    }
}
