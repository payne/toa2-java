package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

public class PersonController  extends SqlController   {

	@RequestMapping("/tags")
	String tags(Map<String, Object> model) {
		 try (Connection connection = dataSource.getConnection()) {
		      Statement stmt = connection.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM tags");
System.out.println("Running selecting * from tags;");
		      ArrayList<String> output = new ArrayList<String>();
		      while (rs.next()) {
		        output.add(rs.getString("tag"));
		      }
		      System.out.println(output);
		      model.put("tags", output);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		return "tags";
	}
	
}
