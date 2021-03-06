package bjzhou.coolapk.app.net;

import java.util.List;

import bjzhou.coolapk.app.model.Apk;
import bjzhou.coolapk.app.model.ApkField;
import bjzhou.coolapk.app.model.Comment;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by binjia.zhou on 2016/5/31.
 */

interface CoolapkService {

    @GET("api.php?method=getHomepageApkList&slm=1")
    Observable<List<Apk>> obtainHomepageApkList(@Query("p") int page);

    @GET("api.php?method=getApkField&slm=1&includeMeta=0")
    Observable<ApkField> obtainApkField(@Query("id") int id);

    @GET("api.php?method=getSearchApkList&slm=1")
    Observable<List<Apk>> obtainSearchApkList(@Query(value = "q", encoded = true) String query, @Query("p") int page);

    @GET("api.php?method=getCommentList&slm=1&tclass=apk&subrows=1&sublimit=10")
    Observable<List<Comment>> obtainCommentList(@Query("tid") int tid, @Query("p") int page);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api.php?method=getUpgradeVersions")
    Observable<List<Apk>> obtainUpgradeVersions(@Body String postStr);
}
