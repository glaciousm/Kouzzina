package gr.kouzzzina.kouzzinaApp.retrofit;

import java.util.List;

import gr.kouzzzina.kouzzinaApp.retrofit.model.Entity;
import gr.kouzzzina.kouzzinaApp.retrofit.model.ImageEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mmam on 28/6/2017.
 */

public interface APIInterface {

    @GET("/wp-json/wp/v2/posts?search=Γιαουρτλού")
    Call<List<Entity>> doGetListResources();

    @GET("/wp-json/wp/v2/media")
    Call<List<ImageEntity>> doGetListSearch(@Query(("parent")) String id);


    ///users/{user}/repos
    //(@Path("user") String user
}