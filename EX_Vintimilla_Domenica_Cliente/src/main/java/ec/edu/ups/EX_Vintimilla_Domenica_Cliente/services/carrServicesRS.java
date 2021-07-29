package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.CarreraON;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.MiembroRegistroLocal;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.service.modelo.carTEmp;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.service.modelo.carreraTemp;

@Path("carreras")
public class carrServicesRS {
	
	private static final String CODIGO2 = "codigo";
	@Inject
	private MiembroRegistroLocal onCarrera;
	
	@POST
	@Path("/Listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<carTEmp> obtenerCarrera(@QueryParam("codigo") int codigo){
		List<Carrera> lista = onCarrera.getCars(codigo);
		List<carTEmp> car = new ArrayList<carTEmp>();
		
		for(Carrera c : lista) {
			carTEmp ca = new carTEmp();
			ca.setDirectorCarrera(c.getDirCarrera());
			ca.setNombre(c.getNombre());
			car.add(ca);
		}
		
		return car;
	}
	
	
	
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
