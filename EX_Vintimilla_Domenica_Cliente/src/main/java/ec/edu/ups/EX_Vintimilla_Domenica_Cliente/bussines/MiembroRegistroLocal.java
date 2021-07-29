package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Local
public interface MiembroRegistroLocal {
	
	public void insertaUni(Universidad universidad);
	
	public List<Universidad> getUniversidad();
}
