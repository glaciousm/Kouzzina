package gr.kouzzzina.kouzzinaApp.retrofit.model;

/**
 * Created by mmam on 28/6/2017.
 */

public class Attachment {

    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "href='" + href + '\'' +
                '}';
    }
}
