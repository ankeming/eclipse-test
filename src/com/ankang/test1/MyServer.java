package com.ankang.test1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
class MyServer{
	//收集连接上来的Socket用户。
	Vector<Socket> vector = new Vector<Socket>(); 
	boolean listener = true; 
	MyServer(){
		try{
			ServerSocket server = new ServerSocket(10000);
			while(listener){
				Socket socket = server.accept();
				
				vector.addElement(socket); 
				
				String ip = socket.getLocalAddress().getHostAddress();
				
				System.out.println("ip:"+ip+"连接上来了！！！");
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
				//通知用户上线消息
				for(int i = 0 ; i< vector.size();i++){
						Socket s = vector.elementAt(i);
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write(ip+"上线了！！！");
						bw.newLine();
						bw.flush();
				}

				//监听读取发送来的消息，并发送出去。
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