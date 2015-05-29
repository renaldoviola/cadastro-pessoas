package br.com.furb.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilePersistence<T extends Serializable> implements PersistenceStrategy<T> {

	private File dataFile = new File("db.dat");
	
	@Override
	public void insert(T t) {
		List<T> list = getList();
		list.add(t);
		updateList(list);
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
		return getList();
	}

	private synchronized void updateList(List<T> objects){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(dataFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objects);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private synchronized List<T> getList(){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<T> objects = new ArrayList<T>();
		try {
			fis = new FileInputStream(dataFile);
			ois = new ObjectInputStream(fis);
			objects = (List<T>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objects;
	}
	
}
