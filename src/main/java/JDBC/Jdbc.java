package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc
{
    public static void main(String[] args)
    {
        Jdbc jdbc = new Jdbc();
        jdbc.insert("jdbc:mysql://localhost:3306/studyPlan", "root", "root","daedyu", "123", "legolove08@naver.com");

    }
    public boolean insert(String url, String username, String password, String id, String pw, String email) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // 연결 성공
            String insertQuery = "INSERT INTO user (ID, PASSWORD, EMAIL) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // 값을 설정합니다.
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, pw);
                preparedStatement.setString(3, email);

                // 쿼리 실행
                int rowsAffected = preparedStatement.executeUpdate();

                // 쿼리 실행 결과에 따라 boolean 값을 반환
                return rowsAffected > 0;
            }
        }
        catch (SQLException e) {
            // 예외 처리
            e.printStackTrace();
            return false; // 예외 발생 시 false 반환
        }
    }
}
