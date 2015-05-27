package br.com.furb.dao;

import java.util.List;

import br.com.furb.model.ModelToPersist;
import br.com.furb.persistence.PersistenceStrategy;

public abstract class Dao <T extends ModelToPersist>{

	private PersistenceStrategy<T> persistenceStrategy;
	
	public Dao(PersistenceStrategy<T> persistenceStrategy) {
		super();
		this.persistenceStrategy = persistenceStrategy;
	}

	public void insert(T t){
		if(find(t.getId()) == null)
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
	
	public T find(int id){
		return persistenceStrategy.find(id);
	}

	public PersistenceStrategy<T> getPersistenceStrategy() {
		return persistenceStrategy;
	}

	public void setPersistenceStrategy(PersistenceStrategy<T> persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
	}
	
}
