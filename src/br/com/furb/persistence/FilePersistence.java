package br.com.furb.persistence;

import java.util.List;

import br.com.furb.model.ModelToPersist;

public class FilePersistence<T extends ModelToPersist> implements PersistenceStrategy<T> {

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T find(int id) {
		return null;
	}
	
}
