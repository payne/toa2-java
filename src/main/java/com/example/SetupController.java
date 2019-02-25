package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SetupController extends SqlController {


	@RequestMapping("/setup")
	String db(Map<String, Object> model) {
		try {
			//String value = new String(Files.readAllBytes(Paths.get(getClass().getResource("schema.sql").toURI())));
			URL url = new URL("https://raw.githubusercontent.com/payne/toa2-java/master/src/main/resources/schema.sql");
			InputStream iStream = url.openStream();
			LineNumberReader in = new LineNumberReader(new InputStreamReader(iStream));
			String line, statement="";
			List<String> messages=new ArrayList<>();
			while (null != (line=in.readLine())) {
				if (line.trim().length()==0) {
					messages.add(statement);
					executeSql(statement);
					statement="";
				} else {
					statement += line +"\n";
				}
			}
			model.put("messages", messages);
		} catch (Exception e) {
			model.put("msg", e.toString());
			e.printStackTrace();
		}

		return "setup";
	}
	

	
}
