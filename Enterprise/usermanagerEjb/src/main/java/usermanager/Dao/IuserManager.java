package usermanager.Dao;

import usermanager.exceptions.UserManagerExceptions;

public interface IuserManager extends ICrud {


	void login() throws UserManagerExceptions;

}
