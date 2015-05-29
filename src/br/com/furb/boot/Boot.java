package br.com.furb.boot;

import javax.swing.UIManager;

import br.com.furb.model.ModelToPersist;
import br.com.furb.persistence.FilePersistence;
import br.com.furb.persistence.PersistenceStrategy;
import br.com.furb.view.PessoaView;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;

public class Boot {
	
	public Boot() {
	    
		try{
	      UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
	    } 
	    catch (Exception e){
	      e.printStackTrace();
	    }
		
		new PessoaView();
	    
	}
	
	public static <T extends ModelToPersist> PersistenceStrategy<T> getDefaultPersistenceStrategy(){
		return new FilePersistence<T>();
	}

	public static void main(String[] args) {
		try{
			new Boot();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}