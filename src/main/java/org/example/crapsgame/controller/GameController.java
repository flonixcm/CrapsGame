package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Game;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, shootCountLabel, resultLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    private Game game;

    public GameController() {
        this.game = new Game();  // Inicializamos el juego aquí
    }

    @FXML
    public void initialize() {
        updateUI();  // Actualizamos la interfaz con los valores iniciales
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        int result = game.rollDices(); // Lanzar los dados y obtener el resultado
        dice1ImageView.setImage(game.getDice1().getImage());
        dice2ImageView.setImage(game.getDice2().getImage());

        shootLabel.setText("Tiro: " + (game.getDice1().getValue() + game.getDice2().getValue()));
        shootCountLabel.setText("Lanzamientos: " + game.getShootCount());

        // Lógica del juego según el resultado
        if (result == 1) { // Ganó
            resultLabel.setText("¡Ganaste!");
            showAlert("Resultado", "¡Felicidades! Ganaste el juego.");
            resetGame();
        } else if (result == -1) { // Perdió
            resultLabel.setText("Perdiste.");
            showAlert("Resultado", "Lo siento, has perdido el juego.");
            resetGame();
        } else { // Si hay un punto establecido o se establece un nuevo punto
            if (game.isPointEstablished()) {
                pointLabel.setText("Punto: " + game.getPoint() + " (Establecido)");
            } else {
                pointLabel.setText("Punto: " + game.getPoint() + " (No Establecido)");
            }
        }
    }

    @FXML
    public void onHelpButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Instrucciones del Juego");
        alert.setContentText(" El juego inicia cuando el jugador hace su lanzamiento o tiro\n" +
                " de salida. Si en este lanzamiento sacas un 7 u 11, ganas automáticamente. Si sacas un 2, 3 o 12, es un \"Craps\"\n" +
                "   y pierdes. Cualquier otro número (4, 5, 6, 8, 9, 10) establece el \"punto\".\n" +
                "  Si el jugador establece \"punto\", puede seguir lanzando con el objetivo de intentar sacar ese mismo número otra vez.\n" +
                "   Si logras sacar el \"punto\" antes de sacar un 7, ganas.\n" +
                "  Si sacas un 7 antes del punto, pierdes.");
        alert.showAndWait();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void resetGame() {
        game.resetGame();
        updateUI();
    }

    private void updateUI() {
        shootLabel.setText("Tiro: 0");
        shootCountLabel.setText("Lanzamientos: 0");
        pointLabel.setText("Punto no establecido");
        resultLabel.setText("");  // Limpiamos el resultado anterior
    }
}

