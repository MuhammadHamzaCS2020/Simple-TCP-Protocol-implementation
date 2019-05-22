import java.io.Serializable;

public abstract class  FileDownloading implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected short reponse;
	public FileDownloading() {
		
	}
	protected abstract short getReponse();
	protected abstract String getName();
	protected abstract short getFilesInfo();
	
}
