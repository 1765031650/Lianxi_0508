package com.bw.arp.lianxi_0508.presenter;


import com.bw.arp.lianxi_0508.bean.LoginBean;

/**
 * Created by ARP on 2018/5/4.
 */

public interface ILoginPresenter {
    void Show(LoginBean loginBean);
    void detachView();
}
