package com.company.persistence;
// DB연동시 매번 반복되는 코드 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
   // 자원 해제
   public static void close(Connection con) {
      if (con != null) {
         try {
            con.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

   public static void close(PreparedStatement pstmt) {
      if (pstmt != null) {
         try {
            pstmt.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

   public static void close(ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }
}