package com.biblioteca.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import com.biblioteca.entidad.Ciudad;

@Stateless
public class CiudadSession {

	@PersistenceContext
	EntityManager em;
	
	//Consultar todos las ciudades de la BD
	public List<Ciudad> consultarCiudades(){
		String jpql = "SELECT c FROM Ciudad c ORDER BY c.codigo";
		Query q = em.createQuery(jpql);
		List<Ciudad> ciudades =  q.getResultList();
		return ciudades;
	}
	
	//Consultar ciudades por nombre
		public List<Ciudad> consultarCiudadesPorNombre(String nombre ){
			String jpql = "SELECT  c FROM Ciudad c WHERE UPPER(c.nombre) LIKE :nombre ORDER BY c.codigo";
			Query q = em.createQuery(jpql);
			q.setParameter("nombre","%"+ nombre.toUpperCase() +"%");
			List<Ciudad> ciudades =  q.getResultList();
			return ciudades;
		}
	
	//Busca la ciudad por código en la BD
	public Ciudad buscarPorCodigo(Integer codigo) {
		Ciudad ciudad= em.find(Ciudad.class, codigo);
		return ciudad;
	}
	
	//Inserta una ciudad en la BD
	public Ciudad incluir(Ciudad ciudad) {
		em.persist(ciudad);
		em.refresh(ciudad);
		return ciudad;
	}
	
	//Edita una ciudad en la BD
	public Ciudad editar(Ciudad ciudad) {
		ciudad = em.merge(ciudad);
		return ciudad;
	}
	
	//Incluye o edita una ciudad dependiendo de si existe o no
	public Ciudad actualizar(Ciudad ciudad) {
		Ciudad ciudadActualizada = null;
		Ciudad ciudadBuscar = buscarPorCodigo(ciudad.getCodigo());
		if (ciudadBuscar == null) {
			ciudadActualizada = incluir(ciudad);
		}else {
			ciudadActualizada = editar(ciudad);
		}
		return ciudadActualizada;
	}
	
	public void eliminar(Integer codigo) {
		em.remove(codigo);
	}
}
