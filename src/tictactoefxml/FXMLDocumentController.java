/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefxml;

import gr.teiemt.lmous.pega.APlayer;
import gr.teiemt.lmous.pega.Board;
import gr.teiemt.lmous.pega.Movement;
import gr.teiemt.lmous.pega.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 *
 * @author Lefteris
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button b00;
    @FXML
    private Button b01;
    @FXML
    private Button b02;
    @FXML
    private Button b10;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b20;
    @FXML
    private Button b21;
    @FXML
    private Button b22;

    Board board;
    Movement cMove;
    Player aPlayer, lPlayer, cPlayer,RBPlayer;

    private Button RBMove(Movement m) {
        int r = m.row(), c = m.clmn();
        switch (r) {
            case 0:
                switch (c) {
                    case 0:
                        return b00;
                    case 1:
                        return b01;
                    case 2:
                        return b02;
                }
            case 1:
                switch (c) {
                    case 0:
                        return b10;
                    case 1:
                        return b11;
                    case 2:
                        return b12;
                }
            case 2:
                switch (c) {
                    case 0:
                        return b20;
                    case 1:
                        return b21;
                    case 2:
                        return b22;
                }

        }
        return null;
    }

    private Movement lPMove(final Button b) {
       
        switch (b.getId()) {
            case "b00":
                return new Movement(0, 0);
            case "b01":
                return new Movement(0, 1);
            case "b02":
                return new Movement(0, 2);
            case "b10":
                return new Movement(1, 0);
            case "b11":
                return new Movement(1, 1);
            case "b12":
                return new Movement(1, 2);
            case "b20":
                return new Movement(2, 0);
            case "b21":
                return new Movement(2, 1);
            case "b22":
                return new Movement(2, 2);
        }
        return null;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
//        if (cPlayer != aPlayer) {
//            return;
//        }
       // cPlayer = RBPlayer;

        //= (Button) event.getSource();
        Movement cM = aPlayer.move(board);
        Button cB =RBMove(cM);
//        if (!board.empty(cM)) {
//            cPlayer=lPlayer;
//            return;
//        }
        board.set(cM, aPlayer.getSign());

        cB.setStyle("-fx-background-image: url('Xmark.jpg');"
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-size: 100% 100%;");

        char winner = board.win();
        if (winner != Board.emptyCell) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Player " + winner + " wins");
            alert.showAndWait();
            return;
           // Platform.exit();
        }
        
        cM = RBPlayer.move(board);
        board.set(cM, RBPlayer.getSign());
        cB = RBMove(cM);
        cB.setStyle("-fx-background-image: url('Omark.png');"
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-size: 100% 100%;");
        winner = board.win();
        if (winner != Board.emptyCell) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Player " + winner + " wins");
            alert.showAndWait();
            return;
            //Platform.exit();
        }
        //cPlayer = aPlayer;
    }

    class LPlayer extends Player {
        
        LPlayer(char sign) {
            super(sign);
        }
        
        @Override
        public Movement move(Board board) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        board = new Board();
        
        //APlayer = new APlayer('o');
        RBPlayer = new RBPlayer('o');
        aPlayer=new APlayer('x');
        
       // lPlayer = new LPlayer('x');
        //aPlayer.setOpponents(lPlayer);
        aPlayer.setOpponents(RBPlayer);
        //cPlayer = aPlayer;
            b01.fire();
            b01.fire();
            b01.fire();
            //b12.fire();
            //b02.fire();
        
    }
    
    

}
