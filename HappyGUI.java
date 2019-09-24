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
    JScrollPane msgText;//滚动面板
    JTextArea msg,notice;
    JList online; //在线用户列表
    JTextField message;
    JComboBox users;
    JButton send,download;//发送，下载按钮
    
	//定义构造方法
	public HappyGUI() {
		this.setTitle("Happy聊天室");
		this.setSize(500, 425);
		this.getContentPane().setBackground(Color.pink);
		this.setResizable(false);//窗体不可拉升
		Tools.center(this);
		//取消布局管理器
		this.setLayout(null);
		wellcom=new JLabel("欢迎进入聊天室");
		wellcom.setBounds(150, 5,200, 20);
		this.add(wellcom);
		//显示信息聊天窗口
		msgText=new JScrollPane();
		msg=new JTextArea();
		msg.setEditable(false);//不允许多行文本框编辑
		//多行文本框放入滚动面板
		msgText.setViewportView(msg);
		msgText.setBounds(5, 30, 360, 300);
		this.add(msgText);
		//公告栏
		notice=new JTextArea();
		notice.setEditable(false);
		notice.setText("公告栏~~~");
		notice.setBounds(370, 30, 120,70);
		this.add(notice);
		//在线用户列表
		String[] user= {"小白","胖哥","黑胖"};
		online=new JList(user);
		online.setBounds(370, 105, 120,240);
		this.add(online);
		//单行文本框
		message=new JTextField();
		message.setBounds(5, 335, 360, 22);
		this.add(message);
		//下拉框
		users=new JComboBox(user);
		users.setBounds(100, 360, 100, 30);
		this.add(users);
		//发送按钮
		send=new JButton("发送");
		send.setBounds(250, 360, 100, 30);
		this.add(send);
		//给发送按钮绑定事件
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str=message.getText();
				
				if(!str.equals("")) {
					String name=(String)users.getSelectedItem();
					//System.out.println(name);
					String str1="我对"+name+"说："+Tools.getTime()+"\r\n"+"    "+str+"\r\n";
					//System.out.println(str1);
					msg.append("\r\n"+str1);
					message.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "消息不能为空");
			}
			
			}
		});
		
		//下载按钮
		download=new JButton("下载文件");
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
					//拷贝开始时间6
 				long Startime=System.currentTimeMillis();
				int len=0;
				while((len=in.read(buff))!=-1) {
					out.write(buff,0,len);
				}
				//拷贝结束的时间
				long Enttime=System.currentTimeMillis();
				for(int i=0;i<100;i++) {
					System.out.println("下载进度："+(Startime/Enttime+i)+"%");
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
