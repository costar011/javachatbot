package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Chatbot {

	public static void main(String[] args) {

		// 1. ȣ��Ʈ(ip) + ��Ʈ��ȣ : local host:3306
		String host = "jdbc:mysql://localhost:3306/chatbot";
		// 2. �������� (root)
		String userName = "root";
		// 3. ���� ��й�ȣ : java1234
		String uesrPass = "java1234";
		// 4. �����ͺ��̽� �̸� : ConnectionTest
		// String dbName = "chatbott";

		Connection conn = null;
		Statement stmt = null;

		
		try {
		while(true) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(host, userName, uesrPass);
				stmt = conn.createStatement();
	
				
				
				// ����ڿ��� ������ �޾ƾߵ�
				System.out.print("�˻��� Ű���带 �Է��ϼ���==>");
				Scanner sc = new Scanner(System.in);
	
				
				// ����ڰ� %���ٵ�%��� �Է� ���� ���  =>  ���� key���ٰ� ����� �Է°��� ����
				String key = sc.nextLine();
	
				key = "%" + key + "%";
				
				
				
				String query = "";
	
				
				query += "  SELECT " ;
				query += "  answer_vaule " ;
				query += "  FROM answer " ;
				query += "  WHERE answer_vaule LIKE " + "'" + key + "'";
				
				
				ResultSet rs = stmt.executeQuery(query);
	
				
				while (rs.next()) {
					System.out.println("�亯�� :" + rs.getString("answer_vaule"));
				}
				
			
		}
			
		} catch (Exception e) {
			System.out.println("DB���� ����");
		}

	}

}


