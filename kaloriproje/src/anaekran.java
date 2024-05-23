import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class anaekran extends JFrame {
    private JPanel aearkaplan;
    private JButton bilgileriGüncelleButton;
    private JButton kaloriEkleButton;
    private JLabel kyas;
    private JLabel kboy;
    private JLabel kkilo;
    private JLabel kcinsiyet;
    private JLabel khedef;
    private JLabel kjmesaj;
    private JLabel alınmasıgerekenkj;
    private JLabel alınankj;
    private JComboBox hareketkutu;
    private JButton hesaplaButton;
    private JLabel kkullaniciadi;
    private JButton cikisbtn;
    String alinmasigerekenkj_;

    public anaekran(uye kullanici) {
        setVisible(true);
        add(aearkaplan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);//pencereye ekran ortasında açmak için
        bilgileriGüncelleButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        kaloriEkleButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        cikisbtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Şeffaf sınır
        yemekislemleri yemekislemleri = new yemekislemleri();
        yemekislemleri.setVisible(false);

        // Kullanıcı bilgilerini ekrana işleme
        kyas.setText("" + kullanici.getYas());// "+" koyarak integere bir ifadeyi stringe çevirdim
        kboy.setText("" + kullanici.getBoy());
        kkilo.setText("" + kullanici.getKilo());
        if (kullanici.getSex()) {
            kcinsiyet.setText("Erkek");
        } else {
            kcinsiyet.setText("Kadın");
        }
        switch (kullanici.hedef) {
            case 1:
                khedef.setText("Kilo almak");
                kjmesaj.setText("Günlük alabileceğiniz en az kalori mikatarı");
                break;
            case 2:
                khedef.setText("Kilo vermek");
                kjmesaj.setText("Günlük alabileceğiniz en fazla kalori miktarı");
                break;
            case 3:
                khedef.setText("Sabit kiloda kalmak");
                kjmesaj.setText("Günlük almanız gereken kalori miktarı");
                break;
        }
        kkullaniciadi.setText(kullanici.id);

        hesaplaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hareketlvl = hareketkutu.getSelectedIndex();
                alinmasigerekenkj_ = "" + KaloriHesapla.KaloriHesapla(kullanici.getSex(),
                        kullanici.getBoy(),
                        kullanici.getBoy(),
                        kullanici.getKilo(),
                        kullanici.getHedef(),
                        hareketlvl);
                alınmasıgerekenkj.setText(alinmasigerekenkj_);
            }
        });

        bilgileriGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                bilgiguncelle frame = new bilgiguncelle();
                frame.gnclyas.setText("" + kullanici.yas);
                frame.gnclsifre.setText("" + kullanici.sifre);
                frame.gnclkilo.setText("" + kullanici.kilo);
                frame.gnclboy.setText("" + kullanici.boy);
                frame.gnclhedef.setSelectedIndex(kullanici.hedef - 1);
                frame.setVisible(true);

                frame.güncelleButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String yasText = frame.gnclyas.getText();
                        String kiloText = frame.gnclkilo.getText();
                        String boyText = frame.gnclboy.getText();

                        // Boşluk ve sayı kontrolü
                        if (yasText.isEmpty() || kiloText.isEmpty() || boyText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        try {
                            int yas = Integer.parseInt(yasText);
                            int kilo = Integer.parseInt(kiloText);
                            int boy = Integer.parseInt(boyText);

                            frame.dispose();
                            kyas.setText(frame.gnclyas.getText());
                            kkilo.setText(frame.gnclkilo.getText());
                            kboy.setText(frame.gnclboy.getText());
                            switch (frame.gnclhedef.getSelectedIndex()) {
                                case 0:
                                    khedef.setText("Kilo almak");
                                    kjmesaj.setText("Günlük alabileceğiniz en az kalori miktarı");
                                    break;
                                case 1:
                                    khedef.setText("Kilo vermek");
                                    kjmesaj.setText("Günlük alabileceğiniz en fazla kalori miktarı");
                                    break;
                                case 2:
                                    khedef.setText("Sabit kiloda kalmak");
                                    kjmesaj.setText("Günlük almanız gereken kalori miktarı");
                                    break;
                            }
                            veritabani veritabani = new veritabani();
                            try {
                                veritabani.uyeguncelle(kullanici.getId(), frame.gnclsifre.getText(),
                                        yas, kilo, boy, (frame.gnclhedef.getSelectedIndex() + 1));
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                            setVisible(true);

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Lütfen boy, kilo ve yaş alanlarına geçerli sayılar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });

        kaloriEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                yemekislemleri.setVisible(true);
            }
        });

        yemekislemleri.anasayfayaDönButton.addActionListener(new ActionListener() { // eksiksiz geri dönüş için
            @Override
            public void actionPerformed(ActionEvent e) {
                yemekislemleri.setVisible(false);
                alınankj.setText("" + yemekislemleri.gunlukkj);
                setVisible(true);
            }
        });

        cikisbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                girisarayuz cikis = new girisarayuz();
                cikis.setVisible(true);
            }
        });
    }
}
