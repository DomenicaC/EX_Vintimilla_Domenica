package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.DAO.CarreraDAO;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.DAO.UniversidadDAO;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Stateless
public class CarreraON {

	@Inject
	private CarreraDAO daoCar;
	
	@Inject 
	private UniversidadDAO daoUni;
	
	public void guardarCarrera(Carrera carrera) {
		
		Universidad u = daoUni.read(carrera.getUni().getCodigo());
		if(u == null) {
			daoUni.insert(carrera.getUni());
		}else {
			daoUni.update(carrera.getUni());
		}
		
		daoCar.insert(carrera);
		
	}
	
	public Universidad getUni(int codigo) {
		
		Universidad u = daoUni.read(codigo);
		return u;
		
	}
	
	public List<Carrera> getCarreras(){
		return daoCar.getCarreras();
	}

	
}
