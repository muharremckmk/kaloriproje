
public class KaloriHesapla {
public static double KaloriHesapla(boolean sex,int yas,int boy,int kilo,int hedef,int hareket){

    double bmr;
    double kalori = 0;
    if (sex){
        bmr=((10*kilo)+(6.25*boy)-(5*yas)+5);
    }
    else {
        bmr=((10*kilo)+(6.25*boy)-(5*yas)-161);
    }


    switch (hareket){
    case 0:
        kalori=(bmr*1.2);
        break;
    case 1:
        kalori=(bmr*1.375);
        break;
    case 2:
        kalori=(bmr*1.55);
        break;
    case 3:
        kalori=(bmr*1.725);
        break;
    case 4:
        kalori=(bmr*1.9);
        break;
    }
    return kalori;


}}
