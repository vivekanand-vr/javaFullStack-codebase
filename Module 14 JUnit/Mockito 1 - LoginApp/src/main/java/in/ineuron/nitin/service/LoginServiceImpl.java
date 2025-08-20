package in.ineuron.nitin.service;

import in.ineuron.nitin.dao.ILoginDao;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao dao;
	
	public LoginServiceImpl() {
		System.out.println("LoginServiceImpl:: Zero param constructor...");
	}

	public LoginServiceImpl(ILoginDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean login(String username, String password) {

		if (username.equals("") || password.equals(""))
			throw new IllegalArgumentException("Empty credentials");

		// take the help of DAO to authenticate
		int count = dao.authenticate(username, password);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String registerUser(String username, String role) {
		if (!role.equalsIgnoreCase("")&&!role.equalsIgnoreCase("visitor")) {
			dao.addUser(username, role);
			return "User Added";
		} else
			return "User Not Added";
	}
}

















