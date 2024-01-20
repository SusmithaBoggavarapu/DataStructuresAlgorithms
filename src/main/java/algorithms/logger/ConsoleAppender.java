package algorithms.logger;

public class ConsoleAppender implements WriteAppender {

    public void write(String msg) {
        System.out.println(msg);
    }

}
