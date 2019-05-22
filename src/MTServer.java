import java.net.*;


public class MTServer {
	final int PORT=2222;
	static int clientRequests=0;
	/*
	 * 
	 */
	public MTServer() {
		try
		{
			ServerSocket ss=new ServerSocket(PORT);
			System.out.println("Waiting for client request");
			while(true){
				Socket client=ss.accept();
				clientRequests++;
				System.out.println("Server Accepted Request# "+clientRequests);
				MTServerThread ct = new MTServerThread(client);
				ct.start();
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}

	// Main Function
	public static void main(String args[]){
		MTServer obj=new MTServer();
	}
}
