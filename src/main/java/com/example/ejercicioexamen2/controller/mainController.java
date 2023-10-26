package com.example.ejercicioexamen2.controller;

import com.example.ejercicioexamen2.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class mainController implements Initializable {

    @FXML
    public Label lb_app;
    @FXML
    public Label lb_nombre;
    @FXML
    public Button bt_fecha;
    @FXML
    public TextField tf_dni;
    @FXML
    public TextField tf_apellido;
    @FXML
    public TextField tf_direccion;
    @FXML
    public Label lb_nombreLibro;
    @FXML
    public Label lb_stockLibro;
    @FXML
    public Label lb_autorLibro;
    @FXML
    public Label lb_editorialLibro;
    @FXML
    public Button bt_xml;
    @FXML
    public Button bt_json;
    @FXML
    public Button bt_prestamo;
    @FXML
    public ComboBox cb_libros;
    @FXML
    public DatePicker datePicker;
    @FXML
    public TextField tf_nombreUser;
    @FXML
    public DatePicker datePicker_fechaNac;
    public Button bt_Binario;
    public Button bt_aplazar;


    private LinkedList<Libro> listaLibros;
    private ListaPrestamos listaPrestamos;
    private Properties props;

    public void guadarFecha(ActionEvent actionEvent) {


        if (datePicker.getValue()!=null){
            props.setProperty("fecha",datePicker.getValue().toString());

            ControladorFicheros.guardarProp(props);
        }else {
            generarAlerta("Error", "Fecha incorrecta");

        }


    }

    public void guardarPrestamosXML(ActionEvent actionEvent) {
        ControladorFicheros.guardarXML(listaPrestamos);

    }

    public void mostrarAlertaPrestamosJSON(ActionEvent actionEvent) {
        generarAlerta("JSON", ControladorFicheros.objetoA_JSON(listaPrestamos));
    }

    public void realizarPrestamo(ActionEvent actionEvent) {

        TreeSet<Prestamo> lista =  listaPrestamos.getLista();

        if (comprobarCamposVacios()){

            Libro libroPrestado = null;

            for (Libro libro:listaLibros) {
                if (libro.getISBN().equals(cb_libros.getSelectionModel().getSelectedItem().toString())){
                    libroPrestado=libro;
                }
            }

            lista.add(new Prestamo( new Persona(
                                                tf_dni.getText(),
                                                tf_nombreUser.getText(),
                                                tf_apellido.getText(),
                                                tf_direccion.getText(),
                                                datePicker_fechaNac.getValue().toString()
                                 ), libroPrestado));

        }else {
            generarAlerta("Error", "Uno o más campos están vacíos");
        }

        listaPrestamos.setLista(lista);

    }

    private boolean comprobarCamposVacios() {


        if (tf_nombreUser.getText().isEmpty()){
            return false;
        }
        if (tf_apellido.getText().isEmpty()){
            return false;
        }
        if (tf_dni.getText().isEmpty()){
            return false;
        }
        if (tf_direccion.getText().isEmpty()){
            return false;
        }
        if (datePicker_fechaNac.getValue().toString().isEmpty()){
            return false;
        }

        return true;
    }

    public void cargarInfoLibro(ActionEvent actionEvent) {

        for (Libro libro:listaLibros) {
            if(libro.getISBN().equals(cb_libros.getSelectionModel().getSelectedItem().toString())){

                lb_nombreLibro.setText(libro.getTitulo());
                lb_editorialLibro.setText(libro.getEditorial());
                lb_autorLibro.setText(libro.getAutor());
                lb_stockLibro.setText(Integer.toString( libro.getStock()));
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        props = ControladorFicheros.cargarProp();

        listaLibros = ControladorFicheros.cargarLibros();

        listaPrestamos = new ListaPrestamos();

        for (Libro libro:listaLibros) {
            cb_libros.getItems().add(libro.getISBN());
        }
        cb_libros.setValue("  ");



        lb_app.setText(props.getProperty("nombreApp"));
        lb_nombre.setText(props.getProperty("nombreUsuario"));
    }

    private void generarAlerta(String titulo, String texto){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(texto);
        alert.showAndWait();
    }


    public void guardarPrestamosBinario(ActionEvent actionEvent) {
        ControladorFicheros.guardarBinario(listaPrestamos);
    }

    public void aplazar15Dias(ActionEvent actionEvent) {

            TreeSet<Prestamo> lista = listaPrestamos.getLista();


            if (comprobarCamposVacios()){

                for (Prestamo e:lista) {
                    if (e.getPersona().getDNI().equals(tf_dni.getText())){
                        e.setFecha(e.getFecha().plusDays(15));
                    }
                }


            }else {
                generarAlerta("Error", "Uno o más campos están vacíos");
            }

            listaPrestamos.setLista(lista);


    }
}