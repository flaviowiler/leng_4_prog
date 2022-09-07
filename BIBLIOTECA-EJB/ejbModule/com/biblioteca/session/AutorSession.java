package com.biblioteca.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Autor;

@Stateless
public class AutorSession {

	@PersistenceContext
	EntityManager em;
	
	//Consultar todos los autores de la BD
	public Map<String, Object> consultarAutores(){
		Map<String,Object> retorno = new HashMap<String,Object>();
		try {
			String jpql = "SELECT  a FROM Autor a ORDER BY a.codigo";
			Query q = em.createQuery(jpql);
			List<Autor> autores =  q.getResultList();
			retorno.put("success", true);
			retorno.put("result", autores);
		} catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
		}
		return retorno;
	}
	
	//Consultar autores por nombre
		public Map<String, Object> consultarAutoresPorNombre(String nombre ){
			Map<String,Object> retorno = new HashMap<String,Object>();
			try {
				String jpql = "SELECT  a FROM Autor a WHERE UPPER(a.nombre) LIKE :nombre ORDER BY a.codigo";
				Query q = em.createQuery(jpql);
				q.setParameter("nombre","%"+ nombre.toUpperCase() +"%");
				List<Autor> autores =  q.getResultList();
				retorno.put("success", true);
				retorno.put("result", autores);
			} catch (Exception e) {
				retorno.put("success", false);
				retorno.put("error", e.getMessage());
			}
			
			return retorno;
		}
	
	//Busca al autor por código en la BD
	public Autor buscarPorCodigo(Integer codigo) {
		Autor autor= em.find(Autor.class, codigo);
		return autor;
	}
	
	//Inserta un autor en la BD
	public Autor incluir(Autor autor) {
		autor.setCodigo(null);
		em.persist(autor);
		em.refresh(autor);
		return autor;
	}
	
	//Edita un autor en la BD
	public Autor editar(Autor autor) {
		autor = em.merge(autor);
		return autor;
	}
	
	//Incluye o edita un autor dependiendo de si existe o no
	public Autor actualizar(Autor autor) {
		Autor autorActualizado = null;
		Autor autorBuscar = buscarPorCodigo(autor.getCodigo());
		if (autorBuscar == null) {
			autorActualizado = incluir(autor);
		}else {
			autorActualizado = editar(autor);
		}
		return autorActualizado;
	}
	
	public void eliminar(Integer codigo) {
		//falta validación si no existe el codigo a eliminar
		Autor autorBuscar = em.find(Autor.class, codigo);
		em.remove(autorBuscar);
	}
}
