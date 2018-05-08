package com.bw.arp.lianxi_0508.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bw.arp.lianxi_0508.R;
import com.bw.arp.lianxi_0508.adapter.MyShopAdapter;
import com.bw.arp.lianxi_0508.bean.ShopListBean;
import com.bw.arp.lianxi_0508.presenter.ShopListPresenter;
import com.bw.arp.lianxi_0508.view.IShopListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public class ShoppListActivity extends AppCompatActivity implements IShopListView {

    @BindView(R.id.shop_list_rlv)
    RecyclerView mShopListRlv;
    @BindView(R.id.srlview)
    SwipeRefreshLayout mSrlview;
    private ShopListPresenter shopListPresenter;
    int PAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopp_list);
        ButterKnife.bind(this);
        shopListPresenter = new ShopListPresenter(this);
        shopListPresenter.getShopListData(PAGE);
    }

    @Override
    public void onSuccess(ShopListBean shopListBean) {
        MyShopAdapter adapter = new MyShopAdapter(this, shopListBean.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mShopListRlv.setLayoutManager(linearLayoutManager);
        mShopListRlv.setAdapter(adapter);
        adapter.setSetonItem(new MyShopAdapter.SetonItem() {
            @Override
            public void onItemLinister(int postion, String pid, View view) {
                Toast.makeText(ShoppListActivity.this, pid, Toast.LENGTH_SHORT).show();
            }
        });
        mSrlview.setColorSchemeColors(Color.GRAY);
        mSrlview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrlview.setRefreshing(false);
                PAGE++;
                shopListPresenter.getShopListData(PAGE);
                Toast.makeText(ShoppListActivity.this,"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFailed(ShopListBean shopListBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.unsubscribe();
    }
}
