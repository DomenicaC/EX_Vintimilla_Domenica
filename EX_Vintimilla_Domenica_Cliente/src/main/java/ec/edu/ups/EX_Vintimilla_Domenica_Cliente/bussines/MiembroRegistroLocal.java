package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Local
public interface MiembroRegistroLocal {

	public void guardarCarrera(Carrera carrera);

	public Universidad getUni(int codigo);

	public List<Carrera> getCarreras();

	public List<Carrera> getCars(int codigo);

}
