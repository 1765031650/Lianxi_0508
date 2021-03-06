package com.bw.arp.lianxi_0508.utils;

import com.bw.arp.lianxi_0508.bean.LoginBean;
import com.bw.arp.lianxi_0508.bean.RegBean;
import com.bw.arp.lianxi_0508.bean.ShopListBean;
import com.bw.arp.lianxi_0508.bean.XQBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ARP on 2018/5/4.
 */

public interface RetrofitService {
    //登录
    @FormUrlEncoded
    @POST(MyUrl.LOGIN)
    Observable<LoginBean> login(@Field("mobile") String mobile,
                                @Field("password") String password
    );
    //注册
    @FormUrlEncoded
    @POST(MyUrl.REGISTER)
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);
    //商品列表
    @GET(MyUrl.SHOPLIST)
    Observable<ShopListBean> shoplist(@Query("pscid") int pscid);
    //详情列表
    @GET(MyUrl.SHOPXQ)
    Observable<XQBean> xqlist(@Query("pid") String pid);

}
