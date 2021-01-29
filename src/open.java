import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class open extends JFrame {
    JTextArea textArea;
    public open(JTextArea textArea){
        this.textArea = textArea;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);


        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        textArea.append(line);
                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            finally {
                fileIn.close();
            }
        }
    }
}
