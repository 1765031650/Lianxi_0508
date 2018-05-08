package com.bw.arp.lianxi_0508.view;


import com.bw.arp.lianxi_0508.bean.ShopListBean;

/**
 * Created by ARP on 2018/5/4.
 */

public interface IShopListView {
    void onSuccess(ShopListBean shopListBean);
    void onFailed(ShopListBean shopListBean);
}
