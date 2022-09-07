package com.biblioteca.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cli_codigo")
	private Integer codigo;

	@Column(name = "cli_nombre")
	private String nombre;

	@Column(name = "cli_ciudad")
	private Integer ciudad;
	
	@Column(name = "cli_direccion")
	private String direccion;
	
	@Column(name = "cli_obs")
	private String obs;

	public Cliente() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCiudad() {
		return ciudad;
	}

	public void setCiudad(Integer ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
