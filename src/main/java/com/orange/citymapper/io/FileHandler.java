package com.orange.citymapper.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
	public String readFile(String path) throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  
	  return new String(encoded, Charset.defaultCharset());
	}

	public void writeln(String string, String content) throws IOException{
		FileWriter writer = new FileWriter(string);
		writer.write(content);
		writer.close();
	}
}
