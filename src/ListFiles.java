import java.io.File;

public class ListFiles extends FileDownloading{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short noFiles;
	private String fileNames=null;

	public short getFilesInfo() {
		return noFiles;
	}
	public void setNoFiles(short noFiles) {
		this.noFiles = noFiles;
	}

	public short getReponse() {
		return reponse;
	}
	public void setReponse(short reponse) { 
		this.reponse = reponse;
	}

	public ListFiles(String directoryName) {
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		this.setNoFiles((short)fList.length);
		this.setReponse((short)10);
		this.setFileNames(fList);
	}


	public String getName() {
		return fileNames;
	}
	public void setFileNames(File[] fList) {
		fileNames=fList[0].getName();
		for (int i = 1; i < fList.length; i++) {
			fileNames=fileNames+"//"+fList[i].getName();
		}
	}


	public static void main (String[] args){
		ListFiles listFilesUtil = new ListFiles("/home/mhamza/workspace/MyProtocol/Files");
		System.out.println(listFilesUtil.getName());
	}

}