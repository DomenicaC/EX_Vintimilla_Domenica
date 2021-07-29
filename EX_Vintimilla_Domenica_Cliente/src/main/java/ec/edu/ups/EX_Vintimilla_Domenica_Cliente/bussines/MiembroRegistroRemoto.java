package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;


@Remote
public interface MiembroRegistroRemoto {

	public void insertaUni(Universidad universidad);
	
	public List<Universidad> getUniversidad();
	
}
