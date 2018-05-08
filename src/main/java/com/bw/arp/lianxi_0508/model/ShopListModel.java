package com.bw.arp.lianxi_0508.model;

import android.content.Context;

import com.bw.arp.lianxi_0508.bean.ShopListBean;
import com.bw.arp.lianxi_0508.presenter.IShopListPresenter;
import com.bw.arp.lianxi_0508.utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/5/4.
 */

public class ShopListModel {
    private Context context;
    public void getShopList(int pscid, final IShopListPresenter iShopListPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getshoplist(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShopListBean shopListBean) {
                        iShopListPresenter.Show(shopListBean);
                    }
                })
        );
    }
}
