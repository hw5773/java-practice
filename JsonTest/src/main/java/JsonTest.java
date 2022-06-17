import java.io.*;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.cli.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.Thread.sleep;

public class JsonTest {
  final static Log logger = LogFactory.getLog(JsonTest.class);

  public static void main(String[] args) throws Exception {
    Options options = new Options();

    Option argFile = new Option("f", "file", true, "File that contains the JSON string");
    options.addOption(argFile);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd = null;

    try {
      cmd = parser.parse(options, args);
    } catch (Exception e) {
      logger.error(e.getMessage());
      formatter.printHelp("Options", options);

      System.exit(1);
    }

    String jsonFilePath = cmd.getOptionValue("file");

    if (jsonFilePath == null) {
      logger.error("The JSON file should be inserted");
      formatter.printHelp("Options", options);

      System.exit(1);
    }

    File ctest = new File(jsonFilePath);
    if (!ctest.exists()) {
      logger.error("The JSON File (" + jsonFilePath + ") does not exist");
      formatter.printHelp("Options", options);

      System.exit(1);
    }

    if (ctest.isDirectory()) {
      logger.error(jsonFilePath + " must not be a directory");
      formatter.printHelp("Options", options);

      System.exit(1);
    }

    if (jsonFilePath != null) {
      logger.info("JSON File Mode (File Path: " + jsonFilePath + ")");
      FileReader reader = new FileReader(jsonFilePath);
      JSONParser jsonParser = new JSONParser();
      JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

      JSONArray sample = (JSONArray) jsonObject.get("sample");

      Iterator i = sample.iterator();

      while (i.hasNext()) {
        JSONObject innerObj = (JSONObject) i.next();
        System.out.println("Name: " + innerObj.get("name") + " (rollNo. " 
              + innerObj.get("rollNo") + ") / id: " + innerObj.get("id"));
      }
    }
    else {
      logger.error("Should not happen");
    }
  }
}
