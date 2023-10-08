import java.awt.*;
import java.awt.event.*;

public class AirportFrame extends Frame{
    
    private int DEFAULT_HEIGHT = 100;
    private int DEFAULT_WIDTH = 100;

    private Panel upperHalf = new Panel();
        private Panel flights = new Panel();
            private Label l1 = new Label("Airport");
            private TextArea flightTextArea = new TextArea(6, 5);
        
        private Panel boxes = new Panel();
            private Label l2 = new Label("ID");
            private TextField idField = new TextField();
            private Label l3 = new Label("Departure");
            private TextField departureField = new TextField();
            private Label l4 = new Label("Arrival");
            private TextField arrivalField = new TextField();
            private Label l5 = new Label("Time");
            private TextField timeField = new TextField();

    private Panel lowerHalf = new Panel();
        private Button loadFlights = new Button("Load Flights");
        private Button computeCost = new Button("Compute Cost");
        private Button addFlight = new Button("Add Flight");

    public AirportFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        upperHalf.setLayout(new GridLayout(1, 2));
            flights.add(l1);
            flights.add(flightTextArea);
        upperHalf.add(flights);
            boxes.setLayout(new GridLayout(4, 2));
            boxes.add(l2);
            boxes.add(idField);
            boxes.add(l3);
            boxes.add(departureField);
            boxes.add(l4);
            boxes.add(arrivalField);
            boxes.add(l5);
            boxes.add(timeField);

        add(upperHalf);

        lowerHalf.setLayout(new GridLayout(1, 3));
        lowerHalf.add(loadFlights);
        lowerHalf.add(computeCost);
        lowerHalf.add(addFlight);
    }
}
