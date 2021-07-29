package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.CarreraON;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Named
@ViewScoped
public class CarreraBEAN implements Serializable {

	private Carrera newCarrera = new Carrera();
	
	private List<Carrera> carreras;

	@Inject
	private CarreraON onCarrera;

	@PostConstruct
	private void init() {
		carreras = onCarrera.getCarreras();

	}

	public Carrera getNewCarrera() {
		return newCarrera;
	}

	public void setNewCarrera(Carrera newCarrera) {
		this.newCarrera = newCarrera;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public String doLoadUnis() {

		int codigo = newCarrera.getUni().getCodigo();

		Universidad u = onCarrera.getUni(codigo);
		newCarrera.setUni(u);
		return null;

	}

	public String guargarCarrera() {
		onCarrera.guardarCarrera(newCarrera);
		return null;
	}

	
	
}
