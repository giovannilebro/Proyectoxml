package proyectoxml;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Empleado;
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label ltitulo;
    @FXML
    private Label lnombre;
    @FXML
    private Label ldireccion;
    @FXML
    private Label ledad;
    @FXML
    private Label lcode;
    @FXML
    private Label ldepart;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txtedad;
    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtdepart;
    LinkedList<Empleado>listEmpleado;
    @FXML
    private void AgregarEmpleadoLista(ActionEvent event) {
       String nombre=txtnombre.getText();
       String direccion=txtdireccion.getText();
       String departamento=txtdepart.getText();
       String codigo=txtcode.getText();
       int edad=Integer.parseInt(txtedad.getText());
       Empleado objEmpleado=new Empleado(codigo, departamento, nombre, direccion, edad);
        listEmpleado.add(objEmpleado);
        limpiarCampos();
    }
    @FXML
    private void CrearArchivoXml(ActionEvent event) {
        Empleado objE=new Empleado();
        boolean guardar=objE.crearFileXml(listEmpleado);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      listEmpleado=new LinkedList<>();
    }    
    private void limpiarCampos() {
        txtnombre.setText("");
        txtdireccion.setText("");
        txtedad.setText("");
        txtcode.setText("");
        txtdepart.setText("");
    }  
}
