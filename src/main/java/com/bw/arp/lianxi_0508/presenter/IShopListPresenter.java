package com.bw.arp.lianxi_0508.presenter;


import com.bw.arp.lianxi_0508.bean.ShopListBean;

/**
 * Created by ARP on 2018/5/4.
 */

public interface IShopListPresenter {
    void Show(ShopListBean shopListBean);
    void detachView();
}
