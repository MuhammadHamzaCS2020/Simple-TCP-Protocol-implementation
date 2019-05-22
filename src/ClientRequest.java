
public class ClientRequest extends FileDownloading{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;

	public ClientRequest() {

	}
	public ClientRequest(short res,String name) {
		setRequest(res);
		setName(name);
	}
	
	public void setRequest(short request) {
		this.reponse = request;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String getName() {
		return Name;
	}
	@Override
	protected short getReponse() {
		return reponse;
	}
	@Override
	protected short getFilesInfo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
