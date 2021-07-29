package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.CarreraON;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.service.modelo.carreraTemp;

@WebService
public class carrServices {
	
	@Inject
	private CarreraON onCarrera;
	
	@WebMethod
	public List<carreraTemp> getCarreras(){
		List<Carrera> list = onCarrera.getCarreras();
		List<carreraTemp> carreras = new ArrayList<carreraTemp>();
		
		for (Carrera c: list) {
			carreraTemp ct = new carreraTemp();
			ct.setNombre(c.getNombre());
			ct.setDirectorCarrera(c.getDirCarrera());
			carreras.add(ct);
		}
		
		return carreras;
	}

}
