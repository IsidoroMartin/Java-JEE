package model.services;

import model.beans.User;
import model.persistance.dao.UsersManagerDAO;

public class UsersManagerService {
	UsersManagerDAO dao = null;

	public UsersManagerService() {
		dao = new UsersManagerDAO();
	}
	
	public User getUser(String username,String password){
		return dao.getUser(username, password);
	}
}
