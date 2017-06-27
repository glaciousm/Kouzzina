package gr.kouzzzina.kouzzinaApp.Model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gr.kouzzzina.kouzzinaApp.Common.Utils;

/**
 * Created by Glacious on 18/6/2017.
 */

public class Item
{
    public String title;
    public String pubDate;
    public String link;
    public String guid;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public String summary;
    public Object enclosure;
    public List<String> categories;

    public Item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, String summary, Object enclosure, List<String> categories) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.enclosure = enclosure;
        this.summary = summary;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return Utils.html2text(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {

        String regex = "http?:/(?:/[^/]+)+\\.(?:jpg|gif|png)";;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        String urlStr ="test";

        while(m.find()) {
            urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")"))
            {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }}

        return urlStr;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Object getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Object enclosure) {
        this.enclosure = enclosure;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", link='" + link + '\'' +
                ", guid='" + guid + '\'' +
                ", author='" + author + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", enclosure=" + enclosure +
                ", categories=" + categories +
                '}';
    }
}