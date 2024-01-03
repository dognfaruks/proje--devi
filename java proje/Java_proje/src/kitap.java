
public class kitap {
    private int id;
    private String Ad;
    private String Yazar;
    private String Tür;
    private String kitap;




    public String getKitap() {
        return kitap;
    }

    public void setKitap(String kitap) {
        this.kitap = kitap;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getYazar() {
        return Yazar;
    }

    public void setYazar(String Yazar) {
        this.Yazar = Yazar;
    }

    public String getTür() {
        return Tür;
    }

    public void setTür(String Tür) {
        this.Tür = Tür;
    }

    public kitap(int id, String Ad,String Tür,String Yazar) {
        this.id = id;
        this.Ad = Ad;
        this.Yazar= Yazar;
        this.Tür = Tür;
    }
        public kitap(int id, String Ad, String kitap) {
        this.id= id;
        this.Ad = Ad;
        this.kitap = kitap;
    }

 


}
