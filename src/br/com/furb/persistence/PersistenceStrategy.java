package br.com.furb.persistence;

import java.util.List;

import br.com.furb.model.ModelToPersist;

public interface PersistenceStrategy <T extends ModelToPersist> {
	
	public abstract void insert(T t);
	public abstract void delete(T t);
	public abstract void update(T t);
	public abstract T find(int id);
	public abstract List<T> findAll();

}
