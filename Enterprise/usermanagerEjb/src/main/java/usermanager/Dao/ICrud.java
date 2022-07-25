package usermanager.Dao;


import java.util.List;

import usermanager.exceptions.UserManagerExceptions;



public interface ICrud<T>  {

	public List<T> getAll()  throws UserManagerExceptions;

	public T create(T t) throws UserManagerExceptions;

	public void delete(T t) throws UserManagerExceptions;

	public T find(T t) throws UserManagerExceptions;

	public T update(T t) throws UserManagerExceptions;

	public Iterable<T> findAll() throws UserManagerExceptions;

}
