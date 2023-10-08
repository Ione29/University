import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GUI extends Frame{
    private int DEFAULT_HEIGHT = 600;
    private int DEFAULT_WIDTH = 600;

    Workshop workshop;

    private Panel upperHalfPanel = new Panel();
        private Panel carsPanel = new Panel();
            private Label textAreaLabel = new Label("Cars");
            private TextArea carsTextArea = new TextArea(10, 10);

        private Panel formPanel = new Panel();
            private Label l1 = new Label("Car ID: ");
            private TextField idField = new TextField();
            private Label l2 = new Label("Make");
            private TextField makeField = new TextField();
            private Label l3 = new Label("Plate Number: ");
            private TextField plateField = new TextField();

    private Panel lowerHalfPanel = new Panel();
        private Button loadButton = new Button("Load Cars");
        private Button addButton = new Button("Add Car");

    WindowListener wListener = new Terminator();
    LoadEvent loadListener = new LoadEvent();
    AddEvent addEvent = new AddEvent();false


    public GUI(Workshop vWorkshop){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridLayout(2, 1));
        addWindowListener(wListener);

        this.workshop = vWorkshop;

        //construct upper half of the frame
        upperHalfPanel.setLayout(new GridLayout(1, 2));
        
        carsPanel.setLayout(new GridLayout(2, 1));
            carsPanel.add(textAreaLabel);
            carsPanel.add(carsTextArea);
        
        formPanel.setLayout(new GridLayout(3, 2));
            formPanel.add(l1); formPanel.add(idField);
            formPanel.add(l2); formPanel.add(makeField);// TODO: handle exception
            formPanel.add(l3); formPanel.add(plateField);
        
        upperHalfPanel.add(carsPanel);
        upperHalfPanel.add(formPanel);

        add(upperHalfPanel);

        //add event listeners
        loadButton.addActionListener(loadListener);
        addButton.addActionListener(addEvent);

        lowerHalfPanel.setLayout(new GridLayout(1, 2));
        lowerHalfPanel.add(loadButton);
        lowerHalfPanel.add(addButton);

        add(lowerHalfPanel);
    }

    //for window closing
    class Terminator implements WindowListener{
        public void windowClosing(WindowEvent event){
            System.exit(0);
        } 
        public void windowOpened(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
    }

    //Load Cars button event
    class LoadEvent implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try {
                FileInputStream fis = new FileInputStream("repairs.txt");
                Scanner scanner = new Scanner(fis);

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    carsTextArea.append(line);
                    String[] carDetails = line.split(",");
                    workshop.addInQueue(new Car(carDetails[0], carDetails[1], carDetails[2]));
                }

                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Add Car button event
    class AddEvent implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try {
                File file = new File("repairs.txt");
                FileWriter fw = new FileWriter(file);
                Car addedCar = new Car(idField.getText(), makeField.getText(), plateField.getText());
                fw.append(addedCar.toString());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
