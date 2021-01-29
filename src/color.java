import javax.swing.*;
import java.awt.*;

public class color extends JFrame {
    JTextArea textArea;
    public color(JTextArea textArea){
        this.textArea = textArea;
        JColorChooser colorchoose = new JColorChooser();
        Color color = colorchoose.showDialog(null,"Choose a color",Color.black);
        textArea.setForeground(color);
    }
}
