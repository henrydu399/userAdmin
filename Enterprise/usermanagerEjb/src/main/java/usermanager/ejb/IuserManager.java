package usermanager.ejb;

import usermanager.exceptions.UserManagerExceptions;

public interface IuserManager {

	void create() throws UserManagerExceptions;

	boolean update() throws UserManagerExceptions;

	boolean delete() throws UserManagerExceptions;

	void find() throws UserManagerExceptions;

	void login() throws UserManagerExceptions;

}
