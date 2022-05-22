
package Controlador;

import Modelo.Empleados;
import Modelo.SqlEmpleados;
import Vista.VistaLogin;

public class ControlLogin {
    VistaLogin vistaLogin;
    Empleados empl = new Empleados();
    SqlEmpleados sqlEmpl = new SqlEmpleados();

    public ControlLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
    
    public void login(){
       
    }
}
