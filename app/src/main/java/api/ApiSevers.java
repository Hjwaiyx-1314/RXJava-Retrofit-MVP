package api;

import bean.ShopperDetail;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hjw on 2018/8/8 0008.
 * 邮箱：786567342@qq.com
 * 电话：13221002723
 */

public interface ApiSevers {

    //获取店铺信息
    @FormUrlEncoded
    @POST("ajax/shopperDetail.htm")
    Observable<ShopperDetail> getshopInfo(@Field("shopperId") String shopperId,
                                          @Field("machineId") String machineId);

    @FormUrlEncoded
    @POST("nurseDoor/send/code.action")
    Observable<String> getPthone(@Field("phone") String shopperId);


    @FormUrlEncoded
    @POST("nurseDoor/verify/code.action")
    Observable<String> tryPhone(@Field("phone") String shopperId,
                                 @Field("code") String code);
}
