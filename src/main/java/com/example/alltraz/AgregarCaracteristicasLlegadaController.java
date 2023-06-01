package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.example.model.Producto;

public class AgregarCaracteristicasLlegadaController {

    @javafx.fxml.FXML
    private Button agregar;
    @javafx.fxml.FXML
    private TextArea getCaracteristicas;

    @javafx.fxml.FXML
    public void click_agregar(ActionEvent actionEvent) {
        String caract;
        caract = getCaracteristicas.getText();
        Producto p = Producto.carLleg(caract);
    }
}
