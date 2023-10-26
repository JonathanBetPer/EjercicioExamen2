package com.example.ejercicioexamen2.model;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;

public class ControladorFicheros {

    private static File archivoProps = new File("src/main/resources/files/config.props");
    private static File archivoXML = new File("src/main/resources/files/prestamos.xml");
    private static File archivoBinario = new File("src/main/resources/files/prestamos.dat");
    private static File archivoLibros = new File("src/main/resources/files/libros.txt");


    public static Properties cargarProp(){
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(archivoProps));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return properties;
    }

    public static boolean guardarProp(Properties properties){

        try {
            properties.store(new FileOutputStream(archivoProps), "Archivo de propiedades");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static LinkedList<Libro> cargarLibros(){
        LinkedList<Libro> lista = new LinkedList<>();

        try( BufferedReader bf = new BufferedReader(new FileReader(archivoLibros))) {

            String linea;
            String[] vector;
            while ( (linea= bf.readLine()) !=null  ){
                vector = linea.split("_");

                lista.add(new Libro(vector[0], vector[1], vector[2], vector[3], Integer.parseInt(vector[4])));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public static void guardarBinario(ListaPrestamos listaPrestamos){
        try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(archivoBinario));){
            os.writeObject(listaPrestamos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void guardarXML(ListaPrestamos listaPrestamos){

        try {

            JAXBContext ja=JAXBContext.newInstance(ListaPrestamos.class);

            Marshaller ma= ja.createMarshaller();
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            ma.marshal(listaPrestamos, archivoXML);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static <T>  String objetoA_JSON(T objeto){
        Gson gson = new Gson();
        return gson.toJson(objeto);
    }


}
