package gr.kouzzzina.kouzzinaApp.retrofit.model;

import java.util.List;

/**
 * Created by mmam on 28/6/2017.
 */

public class ImageEntity {

    private String id;
    Guid guid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "id='" + id + '\'' +
                ", guid=" + guid +
                '}';
    }
}
