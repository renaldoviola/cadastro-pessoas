package br.com.furb.view.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReflectionTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private final List<?> lista;
	private final Class<?> classe;

	public ReflectionTableModel(List<?> lista) {
		this.lista = lista;
		this.classe = lista.isEmpty() ? Object.class : lista.get(0).getClass();
	}
	
	@Override
	public int getColumnCount() {
		int numeroColunas = 0;
		for(Method metodo : classe.getDeclaredMethods()){
			if (metodo.isAnnotationPresent(ConsultaViewColumn.class)) numeroColunas++;
		}
		return numeroColunas == 0 ? 1 : numeroColunas;
	}

	@Override
	public int getRowCount() {
		return lista.size() == 0 ? 1 : lista.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		try{
			if(this.lista.size() == 0) return null;
			Object o = this.lista.get(row);
			for(Method metodo : classe.getDeclaredMethods()){
				ConsultaViewColumn annotation = metodo.getAnnotation(ConsultaViewColumn.class);
				if(annotation != null && annotation.posicao() == column) return metodo.invoke(o);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getValueAt(int row){
		return this.lista.size() == 0 ? null : row > -1 ? lista.get(row) : null;
	}

	@Override
	public String getColumnName(int column) {
		for (Method metodo : classe.getDeclaredMethods()) {
			ConsultaViewColumn annotation = metodo.getAnnotation(ConsultaViewColumn.class);
			if(annotation != null && annotation.posicao() == column) return annotation.nome();
		}
		return "";
	}
	
	
}
