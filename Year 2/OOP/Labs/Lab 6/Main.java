import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static class MyFrame extends Frame{
        //elements
        private Label l1 = new Label("Name");
        private TextField name = new TextField(20);
        private Label l2 = new Label("Gender");
        private Label l3 = new Label("Job Description");
        private TextArea jobDescription = new TextArea(4, 10);
        private Label l4 = new Label("Experience (in years)");
        private TextField experience = new TextField(2);
        private Label l5 = new Label("Location");
        private Scrollbar hsb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 1, 100);
        private Button button1 = new Button("Add");
        private Button button2 = new Button("Show all");
        private Button button3 = new Button("Save all");
        private CheckboxGroup cbg = new CheckboxGroup();
        private Checkbox male = new Checkbox("Male", cbg, false);
        private Checkbox female = new Checkbox("Female", cbg, false);
        private Choice locationChooser = new Choice();
            
        //array of persons
        private ArrayList<Person> persons = new ArrayList<Person>();

        //events
        private EventController sController = new EventController();
        private addPerson button1Event = new addPerson();
        private showPersons button2Event = new showPersons();
        private saveToFile button3Event = new saveToFile();

        public class EventController implements AdjustmentListener{
            public void adjustmentValueChanged(AdjustmentEvent event){
                int years = hsb.getValue();
                experience.setText(String.valueOf(years));
            }
        }

        public class addPerson implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                String gender = " ";
                if(male.getState() == true)
                    gender = "Male";
                else if(female.getState() == true)
                    gender = "Female";
                persons.add(new Person(name.getText(), gender, jobDescription.getText(), hsb.getValue(), locationChooser.getSelectedItem()));
            }
        }

        /*public class showPersons implements ActionListener{
            public void actionPerformed(ActionEvent event){
                for(Person person : persons)
                    System.out.println(person.toString());
            }
        }*/

        public class showPersons implements ActionListener{
            public void actionPerformed(ActionEvent event){
                
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

                class PersonsFrame extends Frame{
                    private final int WIDTH = 600;
                    private final int HEIGHT = 600;
                    
                    public PersonsFrame(){
                        setSize(WIDTH, HEIGHT);
                        setTitle("Persons until now");
                        setLayout(new FlowLayout(FlowLayout.LEFT));
                        
                        for(Person person : persons)
                            add(new Label(person.toString()));
                    }  
                } 

                PersonsFrame pFrame = new PersonsFrame();
                WindowListener wListener = new Terminator();
                pFrame.addWindowListener(wListener);
                pFrame.setVisible(true);

            }
        }

        public class saveToFile implements ActionListener{
            public void actionPerformed(ActionEvent event){
                try{
                    FileWriter writer = new FileWriter("persons.txt");
                    
                    for(Person person : persons)
                        writer.write(person.toString() + "\n");
        
                    writer.close();
                }catch(IOException e){
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
            }
        }

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

        WindowListener fListener = new Terminator();

        private final int WIDTH = 250;
        private final int HEIGHT = 500;

        public MyFrame(){
            this.addWindowListener(fListener);
            setTitle("Job Application");
            setLayout(new GridLayout(6,1));
            setSize(WIDTH, HEIGHT);
            Panel p1 = new Panel();
            p1.add(l1);
            p1.add(name);
            add(p1);
            Panel p2 = new Panel();
            p2.add(l2);
            p2.add(male);
            p2.add(female);
            add(p2);
            Panel p3 = new Panel();
            p3.add(l3);
            p3.add(jobDescription);
            add(p3);
            Panel p4 = new Panel();
            p4.add(l4);
            p4.add(experience);
            p4.add(hsb);
            hsb.addAdjustmentListener(sController);
            add(p4);
            Panel p5 = new Panel();
            p5.add(l5);
            locationChooser.add("Bucharest");
            locationChooser.add("Iasi");
            locationChooser.add("Cluj-Napoca");
            locationChooser.add("Budapest");
            locationChooser.add("Berlin");
            p5.add(locationChooser);
            add(p5);
            Panel p6 = new Panel();
            button1.addActionListener(button1Event);
            button2.addActionListener(button2Event);
            button3.addActionListener(button3Event);
            p6.add(button1);
            p6.add(button2);
            p6.add(button3);
            add(p6);
        }
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }   
}
