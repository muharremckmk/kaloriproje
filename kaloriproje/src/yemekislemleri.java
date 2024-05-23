import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class yemekislemleri extends JFrame {
    private JTextField yemekad;
    private JFormattedTextField yemekkj;
    private JButton yemekekle;
    private JButton kjekle;
    private JTextArea textArea1;
    private JTextField yemekeklead;
    private JFormattedTextField yemeeklekj;
    private JButton ekleButton;
    public JButton anasayfayaDönButton;
    private JLabel yemekadihata;
    private JPanel panel;
    private JLabel topkj;
    public int gunlukkj = 0;


    public yemekislemleri() {
        veritabani veritabani=new veritabani();

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Pencereyi ekran ortasında açmak için

        kjekle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemeeklekj.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemekeklead.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        anasayfayaDönButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        ekleButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        textArea1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemekekle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemekkj.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemekad.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır



        yemekekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yemekAdi = yemekad.getText();
                int kalori = veritabani.yemekalori(yemekAdi);
                if (kalori != -1) {
                    gunlukkj += kalori;
                    topkj.setText(""+gunlukkj);
                    textArea1.append(yemekAdi + " - " + kalori + " kj\n");
                } else {
                    yemekadihata.setText("Yemek veritabanında bulunamadı.");
                }
            }
        });

        kjekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kalori = Integer.parseInt(yemekkj.getText());
                gunlukkj += kalori;
                topkj.setText(""+gunlukkj);
                textArea1.append("Ekstra kalori: " + kalori + " kj\n");
            }
        });

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yemekAdi = yemekeklead.getText();
                int kalori = Integer.parseInt(yemeeklekj.getText());
                if (veritabani.vbyemekekle(yemekAdi, kalori)) {
                    JOptionPane.showMessageDialog(null, "Yemek başarıyla eklendi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Yemek eklenirken hata oluştu.");
                }
            }
        });






}}
