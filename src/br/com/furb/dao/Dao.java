package br.com.furb.dao;

import java.util.List;

import br.com.furb.model.ModelToPersist;
import br.com.furb.persistence.PersistenceStrategy;

public abstract class Dao <T extends ModelToPersist>{

	private PersistenceStrategy<T> persistenceStrategy;
	
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
	
	public T find(T t){
		return persistenceStrategy.find(t);
	}

	public PersistenceStrategy<T> getPersistenceStrategy() {
		return persistenceStrategy;
	}

	public void setPersistenceStrategy(PersistenceStrategy<T> persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
	}
	
}
