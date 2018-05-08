package com.bw.arp.lianxi_0508.presenter;


import com.bw.arp.lianxi_0508.bean.RegBean;
import com.bw.arp.lianxi_0508.model.RegModel;
import com.bw.arp.lianxi_0508.view.IRegView;

/**
 * Created by ARP on 2018/5/4.
 */

public class RegPresenter implements IRegPresenter {
    private RegModel regModel;
    private IRegView iRegView;

    public RegPresenter(IRegView iRegView) {
        this.iRegView = iRegView;
        this.regModel = new RegModel();
    }

    public void getRegData(String mobile,String password){
        regModel.getReg(mobile,password,this);
    }

    @Override
    public void Show(RegBean regBean) {
        iRegView.onSuccess(regBean);
    }
    public void detachView(){
        if (iRegView!=null){
            iRegView = null;
        }
    }
}
