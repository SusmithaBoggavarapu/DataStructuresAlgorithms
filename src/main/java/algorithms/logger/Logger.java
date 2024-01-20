package algorithms.logger;

import java.util.Arrays;
import java.util.Objects;

public interface Logger {
    void info(String msg, Object... args);

    default String getFormattedMsg(String patternLayout, String msg, Object[] args) {
        String formattedMsg = msg;
        for (int i = 0; i < args.length; i++) {
            formattedMsg  = formattedMsg.replaceFirst("\\{\\}",args[i].toString());
        }

        return formattedMsg;
    }
}
