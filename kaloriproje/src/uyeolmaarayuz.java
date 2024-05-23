import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class uyeolmaarayuz extends JFrame {
    private JPanel uyeolmaerkanı;
    private JTextField uyekadı;
    private JTextField uyesifre;
    private JFormattedTextField uyeboy;
    private JFormattedTextField uyekilo;
    private JFormattedTextField uyeyas;
    private JComboBox uyesex;
    private JComboBox uyehedef;
    private JButton ileriButton;
    private JLabel hatamesajiuye;

    public uyeolmaarayuz() {
        // Üye olma ekranını yapılandır
        add(uyeolmaerkanı);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Pencereye ekran ortasında açmak için

        // Şeffaf sınır
        uyeyas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyekilo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyekadı.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyesex.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyesifre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyehedef.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        uyeboy.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        ileriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sex = false;
                String kullaniciAdi = uyekadı.getText();

                // Kullanıcı adı kontrolü
                try {
                    if (veritabani.kullaniciAdiKontrol(kullaniciAdi)) {
                        hatamesajiuye.setText("Bu kullanıcı adı zaten alınmış. Lütfen başka bir ad deneyin.");
                        return;
                    }
                } catch (SQLException ex) {
                    hatamesajiuye.setText("Kullanıcı adı kontrolünde bir hata oluştu.");
                    return;
                }

                // Boşluk kontrolü
                if (uyekadı.getText().isEmpty() || uyesifre.getText().isEmpty() ||
                        uyeboy.getText().isEmpty() || uyekilo.getText().isEmpty() || uyeyas.getText().isEmpty()) {
                    hatamesajiuye.setText("Lütfen tüm alanları doldurun.");
                    return;
                }

                // Sayı kontrolü
                try {
                    int boy = Integer.parseInt(uyeboy.getText());
                    int kilo = Integer.parseInt(uyekilo.getText());
                    int yas = Integer.parseInt(uyeyas.getText());

                    uye kullanici = new uye();
                    if (uyesex.getSelectedIndex() == 0) {
                        sex = true;
                    }

                    try {
                        kullanici.yeniuye(kullaniciAdi, uyesifre.getText(), sex, yas, kilo, boy, (uyehedef.getSelectedIndex() + 1));
                        anaekran anaekran = new anaekran(kullanici);
                        anaekran.setVisible(true);
                        dispose();
                    } catch (SQLException ex) {
                        hatamesajiuye.setText("Üye kaydında bir hata oluştu.");
                    }
                } catch (NumberFormatException ex) {
                    hatamesajiuye.setText("Lütfen boy, kilo ve yaş alanlarına geçerli sayılar girin.");
                }
            }
        });
    }


}
