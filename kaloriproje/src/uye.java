import java.sql.*;

public class uye {
String sifre;
String id;
boolean sex;
int yas;
int kilo;
int boy;
int hedef;
public void yeniuye(String id,String sifre,boolean sex,int yas,int kilo,int boy,int hedef) throws SQLException{
    this.sifre = sifre;
    this.id = id;
    this.sex = sex;
    this.yas = yas;
    this.kilo = kilo;
    this.boy = boy;
    this.hedef = hedef;
    veritabani veritabani=new veritabani(); //veri tabanı işlemi
    veritabani.uyeekle(id,sifre,sex,yas,kilo,boy,hedef);
    }



    public int getHedef() {
        return hedef;
    }

    public void setHedef(int hedef) {
        this.hedef = hedef;
    }

    public String getSifre(){
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSex(boolean sex){ this.sex=sex; }
    public boolean getSex() {
        return sex;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }
}
