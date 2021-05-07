package ${groupId}.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class LogDetailsRequestModel {
	@NotNull(message="nombreAplicacion cannot be null")
	private String nombreAplicacion;
	
	@NotNull(message="Mensaje cannot be null")
	private String mensaje;
	
	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
