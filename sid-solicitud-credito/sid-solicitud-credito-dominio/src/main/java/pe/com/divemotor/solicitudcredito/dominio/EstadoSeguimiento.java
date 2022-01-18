package pe.com.divemotor.solicitudcredito.dominio;

public class EstadoSeguimiento {

	private String codigo;
	private String descripcion;
	private String indicadorInactivo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIndicadorInactivo() {
		return indicadorInactivo;
	}

	public void setIndicadorInactivo(String indicadorInactivo) {
		this.indicadorInactivo = indicadorInactivo;
	}

}
