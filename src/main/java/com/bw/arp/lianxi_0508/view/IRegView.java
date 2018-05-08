package com.bw.arp.lianxi_0508.view;


import com.bw.arp.lianxi_0508.bean.RegBean;

/**
 * Created by ARP on 2018/5/4.
 */

public interface IRegView {
    void onSuccess(RegBean regBean);
    void onFailed(RegBean regBean);
}
