package com.ankang.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient implements Runnable{
	
	private Socket socket;
	
	private InputStream input;
	
	private OutputStream output;
	
	private Scanner scanner = new Scanner(System.in);
	
	public TcpClient() {
		try {
			socket = new Socket("127.0.0.1", 8888);
			System.out.println("连接服务器成功....");
			input = socket.getInputStream();
			output=socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
		while(true){
			try {
				System.out.print("请输入信息:");
				String line = scanner.nextLine();
				writer.write(line);
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TcpClient cilent = new TcpClient();
		new Thread(cilent).start();
		new Thread(new reader(cilent.socket)).start();
	}
	
}

class reader implements Runnable{
	private Socket socket;
	public reader(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				String line1 = reader.readLine();
				if(!line1.isEmpty()){
					System.out.println("服务器说:"+line1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
