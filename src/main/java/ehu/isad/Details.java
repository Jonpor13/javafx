package ehu.isad;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;

import java.util.Arrays;

public class Details {
    String title;
    String[] publishers;
    Integer number_of_pages;


    @Override
    public String toString() {
        return "Details{" +
                "title='" + title + '\'' +
                ", publishers=" + Arrays.toString(publishers) +
                ", number_of_pages=" + number_of_pages +

                '}';
    }



    public String getTitle() {
        return title;
    }

    public String getPublishers() {
        StringBuffer katea = new StringBuffer();
        for (int x=0;x<this.publishers.length;x++){
            katea =katea.append(this.publishers[x]+" ");
        }
        return katea.toString();
    }

    public Integer getNumber_of_pages() {
        return number_of_pages;
    }
}
