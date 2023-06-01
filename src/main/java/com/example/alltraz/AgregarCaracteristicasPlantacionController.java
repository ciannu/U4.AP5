import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarCaracteristicasPlantacionController {

    @javafx.fxml.FXML
    private Button agregar;

    @javafx.fxml.FXML
    private TextArea getCaracteristicas;

    private  String caracteristicasPlantacion;

    @FXML
    public void click_agregar(ActionEvent actionEvent) {
        caracteristicasPlantacion = getCaracteristicas.getText().trim();

        try {
            Parent pane = FXMLLoader.load(getClass().getResource("RegistroProducto-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) agregar.getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
