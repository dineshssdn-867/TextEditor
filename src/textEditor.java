import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class textEditor extends JFrame implements ActionListener {
    JTextArea textArea; // Declaring textarea
    JScrollPane scrollPane; // declaring scroll bar
    JButton color_change; // declaring color button
    JMenuBar menuBar; // declaring menu bar for save and close options
    JMenu fileMenu, formatMenu; // declaring file label from which we can access different options
    JMenuItem openItem; // declaring open button
    JMenuItem saveItem; // declaring save button
    JMenuItem exitItem; // declaring close button
    JMenuItem fontBox; // declaring open button
    JMenuItem colorbutton; // declaring save button
    Dimension screenSize; // setting the screen size to be full

    public textEditor(){
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it will get close when we click to X button
        this.setTitle("D's Editor"); // it will add the title to text editor
        this.setSize(screenSize.width, screenSize.height);  // it will set height and width
        this.setLayout(new BorderLayout()); // it will set the layout like what we want grid or simple layout
        this.setLocationRelativeTo(null); // it will make our window in center
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("download.png"));

        textArea = new JTextArea(); // we are defining a text area in our pane
        textArea.setSize(1920,720);
        textArea.setLineWrap(true); //this will set line wrap limit
        textArea.setWrapStyleWord(true); // this will apply the wrap style to be according to the words
        textArea.setFont(new Font("Arial",Font.PLAIN,50)); // this will set the font details
        scrollPane = new JScrollPane(textArea); // we are commmanding our scrollbar to wrok according to text area
        scrollPane.setPreferredSize(new Dimension(1920,1080)); // set size of pane after which it will become active
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // this will set th


        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        formatMenu = new JMenu("Format");
        fontBox = new JMenuItem("Font style");
        colorbutton = new JMenuItem("Change color");


        fontBox.addActionListener(this);
        colorbutton.addActionListener(this);


        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        formatMenu.add(fontBox);
        formatMenu.add(colorbutton);
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);

        this.setJMenuBar(menuBar);
        this.add(scrollPane); // we are adding this component to our editor
        this.setVisible(true);   // it will the set visibility to true

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == colorbutton){
            color_change =new JButton("color");
            color_change.addActionListener(this);
            color co =  new color(textArea);
        }

        if(e.getSource()==fontBox) {

        }

        if(e.getSource()==openItem) {
            open op=new open(textArea);
        }

        if(e.getSource()==saveItem){
            save sv=new save(textArea);
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
    }
}
