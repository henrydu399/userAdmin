package usermanager.ejb;

import java.util.List;

import javax.ejb.Local;

import usermanager.entitys.USistema;
import usermanager.exceptions.UserManagerExceptions;

@Local
public interface ISistemaManager {
	
	List<USistema> getAll() throws UserManagerExceptions;

	void create() throws UserManagerExceptions;

	boolean update() throws UserManagerExceptions;

	boolean delete() throws UserManagerExceptions;

	void find() throws UserManagerExceptions;
	
}
