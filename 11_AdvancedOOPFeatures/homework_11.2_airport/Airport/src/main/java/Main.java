import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.util.*;

import static com.skillbox.airport.Flight.Type.ARRIVAL;
import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.



        Date date1 =  new Date ();
        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.HOUR, 2);

        ArrayList <Flight> flights = new ArrayList<>();

        airport.getTerminals().stream()
                .forEach(terminal -> terminal.getFlights().stream()
                        .filter(flight -> flight.getDate().after(date1) && flight.getDate().before(date2.getTime()) && flight.getType().equals(DEPARTURE))
                        .forEach(flight -> flights.add(flight)));
        return flights;




    }


}