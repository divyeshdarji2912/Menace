package logger;

import org.apache.log4j.*;

import java.io.IOException;

public class FileConfigurator {

    private static final String FILE_PATH = "src/main/java/output/output.txt";

    public static void configure() throws IOException {
        Logger logRoot = Logger.getRootLogger();

        PatternLayout layout = new PatternLayout("%m%n");
        FileAppender appender = new FileAppender(
                layout,
                FILE_PATH,
                true,
                false,
                8192);
        logRoot.addAppender(appender);
    }
}
