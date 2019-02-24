package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class SetupController {
	@Autowired
	private DataSource dataSource;

	@RequestMapping("/setup")
	String db(Map<String, Object> model) {
		try {
			//String value = new String(Files.readAllBytes(Paths.get(getClass().getResource("schema.sql").toURI())));
			
			URL url = getClass().getResource("schema.sql");
			File myFile = new File(url.toURI());

			String value = FileUtils.readFileToString(myFile, "UTF-8"); 

			model.put("msg", value);

		} catch (Exception e) {
			model.put("msg", e.toString());
			e.printStackTrace();
		}

		return "setup";
	}
}
