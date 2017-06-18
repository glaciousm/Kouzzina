package gr.kouzzzina.kouzzinaApp.Common;

import org.jsoup.Jsoup;

/**
 * Created by Glacious on 18/6/2017.
 */

public class Utils {

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

}
