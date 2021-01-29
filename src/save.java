import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class save extends JFrame {
    JTextArea textArea;
    public save(JTextArea textArea){
        this.textArea = textArea;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null;

            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(textArea.getText());
            }
            catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            finally {
                fileOut.close();
            }
        }
    }
}
