package gatling;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import scala.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AppProperties {

    public static Config config = ConfigFactory.load("env.properties");

    public static String getProperty(String key){
        return config.getValue(key).unwrapped().toString();
    }

}
