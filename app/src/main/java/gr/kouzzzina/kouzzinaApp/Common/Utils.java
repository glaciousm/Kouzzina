package gr.kouzzzina.kouzzinaApp.Common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Glacious on 18/6/2017.
 */

public class Utils {

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

}
