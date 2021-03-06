package com.bw.arp.lianxi_0508.utils;

import android.content.Context;

import com.bw.arp.lianxi_0508.bean.LoginBean;
import com.bw.arp.lianxi_0508.bean.RegBean;
import com.bw.arp.lianxi_0508.bean.ShopListBean;
import com.bw.arp.lianxi_0508.bean.XQBean;

import rx.Observable;

/**
 * Created by ARP on 2018/5/4.
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    //构造器里获取RetrofitService
    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    //网络请求方法getSearchBooks
    //登录
    public Observable<LoginBean> getlogin(String mobile, String password){
        return mRetrofitService.login(mobile, password);
    }
    //注册
    public Observable<RegBean> getreg(String mobile, String password){
        return mRetrofitService.reg(mobile,password);
    }
    //商品列表
    public Observable<ShopListBean> getshoplist(int pscid){
        return mRetrofitService.shoplist(pscid);
    }
    //详情列表
    public Observable<XQBean> getxqlist(String pid){
        return mRetrofitService.xqlist(pid);
    }

}
