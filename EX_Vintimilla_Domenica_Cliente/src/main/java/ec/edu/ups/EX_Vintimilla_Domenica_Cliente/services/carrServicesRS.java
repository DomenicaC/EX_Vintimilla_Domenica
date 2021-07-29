package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.CarreraON;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.service.modelo.carreraTemp;

@Path("carreras")
public class carrServicesRS {
	
	@Inject
	private CarreraON onCarrera;
	

	
	
	
	@GET
	@Path("lista1")
	@Produces(MediaType.APPLICATION_JSON)
	public List<carreraTemp> getCarreras(){
		List<Carrera> lista = onCarrera.getCarreras();
		List<carreraTemp> carreras = new ArrayList<carreraTemp>();
		
		for(Carrera c : lista) {
			carreraTemp ca = new carreraTemp();
			ca.setDirectorCarrera(c.getDirCarrera());
			ca.setNombre(c.getNombre());
			ca.setCodigoUni(c.getUni().getCodigo());
			ca.setNombreUni(c.getUni().getNombre());
			carreras.add(ca);
		}
		
		return carreras;
	}

}
