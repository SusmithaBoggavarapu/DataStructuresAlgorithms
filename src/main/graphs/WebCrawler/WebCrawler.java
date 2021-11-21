package WebCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    public static void discoverWeb(String rootURL) {
        Queue<String> urlsQ = new LinkedList<>();
        Set<String> discoveredSet = new HashSet<>();
        urlsQ.add(rootURL);
        while (!urlsQ.isEmpty()) {
            String url = urlsQ.remove();
            String rawHTML = getRawHTML(url);
            //System.out.println("rawHTML: "+ rawHTML);
            String regex = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHTML);

            while (matcher.find()){
                String actualURL = matcher.group();
                if (discoveredSet.add(actualURL)) {
                    System.out.println("discovered new url: " + actualURL);
                    urlsQ.add(actualURL);
                }

            }

        }
    }

    public static String getRawHTML(String url) {
        String rawHTML = "";

        try {
            URL u = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
            String ip = "";
            while ((ip = br.readLine()) != null) {
                rawHTML += ip;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }
        return rawHTML;


    }
}
