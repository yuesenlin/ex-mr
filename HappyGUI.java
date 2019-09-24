import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import beike.Tools;

public class HappyGUI extends JFrame {
    JLabel wellcom;	
    JScrollPane msgText;//�������
    JTextArea msg,notice;
    JList online; //�����û��б�
    JTextField message;
    JComboBox users;
    JButton send,download;//���ͣ����ذ�ť
    
	//���幹�췽��
	public HappyGUI() {
		this.setTitle("Happy������");
		this.setSize(500, 425);
		this.getContentPane().setBackground(Color.pink);
		this.setResizable(false);//���岻������
		Tools.center(this);
		//ȡ�����ֹ�����
		this.setLayout(null);
		wellcom=new JLabel("��ӭ����������");
		wellcom.setBounds(150, 5,200, 20);
		this.add(wellcom);
		//��ʾ��Ϣ���촰��
		msgText=new JScrollPane();
		msg=new JTextArea();
		msg.setEditable(false);//����������ı���༭
		//�����ı������������
		msgText.setViewportView(msg);
		msgText.setBounds(5, 30, 360, 300);
		this.add(msgText);
		//������
		notice=new JTextArea();
		notice.setEditable(false);
		notice.setText("������~~~");
		notice.setBounds(370, 30, 120,70);
		this.add(notice);
		//�����û��б�
		String[] user= {"С��","�ָ�","����"};
		online=new JList(user);
		online.setBounds(370, 105, 120,240);
		this.add(online);
		//�����ı���
		message=new JTextField();
		message.setBounds(5, 335, 360, 22);
		this.add(message);
		//������
		users=new JComboBox(user);
		users.setBounds(100, 360, 100, 30);
		this.add(users);
		//���Ͱ�ť
		send=new JButton("����");
		send.setBounds(250, 360, 100, 30);
		this.add(send);
		//�����Ͱ�ť���¼�
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str=message.getText();
				
				if(!str.equals("")) {
					String name=(String)users.getSelectedItem();
					//System.out.println(name);
					String str1="�Ҷ�"+name+"˵��"+Tools.getTime()+"\r\n"+"    "+str+"\r\n";
					//System.out.println(str1);
					msg.append("\r\n"+str1);
					message.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ��");
			}
			
			}
		});
		
		//���ذ�ť
		download=new JButton("�����ļ�");
		download.setBounds(380, 360, 100, 30);
		this.add(download);
		download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FileInputStream in=new FileInputStream("a.txt");
					FileOutputStream out=new FileOutputStream("abc.txt");
					byte[] buff=new byte[1024];
					//������ʼʱ��6
 				long Startime=System.currentTimeMillis();
				int len=0;
				while((len=in.read(buff))!=-1) {
					out.write(buff,0,len);
				}
				//����������ʱ��
				long Enttime=System.currentTimeMillis();
				for(int i=0;i<100;i++) {
					System.out.println("���ؽ��ȣ�"+(Startime/Enttime+i)+"%");
				}
				in.close();
				out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				}
			
		});
		
 	   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new HappyGUI().setVisible(true);
	}

}
