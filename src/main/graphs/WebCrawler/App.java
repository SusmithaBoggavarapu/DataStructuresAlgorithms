package WebCrawler;

public class App {
    public static void main(String[] args){
        String rootURL = "https://www.bbc.com/";
        WebCrawler.discoverWeb(rootURL);
    }
}
