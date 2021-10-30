package dao;

import java.util.List;

import model.Propuestas;

public interface GenericDAO<T> {
	
	public List<T> findAll();
	public List<Propuestas> findAll(List<Propuestas> a);
	public int countAll();
	public int insert(T t);
	public int update(T t);
	public int delete(T t);
}
