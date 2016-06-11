package model.persistance.querys.users;

public class UMQuerys {
	public static String buildGetUserQuery(String username, String password) {
		return "select * from USERS where upper(username)='"
				+ username.toUpperCase() + "' and password='"
				+ password + "'";
	}
}
