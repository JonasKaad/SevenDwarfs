module com.jonaskaad.sevendwarfs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonaskaad.sevendwarfs to javafx.fxml;
    exports com.jonaskaad.sevendwarfs;
}