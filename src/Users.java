//Muhammad Hamza
//2016-UET-NML-CS-28

//           Protocol Syntax
//           For Signin: i//username//password
// 			 For signup: u//username//password//DoB//department
public class Users {
	private String Name,Password,IP;
	int PORT;
	public int getPORT() {
		return PORT;
	}
	public void setPORT(int pORT) {
		PORT = pORT;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public Users() {
		
	}
	public Users(String name, String password, String doB, String department) {
		super();
		Name = name;
		Password = password;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}	
}
