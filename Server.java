import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务器端程序
 * @author ME
 *
 */
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try {
			new TCPServer().listener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class TCPServer{
	private static final int PORT=7788;
	//定义服务器端监听方法
	public  void  listener() throws Exception {
		//1.建立服务器监听socket
		ServerSocket serverSocket=new ServerSocket(PORT);
		//2.等待客户端的连接，一旦有客户端连接就会产生socket的对象
		Socket client=serverSocket.accept();
		System.out.println("服务器端启动已连接");
		//3.让服务器端发公告给客户端
		OutputStream os=client.getOutputStream();
		String str="服务器需要维护1小时";
		os.write(str.getBytes());
		//4.关闭相关资源
		client.close();
	}
}