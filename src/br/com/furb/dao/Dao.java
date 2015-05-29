package br.com.furb.dao;

import java.io.Serializable;
import java.util.List;

import br.com.furb.boot.Boot;
import br.com.furb.persistence.PersistenceStrategy;

public abstract class Dao <T extends Serializable>{

	private PersistenceStrategy<T> persistenceStrategy = Boot.getDefaultPersistenceStrategy();

	public void insert(T t){
		if(find(t) == null)
			persistenceStrategy.insert(t);
		else{
			update(t);
		}
	}
	
	public void update(T t){
		delete(t);
		insert(t);
	}
	
	public void delete(T t){
		persistenceStrategy.delete(t);
	}
	
	public List<T> findAll(){
		return persistenceStrategy.findAll();
	}
	
	public T find(T object){
		for(T t : findAll()){
			if(t.equals(object))
				return t;
		}
		return null;
	}

	public PersistenceStrategy<T> getPersistenceStrategy() {
		return persistenceStrategy;
	}

	public void setPersistenceStrategy(PersistenceStrategy<T> persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
	}
	
}
