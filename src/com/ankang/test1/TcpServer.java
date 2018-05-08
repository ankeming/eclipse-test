package com.ankang.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TcpServer implements Runnable{
	private static ServerSocket serverSocket;
	private static Socket socket;
	private List<Socket> socketList = new ArrayList<Socket>();
	public TcpServer() throws IOException {
		serverSocket = new ServerSocket(8888);
	}
	public static void main(String[] args) throws IOException {
		TcpServer server = new TcpServer();
		int count = 0;
		while(true){
			socket = server.serverSocket.accept();
			server.socketList.add(socket);
			count ++;
			System.out.println("第"+count+"个客户端连接上服务器.....");
			new Thread(server).start();
			new Thread(new Print(socket)).start();
		}
	}
	@Override
	public void run() {
		BufferedReader reader;
		BufferedWriter writer;
		try {
			while(true){
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = reader.readLine();
				if(!line.isEmpty()){
					System.out.println("客户端说:"+line);
					for(Socket socket1:socketList){
						writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
						if(socket1!=socket){
							writer.write(line);
						}else{
							writer.write("我说："+line);
						}
						writer.newLine();
						writer.flush();
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
class Print implements Runnable{
	Scanner scanner = new Scanner(System.in);
	static List<Socket> socketList=new ArrayList<Socket>();
	
	public Print(Socket socket) {
		socketList.add(socket);
	}
	

	@Override
	public void run() {
		BufferedWriter writer;
		while(true){
			try {
				String line = scanner.nextLine();
				for(Socket socket:socketList){
					writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					writer.write(line);
					writer.newLine();
					writer.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}