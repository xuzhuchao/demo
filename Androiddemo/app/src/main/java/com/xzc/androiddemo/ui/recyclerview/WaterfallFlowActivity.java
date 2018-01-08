package com.xzc.androiddemo.ui.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.ui.recyclerview.adapter.WaterfallFlowAdapter;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;
import com.xzc.androiddemo.ui.recyclerview.myinterface.ListItemOnClick;
import com.xzc.androiddemo.ui.recyclerview.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-15.
 * 瀑布流 界面
 */

public class WaterfallFlowActivity extends BaseActivity implements ListItemOnClick, SwipeRefreshLayout.OnRefreshListener{


    private RecyclerView rv_list;
    private SwipeRefreshLayout id_swipe_ly;
    private LinearLayout ll_back;
    private TextView tv_head_title;

    private WaterfallFlowAdapter mAdapter;
    private List<TestEntity> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall_flow);


        initView();
    }

    private void initView() {
        id_swipe_ly = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        tv_head_title = (TextView) findViewById(R.id.tv_head_title);
        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_head_title.setText("瀑布流效果");

//        rv_list.setLayoutManager(new LinearLayoutManager(this));//listview 样式
        rv_list.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));//瀑布流 样式
//        rv_list.setLayoutManager(new GridLayoutManager(this,2));//gridview 样式
//        list.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rv_list.addItemDecoration(new SpacesItemDecoration(20));


        id_swipe_ly.setOnRefreshListener(this);
        id_swipe_ly.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);

        mDatas = new ArrayList<>();

        mDatas.add(new TestEntity("yi--0--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--1--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--一--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--二--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--2--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--3--",R.mipmap.test_3));
        mDatas.add(new TestEntity("yi--4--",R.mipmap.test_3));
        mDatas.add(new TestEntity("yi--5--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--6--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--7--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--8--",R.mipmap.test_3));
        mDatas.add(new TestEntity("yi--9--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--10--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--11--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--12--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--13--",R.mipmap.test_3));
        mDatas.add(new TestEntity("yi--14--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--15--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--16--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--17--",R.mipmap.test_2));
        mDatas.add(new TestEntity("yi--18--",R.mipmap.test_3));
        mDatas.add(new TestEntity("yi--19--",R.mipmap.test_1));
        mDatas.add(new TestEntity("yi--20--",R.mipmap.test_2));
        mAdapter = new WaterfallFlowAdapter(mDatas,this);
        mAdapter.setmListItemOnClick(this);

        rv_list.setAdapter(mAdapter);

    }

    @Override
    public void onRefresh() {
        //刷新操作

        id_swipe_ly.setRefreshing(false);//关闭刷新动画
    }

    @Override
    public void itemOnClick(int position) {
        //瀑布流 item点击事件
    }

    @Override
    public void butOnClick(int position) {
        // item 中按钮点击事件
    }
}
