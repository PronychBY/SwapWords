package by.epam.grodno.pronych.compositetext.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.log4j.Logger;


public class FileService {
    final static Logger logger = Logger.getLogger(FileService.class);

	public static String getTextFromFile(final String path) {
		String result = "";
		try (Stream<String> stringLine = Files.lines(Paths.get(path), StandardCharsets.UTF_8)){
			result = stringLine.reduce("", (a,b) -> a + "\n" + b);
	    	logger.info("file sucsessfully read:"+path);

		} catch (IOException e) {
	    	logger.error("Can not read file:"+path);
		}
		return result;
	}
	
	private static String getTextFromFile2(final String path) {
        String text = "";
        try (FileInputStream inFile = new FileInputStream(path)){
            
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch (FileNotFoundException e) {
	    	logger.error("Can not find file file:"+path);
        } catch (IOException e) {
	    	logger.error("Can not read file:"+path);
        }
        return text;
    }	

}
