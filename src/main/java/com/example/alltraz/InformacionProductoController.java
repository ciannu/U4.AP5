package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InformacionProductoController {
    @javafx.fxml.FXML
    private ComboBox proveedor_list;
    @javafx.fxml.FXML
    private ComboBox producto_list;
    @javafx.fxml.FXML
    private TextField numero_lote;
    @javafx.fxml.FXML
    private TextField hora_salida;
    @javafx.fxml.FXML
    private Button mostrar_producto;

    @javafx.fxml.FXML
    public void mostrar_producto(ActionEvent actionEvent) {
    }
}
