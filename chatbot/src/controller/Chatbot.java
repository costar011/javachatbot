package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Chatbot {

	public static void main(String[] args) {

		// 1. 호스트(ip) + 포트번호 : local host:3306
		String host = "jdbc:mysql://localhost:3306/chatbot";
		// 2. 유저네임 (root)
		String userName = "root";
		// 3. 유저 비밀번호 : java1234
		String uesrPass = "java1234";
		// 4. 데이터베이스 이름 : ConnectionTest
		// String dbName = "chatbott";

		Connection conn = null;
		Statement stmt = null;

		
		try {
		while(true) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(host, userName, uesrPass);
				stmt = conn.createStatement();
	
				
				
				// 사용자에게 질문을 받아야됨
				System.out.print("검색할 키워드를 입력하세요==>");
				Scanner sc = new Scanner(System.in);
	
				
				// 사용자가 %에뛰드%라고 입력 했을 경우  =>  변수 key에다가 사용자 입력값을 저장
				String key = sc.nextLine();
	
				key = "%" + key + "%";
				
				
				
				String query = "";
	
				
				query += "  SELECT " ;
				query += "  answer_vaule " ;
				query += "  FROM answer " ;
				query += "  WHERE answer_vaule LIKE " + "'" + key + "'";
				
				
				ResultSet rs = stmt.executeQuery(query);
	
				
				while (rs.next()) {
					System.out.println("답변은 :" + rs.getString("answer_vaule"));
				}
				
			
		}
			
		} catch (Exception e) {
			System.out.println("DB접속 에러");
		}

	}

}


