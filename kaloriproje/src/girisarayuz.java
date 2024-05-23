import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class girisarayuz extends JFrame {


    private JTextField kullanıcıAdıTextField;
    private JButton girişYapButton;
    private JButton üyeOlButton;
    private JPanel panel1;
    private JLabel hatamsj;
    private JPasswordField passwordField1;
    private JCheckBox şifreyiGösterCheckBox;


    public girisarayuz() {

        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);//pencereye ekran ortasında açmak için
        üyeOlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uyeolmaarayuz uyeolma = new uyeolmaarayuz();
                uyeolma.setVisible(true);
                dispose();
            }

        });

        şifreyiGösterCheckBox.addActionListener(new ActionListener() { //şifreyi göster gizle
            @Override
            public void actionPerformed(ActionEvent e) {
                if (şifreyiGösterCheckBox.isSelected()) {
                    passwordField1.setEchoChar((char) 0); // Şifreyi göster
                } else {
                    passwordField1.setEchoChar('•');
                }
            }
        });
        girişYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    veritabani.uyegiris(kullanıcıAdıTextField.getText(), new String(passwordField1.getPassword()));
                    dispose();
                } catch (SQLException ex) {
                    hatamsj.setText("Kullanıcı adı ya da şifre hatalı");
                }
            }
        });
    }

    public void hatamsj() {
        hatamsj.setText("Kullanıcı adı ya da şifre hatalı");


    }
}

