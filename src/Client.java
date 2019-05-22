import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	private String IP="localhost";
	private String fileName;
	private final int PORT=2222;
	private Socket socket;
	private ObjectOutputStream OOS;
	private String[] ListOfFiles=null;
	public Client() throws IOException {
		socket =new Socket(IP,PORT);
		try
		{
			String str;
			while(true) {
				str=menu();
				OOS=new ObjectOutputStream(socket.getOutputStream());
				if(str.equals("List") || str.equals("list")) {
					OOS.writeObject(new ClientRequest((short)0,""));
					ObjectInputStream OIS=new ObjectInputStream(socket.getInputStream());
					FileDownloading obj=(FileDownloading) OIS.readObject();
					getInfoObject(obj);
				}
				else if(str.equals("Download") || str.equals("download")) {
					int index=showFiles();
					OOS.writeObject(new ClientRequest((short)1,ListOfFiles[index]));
					ObjectInputStream OIS=new ObjectInputStream(socket.getInputStream());
					FileDownloading obj=(FileDownloading) OIS.readObject();
					getInfoObject(obj);
				}
				else {
					System.out.println("Something Went Wrong...");
					break;
				}
			}
			socket.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}


	public String menu() {
		System.out.println("Type List for ListOfFiles");
		System.out.println("Type Select File Name That you want to Download");
		System.out.println("Tpe quit for Close the Connection" );
		System.out.print("Type Option:");
		Scanner input=new Scanner(System.in);
		return input.next();
	}


	private void CollectFileData(short SIZE) throws IOException, ClassNotFoundException{
		System.out.println("\nThis is the File Data...");
		File TextFile = new File(fileName+".txt");
		FileWriter fw = new FileWriter(TextFile);
		fw.close();
		for (int i = 0; i < (SIZE/100); i++) {
			ObjectInputStream OIS1=new ObjectInputStream(socket.getInputStream());
			FileDownloading readingData=(FileDownloading) OIS1.readObject();
			getInfoObject(readingData);
			//System.out.println(readingData.getName());
		}
		ObjectInputStream OIS1=new ObjectInputStream(socket.getInputStream());
		FileDownloading readingData=(FileDownloading) OIS1.readObject();
		getInfoObject(readingData);
		System.out.println("File is Downloads...");
	}
	private int showFiles() {
		System.out.println("Which File You want to download plz select No(1,2,3 etc)");
		for (int i = 0; i < ListOfFiles.length; i++) {
			System.out.println(i+" "+ListOfFiles[i]);
		}
		Scanner input=new Scanner(System.in);
		return input.nextInt();
	}

	private void getInfoObject(FileDownloading obj) throws ClassNotFoundException, IOException {
		if(obj.getReponse()==10) {
			System.err.println(obj.getReponse()+ " "+obj.getFilesInfo()+" "+ obj.getName());
			String str=obj.getName();
			ListOfFiles=str.split("//");
		}
		else if(obj.getReponse()==11) {
			System.err.println(obj.getReponse()+" "+ obj.getName()+ " "+obj.getFilesInfo());
			fileName=obj.getName();
			CollectFileData(obj.getFilesInfo());
		}
		else if(obj.getReponse()==12) {
			System.err.print(obj.getName());
			File TextFile = new File(fileName+".txt");
			FileWriter fw = new FileWriter(TextFile,true);
			fw.write(obj.getName());
			fw.close();
		}
	}



	public static void main(String args[]) throws IOException{
		Client obj=new Client();

	}
}
