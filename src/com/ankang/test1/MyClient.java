package com.ankang.test1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;
class MyClient extends JFrame{

	Socket socket = null;
	
	JPanel JP = new JPanel();
	//聊天窗口
	JTextArea JTA = new JTextArea();
	JScrollPane JSP = new JScrollPane(JTA);
	//发送窗口
	JTextField JTF = new JTextField(25);
	JButton JB = new JButton("发送");
	MyClient(){
		this.setTitle("JAVA简易聊天室");
		this.setLocation(100,50);
		this.setSize(400, 300);
		this.setVisible(true);
		JP.add(JTF);
		JP.add(JB);
		this.add(BorderLayout.CENTER,JSP);
		this.add(BorderLayout.SOUTH,JP);
		this.setVisible(true);
		try{
			socket = new Socket("127.0.0.1",10000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		new ClientRead().start();
		JB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line = JTF.getText();
				if(line.matches("\\s*\\S+\\s*")){
					JTF.setText("");
					try {
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						bw.write(line);
						bw.newLine();
						bw.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null,"不能发送空消息");
				}
			
			}
		});
	}
	class ClientRead extends Thread{
		public void run(){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true){
					String line = br.readLine();
					JTA.append(line+"\n");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		new MyClient();
	}
}
