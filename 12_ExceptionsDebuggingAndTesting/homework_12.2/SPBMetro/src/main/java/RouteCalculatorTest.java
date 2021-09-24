import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

        StationIndex stationIndex = new StationIndex();

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        ArrayList<Station> connect1 = new ArrayList<>();
        ArrayList<Station> connect2 = new ArrayList<>();



    @Override
    protected void setUp() throws Exception {

        Line lineRed = new Line (1, "Red");
        Line lineGreen = new Line(2, "Green");
        Line lineBlue = new Line(3, "Blue");

        lineRed.addStation(new Station("Reggie", lineRed));
        lineRed.addStation(new Station("Redmond", lineRed));
        lineRed.addStation(new Station("Redemption", lineRed));
        lineGreen.addStation(new Station("Greeting", lineGreen));
        lineGreen.addStation(new Station("Greenly", lineGreen));
        lineBlue.addStation(new Station("Bloom", lineBlue));
        lineBlue.addStation(new Station("Blaze", lineBlue));

        stationIndex.addLine(lineRed);
        stationIndex.addLine(lineGreen);
        stationIndex.addLine(lineBlue);

        lineBlue.getStations().forEach(station -> stationIndex.addStation(station));
        lineGreen.getStations().forEach(station -> stationIndex.addStation(station));
        lineRed.getStations().forEach(station -> stationIndex.addStation(station));


        connect1.add(stationIndex.getStation("Reggie"));
        connect1.add(stationIndex.getStation("Greeting"));
        connect2.add(stationIndex.getStation("Bloom"));
        connect2.add(stationIndex.getStation("Redemption"));

        stationIndex.addConnection(connect1);
        stationIndex.addConnection(connect2);

    }


    public void testGetShortestRoute(){

      List actual =  routeCalculator.getShortestRoute(stationIndex.getStation("Reggie"), stationIndex.getStation("Greenly"));
      List  <Station> route = new ArrayList<>();
      route.add(stationIndex.getStation("Reggie"));
      route.add(stationIndex.getStation("Greeting"));
      route.add(stationIndex.getStation("Greenly"));
      List <Station> expected = route;
      assertEquals(actual, expected);
    }

    public void testGetRouteOnTheLine(){

        List actual = routeCalculator.getShortestRoute(stationIndex.getStation("Reggie"), stationIndex.getStation("Redemption") );
        List  <Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Reggie"));
        route.add(stationIndex.getStation("Redmond"));
        route.add(stationIndex.getStation("Redemption"));
        List <Station> expected = route;
        assertEquals(actual, expected);
    }

    public void testGetRouteWithOneConnection(){

        List actual =  routeCalculator.getShortestRoute(stationIndex.getStation("Blaze"), stationIndex.getStation("Redmond"));
        List  <Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Blaze"));
        route.add(stationIndex.getStation("Bloom"));
        route.add(stationIndex.getStation("Redemption"));
        route.add(stationIndex.getStation("Redmond"));

        List <Station> expected = route;
        assertEquals(actual, expected);

    }

    public void testGetRouteWithTwoConnections(){

        List actual = routeCalculator.getShortestRoute(stationIndex.getStation("Greenly"), stationIndex.getStation("Blaze") );
        List  <Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Greenly"));
        route.add(stationIndex.getStation("Greeting"));
        route.add(stationIndex.getStation("Reggie"));
        route.add(stationIndex.getStation("Redmond"));
        route.add(stationIndex.getStation("Redemption"));
        route.add(stationIndex.getStation("Bloom"));
        route.add(stationIndex.getStation("Blaze"));

        List <Station> expected = route;
        assertEquals(actual, expected);

    }

    protected void tearDown() throws Exception{

    }

}
