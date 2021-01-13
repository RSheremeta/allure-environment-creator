package com.github.rsheremeta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/*
This was done by Roman Sheremeta - https://github.com/RSheremeta
 */
public final class AllureEnv {
  private static final Properties props;

  private AllureEnv() { }

  static {
    props = new Properties();
  }

  public static void createAllureEnvironmentFile(Map<String, String> propsConfig, String pathToAllureResultsDir) {
    propsConfig.forEach(props::setProperty);

    try(FileOutputStream fos = new FileOutputStream(new File(pathToAllureResultsDir + "/environment.properties"))) {
      props.store(fos, "Environment properties data for Allure report");
      System.out.println("Allure environment.properties file has been created and stored successfully in the " + pathToAllureResultsDir);
    } catch (IOException e) {
      System.out.println("OOPS! Something went wrong with environment.properties file creation. \n");
      e.printStackTrace();
    }

  }

  public static void createAllureEnvironmentFile(Map<String, String> propsConfig) {
    createAllureEnvironmentFile(propsConfig, System.getProperty("user.dir") + "/target/allure-results/");
  }

}
