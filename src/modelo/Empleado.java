package modelo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
public class Empleado extends Persona {
    private String codigoEmpleado;
    private String departamento;
    public Empleado() {
    }
    public Empleado(String codigoEmpleado, String departamento, String nombre, String direccion, int edad) {
        super(nombre, direccion, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.departamento = departamento;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    @Override
    public String toString() {
        return  super.toString() + "," + codigoEmpleado + "," + departamento ;
    }
    public boolean guardarEmpleados(LinkedList<Empleado> listaEmpleados) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("estudiantes.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEmpleados.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEmpleados.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return g;
    }
    public boolean crearFileXml(LinkedList<Empleado> listEmpleado) {
        try{
            Element company=new Element("company");
            Document doc=new Document(company);
            for (int i = 0; i < listEmpleado.size(); i++) {
               Element empleado=new Element("empleado");
               empleado.addContent(new Element("nombre").setText(listEmpleado.get(i).getNombre()));
               empleado.addContent(new Element("direccion").setText(listEmpleado.get(i).getDireccion()));
               empleado.addContent(new Element("codigo").setText(listEmpleado.get(i).getCodigoEmpleado()));
               empleado.addContent(new Element("departamendo").setText(listEmpleado.get(i).getDepartamento()));
            }
            
        }
    }
}
