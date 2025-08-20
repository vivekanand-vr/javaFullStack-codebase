package in.ineuron.nitin.service;

public interface ILoginService {
	public boolean login(String username,String password);
	public String registerUser(String username,String role);
}
