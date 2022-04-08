module com.jonaskaad.sevendwarfs {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.jonaskaad.sevendwarfs;
    opens com.jonaskaad.sevendwarfs to javafx.fxml;
}