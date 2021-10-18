import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> links = new ArrayList<>();
            Document doc = Jsoup.connect(" https://lenta.ru").get();
            Elements link = doc.select("img[src]");
            link.forEach(element -> links.add(element.absUrl("src")));
            for (String lnks : links){
                if(lnks.substring(lnks.lastIndexOf('.')+1).length()!=3){
                    continue;
                }
              File destination = new File("images/" + lnks.substring(lnks.lastIndexOf("/")+1));
                URL url = new URL(lnks);
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream(destination);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
                rbc.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
