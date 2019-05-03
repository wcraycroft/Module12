import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class PigLatin extends JFrame implements ActionListener {

    // Constants
    private static final int WIDTH = 800;
    private static final int HEIGHT = 250;
    private static final String FRAME_TITLE = "Pig Latin Translator";
    private static final String SCREEN_TITLE = "Pig Latin Translator";
    private static final String ENTRY_HEADING = "Please Enter A String to Translate:";
    private static final String TRANSLATED_HEADING = "Translated String";
    private static final String NOTHING_TO_TRANSLATE = "(nothing to translate)";
    private static final String TRANSLATE_BUTTON_TEXT = "Translate";
    private static final String CLOSE_BUTTON_TEXT = "Exit";
    private static final String SAMPLE_TEXT = "Example: \"Oh my word\"" +
            " translates to \"Ohway ymay ordway\"";

    // Member variables
    private JTextArea inputArea;
    private JTextArea translateArea;

    // Constructor
    public PigLatin() {
        setTitle(FRAME_TITLE) ;
        setSize(WIDTH, HEIGHT) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        setLocationRelativeTo(null) ;
        setLayout(new GridLayout(5, 1)) ;

        // Create 5 JPanels
        JPanel titlePanel = new JPanel() ;
        add(titlePanel) ;
        JPanel secondPanel = new JPanel() ;
        add(secondPanel) ;
        JPanel inputPanel = new JPanel() ;
        add(inputPanel) ;
        JPanel buttonPanel = new JPanel() ;
        add(buttonPanel) ;
        JPanel samplePanel = new JPanel() ;
        add(samplePanel) ;

        // Build first Panel - Screen Title
        JLabel titleLabel = new JLabel(SCREEN_TITLE) ;
        titlePanel.add(titleLabel) ;
        titleLabel.setHorizontalAlignment(JLabel.CENTER) ;
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 22)) ;

        // Build second Panel - Headings
        secondPanel.setLayout(new GridLayout(1, 2)) ;

        JLabel entryLabel = new JLabel(ENTRY_HEADING) ;
        entryLabel.setHorizontalAlignment(JLabel.CENTER) ;
        secondPanel.add(entryLabel) ;

        JLabel translatedLabel = new JLabel(TRANSLATED_HEADING) ;
        translatedLabel.setHorizontalAlignment(JLabel.CENTER) ;
        secondPanel.add(translatedLabel) ;

        // Build third Panel - Input and output areas
        inputPanel.setLayout(new GridLayout(1, 2)) ;

        inputArea = new JTextArea() ;
        inputArea.setLineWrap(true) ;
        inputArea.setWrapStyleWord(true) ;
        inputArea.setEditable(true) ;

        translateArea = new JTextArea() ;
        translateArea.setBackground(new Color(210, 210, 255)) ;
        translateArea.setLineWrap(true) ;
        translateArea.setWrapStyleWord(true) ;
        translateArea.setEditable(false) ;

        inputPanel.add(inputArea) ;
        inputPanel.add(translateArea) ;

        // Build fourth Panel - Buttons
        buttonPanel.setLayout(new FlowLayout()) ;

        JButton translateButton = new JButton(TRANSLATE_BUTTON_TEXT) ;
        translateButton.setActionCommand("translate") ;
        translateButton.addActionListener(this) ;
        buttonPanel.add(translateButton) ;

        JButton closeButton = new JButton(CLOSE_BUTTON_TEXT) ;
        closeButton.setActionCommand("stop") ;
        closeButton.addActionListener(this) ;
        buttonPanel.add(closeButton) ;

        // Build fifth Panel - Sample Text
        samplePanel.add(new JLabel(SAMPLE_TEXT)) ;
    }

    // Helper methods
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand() ;
        if (actionCommand.equals("translate")) {
            String textToConvert = inputArea.getText() ;
            // convert to Pig Latin
            String convertedText = textToConvert ;
            translateArea.setText(convertedText) ;
        } else if (actionCommand.equals("stop")){
            System.exit(0) ;
        }
    }

    public String translate(String textToConvert) {
        Scanner scan = new Scanner(textToConvert);
        String convertedText = "", current;
        while (scan.hasNext()) {
            current = scan.next();
            // Check for first letter vowel
            if (current.substring(0,1).equalsIgnoreCase("A") ||
                    current.substring(0,1).equalsIgnoreCase("E") ||
                    current.substring(0,1).equalsIgnoreCase("I") ||
                    current.substring(0,1).equalsIgnoreCase("O") ||
                    current.substring(0,1).equalsIgnoreCase("U"))
            {
                convertedText = current + "way ";
            }
            // Check for consonant + vowel
            else if (true)
            {

            }
        }
    }

    // Returns true if the passed char is a consonant
    private boolean isConsonant(char testChar)
    {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return consonants.contains(String.valueOf(testChar));
    }

    private boolean isVowel(char testChar)
    {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(testChar));
    }

    // Main method
    public static void main(String[] args) {
        PigLatin frame = new PigLatin();
        frame.setVisible(true);
    }


}
