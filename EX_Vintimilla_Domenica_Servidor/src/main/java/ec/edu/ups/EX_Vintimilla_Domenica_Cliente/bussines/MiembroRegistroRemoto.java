package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;


@Remote
public interface MiembroRegistroRemoto {

public void guardarCarrera(Carrera carrera);
	
	public Universidad getUni(int codigo);
	
	public List<Carrera> getCarreras();
	
	public List<Carrera> getCars(int codigo);
	
}
