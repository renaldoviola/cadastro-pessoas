package br.com.furb.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Define quais as implementações necessárias para ser uma estratégia de persistência. 
 * @param <T>
 */
public interface PersistenceStrategy <T extends Serializable> {
	
	public abstract void insert(T t);
	public abstract void delete(T t);
	public abstract void update(T t);
	public abstract List<T> findAll();

}
