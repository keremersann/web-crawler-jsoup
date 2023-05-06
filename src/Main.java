import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://cm2023.obss.io/2165506a-18f1-4322-a260-bd8b6dc2240e?lang=EN").get();

        // prints the title
        String title = doc.title();
        //System.out.println(title);

        // prints the body of the extracted HTML
       //System.out.println(doc.body());

        // fetching the content element
        //Element content = doc.getElementById("content");

        // fetching the anchor tags inside content element
        Elements links = doc.getElementsByTag("a");
        List<String> uniqueLinks = new ArrayList<>();
        for (Element link : links) {
            String linkHref = link.attr("href");
            if(!uniqueLinks.contains(linkHref))
                uniqueLinks.add(linkHref);
        }

        for(String a : uniqueLinks){
            System.out.println(a);
        }


        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            System.out.println(linkText+ " " + linkHref);
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}