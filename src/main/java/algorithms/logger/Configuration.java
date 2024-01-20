package algorithms.logger;

import java.util.List;

public class Configuration {
    static WriteAppender writeAppender = new ConsoleAppender();
    static String patternLayout = "YYYY-DD-MM";
    List<Level> logLevels;
    boolean isDebugEnabled(){
        return logLevels.contains(Level.DEBUG);
    }
}
