import javax.persistence.EntityManager;

import redJpa.util.Conexion;

public class MensajeDao {
	 EntityManager em = null;
	 public  MensajeDao(){
		 em=Conexion.getEm();
	 }
}
