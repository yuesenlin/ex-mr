import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ��������˳���
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
	//����������˼�������
	public  void  listener() throws Exception {
		//1.��������������socket
		ServerSocket serverSocket=new ServerSocket(PORT);
		//2.�ȴ��ͻ��˵����ӣ�һ���пͻ������Ӿͻ����socket�Ķ���
		Socket client=serverSocket.accept();
		System.out.println("������������������");
		//3.�÷������˷�������ͻ���
		OutputStream os=client.getOutputStream();
		String str="��������Ҫά��1Сʱ";
		os.write(str.getBytes());
		//4.�ر������Դ
		client.close();
	}
}