
import javax.servlet.http.HttpServlet;
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
public class RegistroServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
    String usuarioTxt = request.getParameter("usuario");
    String claveTxt = request.getParameter("clave");
    String nombreTxt = request.getParameter("nombre");
    String direccionTxt = request.getParameter("direccion");
    String correoTxt = request.getParameter("email");
    String telefonoTxt = request.getParameter("telefono");
    
    Usuario usuario = new Usuario();
    
    usuario.setUsuario(usuarioTxt);
    usuario.setClave(claveTxt);
     usuario.setNombre(nombreTxt);
    usuario.setDireccion(direccionTxt);
     usuario.setCorreo(correoTxt);
    usuario.setTelefono(telefonoTxt);
    
    System.out.println("Aca prueba");
    
   UsuarioDao usuarioDao =new HibernateUsuarioDao();
    usuarioDao.insert(usuario);
    
    request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
