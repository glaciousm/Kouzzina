package gr.kouzzzina.kouzzinaApp.Model;

import java.util.List;

import gr.kouzzzina.kouzzinaApp.Common.Utils;

/**
 * Created by Glacious on 18/6/2017.
 */

public class RSSObject
{
    public String status;
    public Feed feed;
    public List<Item> items;

    public RSSObject(String status, Feed feed, List<Item> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Item> getItems() {
        for (int i = 0; i< items.size(); i++){
            items.get(i).description = Utils.html2text(items.get(i).description);
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}