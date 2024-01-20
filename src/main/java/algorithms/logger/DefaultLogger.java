package algorithms.logger;

public class DefaultLogger implements Logger{
    @Override
    public void info(String msg, Object... args){
        WriteAppender writeAppender = Configuration.writeAppender;
        msg = getFormattedMsg(Configuration.patternLayout,msg,args);
        writeAppender.write(msg);
    }
}
