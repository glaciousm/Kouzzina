package gr.kouzzzina.kouzzinaApp.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mmam on 28/6/2017.
 */

public class Link {

    List<Collection> collection;
    @SerializedName("wp:attachment")
    List<Attachment> attachments;

    public List<Collection> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Link{" +
                "collection=" + collection +
                ", attachments=" + attachments +
                '}';
    }
}
