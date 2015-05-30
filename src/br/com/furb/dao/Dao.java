package br.com.furb.dao;

import java.io.Serializable;
import java.util.List;

import br.com.furb.boot.Boot;
import br.com.furb.persistence.PersistenceStrategy;

/**
 * Classe de acesso a persistencia de dados genérica podendo ser utilizada
 * para qualquer objeto que implementa {@link Serializable} 
 *
 * @param <T>
 */
public abstract class Dao <T extends Serializable>{

	private PersistenceStrategy<T> persistenceStrategy = Boot.getDefaultPersistenceStrategy();

	public Dao() {}
	
	public Dao(PersistenceStrategy<T> persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
	}
	
	public void insert(T t){
		persistenceStrategy.insert(t);
	}
	
	public void update(T t){
		persistenceStrategy.update(t);
	}
	
	public void delete(T t){
		persistenceStrategy.delete(t);
	}
	
	public T find(T t){
		for(T obj : findAll())
			if(t.equals(obj))
				return obj;
		return null;
	}
	
	public List<T> findAll(){
		return persistenceStrategy.findAll();
	}
	
	public void deleteAll(){
		for(T t : findAll()) delete(t);
	}

	public PersistenceStrategy<T> getPersistenceStrategy() {
		return persistenceStrategy;
	}

	public void setPersistenceStrategy(PersistenceStrategy<T> persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
	}
	
}
