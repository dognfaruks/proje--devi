import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;


    public class ogrenci_islemleri {

    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<kitap> kitaplarıgetir(){
        ArrayList<kitap> cıktı = new ArrayList<>();
        
        try {
            statement = con.createStatement();
            String sorgu ="Select * from kitaplar";
            ResultSet rs =statement.executeQuery(sorgu);
            while(rs.next()){
                int id = rs.getInt("id");
                String ad = rs.getString("Ad");
                String yazar = rs.getString("Yazar");
                String tür = rs.getString("Tür");
                cıktı.add(new kitap(id,ad,yazar,tür));
            }
            return cıktı;
        } catch (SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }}
        
    public ArrayList<kitap>kitapgoruntule() throws SQLException{
        ArrayList<kitap> cikti = new ArrayList<>();
        try {
        statement = con.createStatement();
        String sorgu = "Select *From  ödünc";
        ResultSet rs = statement.executeQuery(sorgu);
        while(rs.next()){
            int id = rs.getInt("id");
            String ad = rs.getString("Ad");
            String kitapp = rs.getString("Kitap");
            cikti.add(new kitap(id,ad,kitapp));
            }
        return cikti;
        }catch (SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public void iadeet(int id) throws SQLException {
        String sorgu="Delete from ödünc where id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void kitapsil(int id) throws SQLException{
        String sorgu ="Delete from kitaplar where id = ?";
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        
        
    }
    public void ödüncalekle(String ad,String kitap) throws SQLException{
        String sorgu = "Insert Into ödünc(ad,kitap) VALUES(?,?)";
        preparedStatement = con.prepareStatement(sorgu);
        statement = con.createStatement();
        preparedStatement.setString(1, ad);
        preparedStatement.setString(2, kitap);
        preparedStatement.executeUpdate();
        
        
                
    }
               
        public void kullaniciekle(String ad,String parola) throws SQLException{
        String sorgu = "Insert Into kullanıcılar(username,password) VALUES(?,?)";
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setString(1, ad);
        preparedStatement.setString(2, parola);
        preparedStatement.executeUpdate();

    }
    public void kitapekle(String ad,String yazar,String tür) throws SQLException{
        String sorgu = "Insert Into kitaplar(Ad,Yazar,Tür) VALUES(?,?,?)";
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setString(1, ad);
        preparedStatement.setString(2, yazar);
        preparedStatement.setString(3, tür);
        preparedStatement.executeUpdate();

    }
    public boolean girisyap(String kullanici_adi, String parola){
        try {
            String sorgu = "Select * From adminler where username= ? and password = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
     public boolean girisyap2(String kullanici_adi, String parola){
        try {
            String sorgu = "Select * From kullanıcılar where username= ? and password = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    public ogrenci_islemleri() throws SQLException {
        try {
            String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db_ismi;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, database.kullanici_adi, database.parola);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ogrenci_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Veritabanı bağlantısı kurulurken bir hata oluştu.");
        }
        

    }
    public static void main(String[]args) throws SQLException{
    ogrenci_islemleri islemler = new ogrenci_islemleri();
}

    private static class liste {

        public liste(String ad, String yazar) {
        }
    }
}


