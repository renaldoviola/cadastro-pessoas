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

/**
 * Implementa {@link PersistenceStrategy} dizendo como deve ser feita a persistência em um arquivo
 * utilizando objetos serializados. 
 *
 * @param <T>
 */
public class FilePersistence<T extends Serializable> implements PersistenceStrategy<T> {

	private DataFile dataFile;
	
	public FilePersistence(File file) {
		this.dataFile = new DataFile(file);
	}
	
	public FilePersistence() {}
	
	@Override
	public void insert(T t) {
		List<T> list = dataFile.getList();
		list.add(t);
		dataFile.updateList(list);
	}

	@Override
	public void delete(T t) {
		List<T> list = dataFile.getList();
		list.remove(t);
		dataFile.updateList(list);
	}

	@Override
	public void update(T t) {
		delete(t);
		insert(t);
	}

	@Override
	public List<T> findAll() {
		return dataFile.getList();
	}
	
	/**
	 * Classe responsável pela manipulação do arquivo em que os objetos são persistidos.
	 */
	private class DataFile {
		
		private File file;
		
		public DataFile(File file) {
			this.file = file;
		}

		private synchronized void updateList(List<T> objects){
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				validateDataFile();
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(objects);
				oos.flush();
				oos.close();
				fos.flush();
				fos.close();
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
				validateDataFile();
				if(file.length()> 0){
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					objects = (List<T>) ois.readObject();
					ois.close();
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return objects;
		}
		
		private synchronized void validateDataFile() throws IOException{
			if(file == null)
				file = new File("db.dat");
			if(!file.exists())
				file.createNewFile();
		}
	}
	
}
