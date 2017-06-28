package gr.kouzzzina.kouzzinaApp.retrofit.model;

/**
 * Created by mmam on 28/6/2017.
 */

public class Title {

    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    @Override
    public String toString() {
        return "Title{" +
                "rendered='" + rendered + '\'' +
                '}';
    }
}
