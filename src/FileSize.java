import java.io.File;

public class FileSize extends FileDownloading{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private short fileSize;

	public FileSize(String directoryName,String fname) {
		this.setName(fname);
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		this.setReponse((short)11);
		for (int i = 0; i < fList.length; i++) {
			if(fList[i].getName().equals(fname)) {
				System.out.println("Hello");
				this.setFileSize((short)fList[i].length());
				System.out.println(getFilesInfo());
			}
		}
	}
	public FileSize() {

	}

	
	public String getName() {
		return fileName;
	}
	public void setName(String filename) {
		this.fileName = filename;
	}
	
	public short getFilesInfo() {
		return this.fileSize;
	}
	public void setFileSize(short filesize) {
		this.fileSize = filesize;
	}
	
	public short getReponse() {
		return reponse;
	}
	public void setReponse(short response) {
		this.reponse = response;
	}

	public static void main (String[] args){
		FileSize obj = new FileSize("/home/mhamza/workspace/MyProtocol/Files","file1");
		System.out.println(obj.getFilesInfo());
		System.out.println(obj.getName());
	}
}
