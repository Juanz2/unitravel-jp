package co.edu.uniquindio.unitravel.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter
@Setter
public class LoginBean {

    private String usuarioLabel ="Nombre de usuario";
    private String password;
    private String usuario;

    public void ingresar(){
        System.out.println("Ingreso");
    }
}
