package modelo;

public class Mensaje {
	
	
	private String fecha;
	private String hora;
	private String para;
	private String de;
	private String asunto;
	private String contenido;
	
	
	public Mensaje() {
		super();
	}
	
	
	
	
	
	public Mensaje(String fecha, String hora, String para, String de, String asunto, String contenido) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.para = para;
		this.de = de;
		this.asunto = asunto;
		this.contenido = contenido;
	}





	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}





	@Override
	public String toString() {
		return "Mensaje [fecha=" + fecha + ", hora=" + hora + ", para=" + para + ", de=" + de + ", asunto=" + asunto
				+ ", contenido=" + contenido + "]";
	}
	
	
	

}
