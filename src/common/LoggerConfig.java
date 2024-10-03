package common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {
    static {
        try {
            Logger rootLogger = Logger.getLogger("");
            for (Handler handler : rootLogger.getHandlers()) {
                rootLogger.removeHandler(handler);
            }

            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(java.util.logging.Level.ALL); 

        } catch (IOException e) {
            throw new RuntimeException(new CustomException("Exception in LoggerConfig",e));
        }
    }
}
