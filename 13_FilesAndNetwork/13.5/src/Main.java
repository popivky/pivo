import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONArray;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static final String DATA_FILE = "C:\\Users\\79268\\Documents\\13_FilesAndNetwork\\13.5\\data\\moscow.json";

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            Elements elements = doc.select("div[data-depend]").select("[data-line]");
            Elements elementsStations = doc.select("div[class=\"js-metro-stations t-metrostation-list-table\"]").select("[data-line]");
            Elements elementsConnections = doc.select("g[class=\"p2p2\"]").select("[stroke]");
            Elements elementsStationsID = doc.select("a[data-metrost]");
            JSONObject objectStationValue = new JSONObject();
            JSONArray connectionsJsonArrayValue = new JSONArray();
            List<String> stIds = new ArrayList<>();
            Map<String, String> idsMap = new TreeMap();
            Map<String, String> idsMapz = new TreeMap();


            for (Element elStation : elementsStations) {
                Map<String, String> eleMapSt = elStation.dataset();
                List<String> stationsArray = new ArrayList<>(List.of(elStation.text().replaceAll("\\d+.", "").trim().split("\\s\\s")));
                JSONArray stationList = new JSONArray();
                stationList.add(stationsArray);
                objectStationValue.put(eleMapSt.get("line"), stationsArray);
                idsMapz.put(eleMapSt.get("line"), String.valueOf(stationsArray));

            }


            for (Element elConnection : elementsConnections) {
                String srt = elConnection.toString();
                stIds.add(srt.substring(srt.lastIndexOf("class="), srt.lastIndexOf("stroke")).replaceAll("[^0-9\\s]", "").trim());

            }

            for (Element elIds : elementsStationsID) {
                idsMap.put(elIds.toString().substring(elIds.toString().indexOf('"'), elIds.toString().indexOf(",")).replaceAll("[^0-9]", ""), elIds.text().substring(elIds.text().indexOf(".") + 2));
            }

            for (String search : stIds) {
                String[] ids = search.split("\\s");

                JSONArray oneConnections = new JSONArray();
                JSONObject stationConnect1 = new JSONObject();
                JSONObject stationConnect2 = new JSONObject();
                stationConnect1.put("station", idsMap.get(ids[0]));
                for (String key : idsMapz.keySet()) {
                    if (idsMapz.get(key).contains(idsMap.get(ids[0]))) {
                        stationConnect1.put("line",key );
                    }

                }


                    stationConnect2.put("station", idsMap.get(ids[1]));


                    for (String key : idsMapz.keySet()) {
                    if (idsMapz.get(key).contains(idsMap.get(ids[1])) && !key.equals(stationConnect1.get("line"))) {
                        stationConnect2.put("line", key);
                    }
                }

                    oneConnections.add(stationConnect1);
                    oneConnections.add(stationConnect2);
                    connectionsJsonArrayValue.add(oneConnections);


                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(DATA_FILE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                JSONObject mapMoscowJson = new JSONObject();
                JSONArray linesArrJson = new JSONArray();


                for (Element el : elements) {
                    Map<String, String> eleMap = el.dataset();
                    JSONObject object = new JSONObject();
                    object.put("number", eleMap.get("line"));
                    object.put("name", el.text());
                    linesArrJson.add(object);

                }

            mapMoscowJson.put("lines", linesArrJson);
            mapMoscowJson.put("stations", objectStationValue);
            mapMoscowJson.put("connections", connectionsJsonArrayValue);

                writer.write(mapMoscowJson.toJSONString());

                writer.flush();
                writer.close();

            }
            } catch(IOException e){
                e.printStackTrace();
            }

        StringBuilder builder = new StringBuilder();
        try {
            List<String> line = Files.readAllLines(Paths.get(DATA_FILE));
            line.forEach(lines -> builder.append(lines + "\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        String stationsLines = builder.substring(builder.indexOf("stations\"")+9, builder.indexOf("lines"));
        String [] arrStationsLines = stationsLines.replace(" ", "").split("\\w?\\d+\\w?");
      String linesNum = stationsLines.replaceAll("[^\\w?\\d+\\w?]", " ").replaceAll("\\s+", " ").trim();
      String[] arrLinesNum = linesNum.split(" ");
      Map<String, Integer> mapNumLenth = new TreeMap<>();
      for (int i = 0; i < arrLinesNum.length; i++){
          ArrayList <String> stations = new ArrayList<>();
        String [] dasd =  arrStationsLines[i + 1].replaceAll("[^а-яёА-ЯЁ-]", " ").replaceAll("\\s+", " ").trim().split(" ");
          stations.addAll(List.of(dasd));
          int res = stations.size();
          mapNumLenth.put(arrLinesNum[i], res);
      }

      for( String result : mapNumLenth.keySet()){
          System.out.println("Колличество станций на линии " + result + " : " + mapNumLenth.get(result));
      }

    }
    }


