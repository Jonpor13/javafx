package ehu.isad.controller.db;

import ehu.isad.Book;
import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZerbitzuKud {

    private static final ZerbitzuKud instance = new ZerbitzuKud();

    public static ZerbitzuKud getInstance() {
        return instance;
    }

    private ZerbitzuKud() {
    }

    public List<Book> lortuZerbitzuak() {

        String query = "select isbn, izenburu from liburua";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Book> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                String isbn = rs.getString("isbn");
                String izenburu = rs.getString("izenburu");
                Book liburua = new Book (isbn, izenburu);
                System.out.println(isbn + ":" + izenburu);
                emaitza.add(liburua);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public Integer orriKop(String isbn) throws SQLException {

        String query = "select orriKop from liburua where isbn like '"+isbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        Integer orriKopu = null;

        try {

            if (rs.next()){
                orriKopu = rs.getInt("orriKop");

            }

        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return orriKopu;
    }

    public void liburuaGorde(String isbn, String publishers, Integer number_of_pages, Image image){

        this.argitaletxeGorde(isbn, publishers);
        this.orriKopGorde(isbn, number_of_pages);
        //this.argazkiaGorde(isbn, image);

    }

    private void argitaletxeGorde(String isbn, String publishers){

        String query = "update liburua set argitaletxe=\""+publishers+"\" where isbn='"+isbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);

    }

    private void orriKopGorde(String isbn, Integer number_of_pages){

        String query = "update liburua set orriKop="+number_of_pages+" where isbn='"+isbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }

    /*private void argazkiaGorde(String isbn, Image image){


    }*/


}