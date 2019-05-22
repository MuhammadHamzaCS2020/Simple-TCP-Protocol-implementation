public class SendFile extends FileDownloading{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	byte[] fileContent = new byte[100]; 
	private short ofSet;

	public SendFile(short res,short sfset,byte content[]){
		this.setReponse(res);
		this.setOfSet(sfset);
		this.setFileContent(content);
	}
	
	@Override
	public String getName() {
		String str=new String(this.fileContent);
		return str;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	public short getFilesInfo() {
		return ofSet;
	}
	public void setOfSet(short ofSet) {
		this.ofSet = ofSet;
	}


	public short getReponse() {
		return reponse;
	}
	public void setReponse(short reponse) {
		this.reponse = reponse;
	}

	public static void main (String[] args){
		//SendFile listFilesUtil = new SendFile("/home/mhamza/workspace/MyProtocol/Files/file1");
	}	
}
