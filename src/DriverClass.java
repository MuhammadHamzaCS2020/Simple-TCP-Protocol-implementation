import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DriverClass {


	public static void main(String[] args) throws IOException {

		File file = new File("/home/mhamza/workspace/MyProtocol/Files/file1");
		FileInputStream fin = null;
		try {
			// create FileInputStream object
			fin = new FileInputStream(file);
			byte fileContent[] = new byte[(int)file.length()];
			
			int division=(fileContent.length)/100;
			int mode=(fileContent.length)%100;
			System.out.println("fguewytruwedgfo oeuryewir3");
			byte[] content=new byte[100];
			short ofset=0;
			fin.read(fileContent);
			String str1=new String(fileContent);
			System.out.println(str1);
			System.out.println(division);
			for (int i = 0; i < division; i++) {
				for (int j = 0; j < 100; j++) {
					content[j]=fileContent[(i*100)+j];
				}
				String str=new String(content);
				System.out.print(str);
				//SendFile obj=new SendFile((short)12,ofset, content);
				//ofset=(short) (ofset+100);// **** remember this point****
				//OOS = new ObjectOutputStream(socket.getOutputStream());
				//OOS.writeObject(obj);
			}
		}
		finally {
			// close the streams using close method
			try {
				if (fin != null) {
					fin.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error while closing stream: " + ioe);
			}
		}
	}
}