package logger;

import org.apache.log4j.Logger;

import java.io.IOException;

public class LogManager {

    private static LogManager logManager;
    private LogManager() throws IOException {
        FileConfigurator.configure();
    }

    public static LogManager getInstance() throws IOException {
        if (logManager == null) {
            logManager = new LogManager();
        }
        return logManager;
    }

    /* Get actual class name to be printed on */
    private static Logger log = Logger.getLogger(LogManager.class.getName());

    public void log(String result) throws IOException {
        log.info(result);
    }

}
