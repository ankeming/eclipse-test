package com.ankang.test1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
class MyServer{
	//�ռ�����������Socket�û���
	Vector<Socket> vector = new Vector<Socket>(); 
	boolean listener = true; 
	MyServer(){
		try{
			ServerSocket server = new ServerSocket(10000);
			while(listener){
				Socket socket = server.accept();
				
				vector.addElement(socket); 
				
				String ip = socket.getLocalAddress().getHostAddress();
				
				System.out.println("ip:"+ip+"���������ˣ�����");
				new ServerThread(socket,ip).start();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	class ServerThread extends Thread{
		Socket socket;
		String ip;
		ServerThread(Socket socket,String ip){
			this.socket = socket;
			this.ip = ip;
		}

		public void run(){
			try{
				//֪ͨ�û�������Ϣ
				for(int i = 0 ; i< vector.size();i++){
						Socket s = vector.elementAt(i);
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write(ip+"�����ˣ�����");
						bw.newLine();
						bw.flush();
				}

				//������ȡ����������Ϣ�������ͳ�ȥ��
				while(listener){
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = br.readLine();
					System.out.println(ip+":"+line);
					for(int i = 0 ; i< vector.size();i++){
						Socket s = vector.elementAt(i);
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write(ip+":"+line);
						bw.newLine();
						bw.flush();
					}

				}
			}catch(Exception e){
				e.printStackTrace();
			}
				
		}
	}
	public static void main(String[] args){
		new MyServer();
	}
}