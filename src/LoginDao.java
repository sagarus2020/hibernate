
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
public class LoginDao {
    public String authenticateUser(Usuario usuario){
    UsuarioDao usuarioDao = new HibernateUserDao();
    Usuario u = usuarioDao.selectById(usuario.getUsuario());
    if(u!=null){
        if(u.getClave().contentEquals(usuario.getClave())){
            return "SUCCESS";
        }
                }
    return "ERROR";
    }
    
   
}
