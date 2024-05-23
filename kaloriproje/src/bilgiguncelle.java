import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class bilgiguncelle extends JFrame {

    JComboBox gnclhedef;
    JFormattedTextField gnclyas;
    JFormattedTextField gnclkilo;
    JFormattedTextField gnclboy;
    JTextField gnclsifre;
    public JButton güncelleButton;
    JPanel bilg_gpanel;
    JButton grnmzbtn;

    public bilgiguncelle() {
        grnmzbtn.setVisible(false);
        add(bilg_gpanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);//pencereye ekran ortasında açmak için
        güncelleButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        gnclboy.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        gnclhedef.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        gnclkilo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        gnclsifre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        gnclyas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır


    }
}
