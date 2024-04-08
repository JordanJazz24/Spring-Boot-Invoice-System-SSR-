package com.example.facturacion.presentation.login;

import com.example.facturacion.logic.Service;
import com.example.facturacion.logic.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller("LoginController")
public class Controller {
    @Autowired
    private Service service;


    @PostMapping("/presentation/login/View")
    public String logIn(@ModelAttribute("Usuario")Usuario usuario, HttpSession httpSession) {

        try {
            Usuario usuarioDB = service.usuarioRead(usuario.getIdentificacion());
            httpSession.setAttribute("usuario", usuarioDB);
            httpSession.setAttribute("proveedor", service.proveedorRead(usuarioDB.getIdentificacion()));
            return "redirect:/presentation/nuevo/show";
        } catch (Exception e) {
            return "/presentation/login/view";
        }
    }

    @GetMapping("/")
    public String ShowLogInForm(Model model){
        model.addAttribute("Usuario",new Usuario());
        return "/presentation/login/View";
    }

    @GetMapping("/presentation/login/Logout")
    public String Logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }


}
