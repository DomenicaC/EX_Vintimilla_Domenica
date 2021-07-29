package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.ejbCliente;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.MiembroRegistroRemoto;
import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

public class Main {

	private MiembroRegistroRemoto registroLR;

	private void instanciarRegistro() throws Exception {

		try {
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "admin");

			final Context context = new InitialContext(jndiProperties);

			final String lookupName = "ejb:/EX_Vintimilla_Domenica_Cliente/UON!ec.edu.ups.EX_Vintimilla_Domenica_Cliente.bussines.MiembroRegistroRemoto";

			this.registroLR = (MiembroRegistroRemoto) context.lookup(lookupName);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	public void registrar(String nombre, String direccion, String telefono) throws Exception {
		Universidad u = new Universidad();
		u.setNombre(nombre);
		u.setDireccion(direccion);
		u.setTelefono(telefono);

		registroLR.insertaUni(u);
		;
	}

	public static void main(String[] args) {
		Main main = new Main();

		try {
			main.instanciarRegistro();
			System.out.println("main");
			main.registrar("UPS", "Calle vieja", "0965478454");
			System.out.println(main);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
