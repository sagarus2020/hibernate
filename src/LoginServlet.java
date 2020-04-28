
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import redJpa.entities.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class LoginServlet {
     protected void doPost(HttpServletRequest request,HttpServletResponse response){
    String usuarioTxt = request.getParameter("usuario");
    String claveTxt = request.getParameter("clave");
    
    Usuario usuario = new Usuario();
    
    usuario.setUsuario(usuarioTxt);
    usuario.setClave(claveTxt);
    
    LoginDao loginDao = new LoginDao();
    
    String userValidate = loginDao.authenticateUser(usuario);
    System.out.println(userValidate);
    if(userValidate.contentEquals("SUCESS")){
        request.setAttribute("username", usuarioTxt);
        try {
			request.getRequestDispatcher("/home.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }else{
        request.setAttribute("errMessage", userValidate);
        try {
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
    
    
   
    
    }
}
