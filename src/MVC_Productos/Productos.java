package MVC_Productos;

public class Productos {	
	
	private String codigoArt;
	private String seccionArt;
	private String nombreArt;
	private String precioArt;
	private String fechaArt;
	private String importadoArt;
	private String paisOrigenArt;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public Productos(String codigoArt, String seccionArt, String nombreArt, String precioArt, String fechaArt,
			String importadoArt, String paisOrigenArt) {
	
		this.codigoArt = codigoArt;
		this.seccionArt = seccionArt;
		this.nombreArt = nombreArt;
		this.precioArt = precioArt;
		this.fechaArt = fechaArt;
		this.importadoArt = importadoArt;
		this.paisOrigenArt = paisOrigenArt;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Productos(String seccionArt, String nombreArt, String precioArt, String fechaArt, String importadoArt,
			String paisOrigenArt) {
		
		this.seccionArt = seccionArt;
		this.nombreArt = nombreArt;
		this.precioArt = precioArt;
		this.fechaArt = fechaArt;
		this.importadoArt = importadoArt;
		this.paisOrigenArt = paisOrigenArt;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String getCodigoArt() {
		return codigoArt;
	}
	public void setCodigoArt(String codigoArt) {
		this.codigoArt = codigoArt;
	}
	public String getSeccionArt() {
		return seccionArt;
	}
	public void setSeccionArt(String seccionArt) {
		this.seccionArt = seccionArt;
	}
	public String getNombreArt() {
		return nombreArt;
	}
	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}
	public String getPrecioArt() {
		return precioArt;
	}
	public void setPrecioArt(String precioArt) {
		this.precioArt = precioArt;
	}
	public String getFechaArt() {
		return fechaArt;
	}
	public void setFechaArt(String fechaArt) {
		this.fechaArt = fechaArt;
	}
	public String getImportadoArt() {
		return importadoArt;
	}
	public void setImportadoArt(String importadoArt) {
		this.importadoArt = importadoArt;
	}
	public String getPaisOrigenArt() {
		return paisOrigenArt;
	}
	public void setPaisOrigenArt(String paisOrigenArt) {
		this.paisOrigenArt = paisOrigenArt;
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String toString() {
		return "Productos [Codigo Articulo=" + codigoArt + ", Seccion Articulo=" + seccionArt + ", Nombre Articulo=" + nombreArt
				+ ", Precio Articulo=" + precioArt + ", Fecha Articulo=" + fechaArt + ", Articulo Importado =" + importadoArt
				+ ", Pais Origen Articulo=" + paisOrigenArt + "]";
	}
	
	
	
	
}
