package algorithms.logger;

public class LoggerTest {
    static Logger logger = new DefaultLogger();
    public static void main(String args[]){
        logger.info("log firstname {} lastname {}","susmitha", "vutturi");
    }

}
