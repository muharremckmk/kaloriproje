import java.util.*;
import java.sql.*;

public class veritabani {
    static String userName = "root";
    static String password = "1234";
    static String dbUrl = "jdbc:mysql://localhost:3306/uyeler";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void error(SQLException exception) {
        System.out.println("Hata: " + exception.getErrorCode());
    }


    public void uyeekle(String id, String sifre, boolean sex, int yas, int kilo, int boy, int hedef) throws SQLException {
        String sql_sorgu = "insert into uyeler (id,sifre,sex,yas,kilo,boy,hedef) values(?,?,?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql_sorgu);
        statement.setString(1, id);
        statement.setString(2, sifre);
        statement.setBoolean(3, sex);
        statement.setInt(4, yas);
        statement.setInt(5, kilo);
        statement.setInt(6, boy);
        statement.setInt(7, hedef);

        statement.executeUpdate();
        statement.close();
    }

    public void uyeguncelle(String id, String sifre, int yas, int kilo, int boy, int hedef)
            throws SQLException {
        String sql_sorgu = "update uyeler set sifre=?,kilo=?,boy=?,yas=?,hedef=? where id=? ";
        PreparedStatement statement = getConnection().prepareStatement(sql_sorgu);

        statement.setString(1, sifre);

        statement.setInt(4, yas);
        statement.setInt(2, kilo);
        statement.setInt(3, boy);
        statement.setInt(5, hedef);
        statement.setString(6, id);
        statement.executeUpdate();
        statement.close();
    }

    public static void uyegiris(String id, String sifre) throws SQLException {
        String sqlsorugu = "SELECT id,sifre,sex,yas,kilo,boy,hedef FROM uyeler WHERE id =? and sifre=?";
        PreparedStatement statement = getConnection().prepareStatement(sqlsorugu);
        statement.setString(1, id);
        statement.setString(2, sifre);
        ResultSet resultSet = statement.executeQuery();//sonuçları çekme
        if (resultSet.next()) {
            boolean sex = resultSet.getBoolean("cinsiyet");
            int hedef = resultSet.getInt("hedef");
            int boy = resultSet.getInt("boy");
            int kilo = resultSet.getInt("kilo");
            int yas = resultSet.getInt("yas");

            // Uye sınıfına atama
            uye kullanici = new uye();
            kullanici.setId(id);
            kullanici.setSifre(sifre);
            kullanici.setBoy(boy);
            kullanici.setKilo(kilo);
            kullanici.setYas(yas);
            kullanici.setSex(sex);
            kullanici.setHedef(hedef);
            anaekran anaekran = new anaekran(kullanici);
            anaekran.setVisible(true);
        } else {
            girisarayuz uyariligiris = new girisarayuz();
            uyariligiris.setVisible(true);
            uyariligiris.hatamsj();

        }


    }

    public int yemekalori(String yemekAdi) {
        int kalori = -1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT yemekkj FROM Yemekler WHERE yemekadı = ?");
            stmt.setString(1, yemekAdi);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                kalori = rs.getInt("yemekkj");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kalori;
    }

    public boolean vbyemekekle(String yemekAdi, int kalori) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO yemekler (yemekadı, yemekkj) VALUES (?, ?)");
            stmt.setString(1, yemekAdi);
            stmt.setInt(2, kalori);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    public static boolean kullaniciAdiKontrol(String kullaniciadi) throws SQLException {
        String sql = "SELECT * FROM uyeler WHERE id = ?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, kullaniciadi);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    }
}


