package com.online.store.demo.common;

import java.io.FileReader;
import org.json.simple.parser.JSONParser;

/**
 * This class contains BDD common utility methods
 *
 * @author rajiv.srivastava
 */
public class BddTestUtil {

	public static String readJsonFile(String file) {
		JSONParser parser = new JSONParser();
		try {
			return parser.parse(new FileReader(file)).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
