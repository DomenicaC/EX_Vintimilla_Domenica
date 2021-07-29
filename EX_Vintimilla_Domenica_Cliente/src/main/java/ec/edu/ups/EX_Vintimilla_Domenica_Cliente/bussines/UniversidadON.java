package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.DAO.UniversidadDAO;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Stateless
public class UniversidadON {

	@Inject
	private UniversidadDAO daoUni;
	
	public void insertaUni(Universidad universidad) {
		daoUni.insert(universidad);
	}
	
	public List<Universidad> getUniversidad(){
		return daoUni.getUnis();
	}
	
}
