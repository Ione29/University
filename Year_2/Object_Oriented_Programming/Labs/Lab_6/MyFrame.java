import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame{
    
   // private EventController ec;
    private Label l1 = new Label("Name");
    private TextField t1 = new TextField(20);
    private Label l2 = new Label("Gender");
    private Label l3 = new Label("Job Description");
    private TextArea t2 = new TextArea(10, 10);
    private Label l4 = new Label("Experience (in years)");
    private TextField t3 = new TextField(2);
    private Label l5 = new Label("Location");
    private Scrollbar hsb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 1, 100);
    private Button button1 = new Button("Add");
    private Button button2 = new Button("Show all");

    private EventController sController = new EventController();
    

    public class EventController implements AdjustmentListener{
        public void adjustmentValueChanged(AdjustmentEvent event){
            int years = hsb.getValue();
            t3.setText(String.valueOf(years));
        }
    }

    public class addPerson implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            
        }
    }

    public class showPersons implements ActionListener{
        public void actionPerformed(ActionEvent event){

        }
    }

    final int WIDTH = 250;
    final int HEIGHT = 700;
    

    public MyFrame(){
        setTitle("Persons");
        //ec = new EventController();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(WIDTH, HEIGHT);
        add(l1);
        add(t1);
        add(l2);
        CheckboxGroup cbg = new CheckboxGroup();
            add(new Checkbox("Male", cbg, false));
            add(new Checkbox("Female", cbg, false));
        add(l3);
        add(t2);
        add(l4);
        add(t3);
        add(hsb);
        hsb.addAdjustmentListener(sController);
        add(l5);
        Choice locationChooser = new Choice();
        locationChooser.add("Bucharest");
        locationChooser.add("Iasi");
        locationChooser.add("Cluj-Napoca");
        locationChooser.add("Budapest");
        locationChooser.add("Berlin");
        add(locationChooser);
        
    }
}