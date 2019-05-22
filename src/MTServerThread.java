
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MTServerThread extends Thread {
	private Socket socket;
	final String IP="localhost";

	public MTServerThread(Socket s){
		this.socket = s;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while(!socket.isClosed()) {
			try {
				ObjectInputStream OIS = new ObjectInputStream(socket.getInputStream());
				FileDownloading CR = (FileDownloading) OIS.readObject();
				clientRequestParsing(CR);
			}
			catch (Exception e){
				//System.err.println(e);
			}
		}

	}

	/*
	 * This Function check the Client Request and
	 * give the response to the client according to
	 * the client request...
	 */
	private String clientRequestParsing(FileDownloading CR) throws IOException {
		String Directory="/home/mhamza/workspace/MyProtocol/Files";
		if(CR.getReponse()==0) {
			ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
			ListFiles listFiles = new ListFiles(Directory);
			OOS.writeObject(listFiles);
		}
		else if(CR.getReponse()==1) {
			ObjectOutputStream OOS2 = new ObjectOutputStream(socket.getOutputStream());
			FileSize sizefile = new FileSize(Directory,CR.getName());
			OOS2.writeObject(sizefile);
			sendPackets(Directory+"/"+CR.getName());
		}
		return "";
	}
	/*
	 * This Function is for sending data from the file continously until
	 * the all data not sent to the client socket...
	 */
	public boolean sendPackets(String fname) throws IOException {
		File file = new File(fname);
		FileInputStream fin = null;
		System.out.println(fname);
		// create FileInputStream object
		fin = new FileInputStream(file);
		byte fileContent[] = new byte[(int)file.length()];
		int division=(fileContent.length)/100;
		int mode=(fileContent.length)%100;
		byte[] content=new byte[100];
		fin.read(fileContent);
		int i = 0;
		for ( ; i < division; i++) {
			for (int j = 0; j < 100; j++) {
				content[j]=fileContent[(i*100)+j];
			}
			ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
			SendFile sendfile=new SendFile((short)12,(short)i, content);
			OOS.writeObject(sendfile);
		}
		byte[] content1=new byte[mode];
		for (int j = 0; j <mode; j++) {
			content1[j]=fileContent[(i*100)+j];
		}
		ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
		SendFile sendfile=new SendFile((short)12,(short)i, content1);
		OOS.writeObject(sendfile);

		return true;
	}


}
