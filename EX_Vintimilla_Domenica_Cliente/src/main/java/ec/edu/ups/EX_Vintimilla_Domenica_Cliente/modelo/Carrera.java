package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Carrera {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String DirCarrera;

	@OneToOne
	@JoinColumn(name = "uni_codigo")
	private Universidad uni;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirCarrera() {
		return DirCarrera;
	}

	public void setDirCarrera(String dirCarrera) {
		DirCarrera = dirCarrera;
	}

	public Universidad getUni() {
		return uni;
	}

	public void setUni(Universidad uni) {
		this.uni = uni;
	}

}
