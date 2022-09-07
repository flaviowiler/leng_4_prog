package com.biblioteca.entidad;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pre_numero")
	private Integer codigo;

	@Column(name = "pre_cliente")
	private Integer cliente;

	@Column(name = "pre_usuario")
	private Integer usuario;
	
	@Column(name = "pre_fecha")
	private Date fecha;
	
	@Column(name = "pre_obs")
	private String obs;
	
	@Column(name = "pre_situacion")
	private Integer situacion;
	
	@Column(name = "pre_total")
	private Float total;

	public Prestamo() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getSituacion() {
		return situacion;
	}

	public void setSituacion(Integer situacion) {
		this.situacion = situacion;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
}
