package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea chat;
    @FXML
    private TextField message;

    public void sendMessage(ActionEvent actionEvent) {
        chat.appendText(message.getText() + "\n");
        message.clear();
    }
}
