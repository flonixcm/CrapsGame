package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, pointLabel1, shotLabel1;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());
    }

    @FXML
    public void onHelpButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Instrucciones del Juego");
        alert.setContentText(" El juego inicia cuando el jugador hace su lanzamiento o tiro\n" +
                " de salida. Si en este lanzamiento sacas un 7 u 11, ganas automáticamente.Si sacas un 2, 3 o 12, es un \"Craps\"\n" +
                "   y pierdes. Cualquier otro número (4, 5, 6, 8, 9, 10) establece el \"punto\".\n" +
                "  Si el jugador establece \"punto\", puede seguir lanzando con el objetivo de intentar sacar ese mismo número otra vez.\n" +
                "   Si logras sacar el \"punto\" antes de sacar un 7, ganas.\n" +
                "  Si sacas un 7 antes del punto, pierdes.");
        alert.showAndWait();
    }
}
