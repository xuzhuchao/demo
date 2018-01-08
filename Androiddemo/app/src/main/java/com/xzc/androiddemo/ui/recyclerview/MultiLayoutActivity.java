package com.xzc.androiddemo.ui.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.ui.recyclerview.adapter.MultilLayoutAdapter;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;
import com.xzc.androiddemo.ui.recyclerview.myinterface.ListItemOnClick;
import com.xzc.androiddemo.ui.recyclerview.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-16.
 */

public class MultiLayoutActivity extends BaseActivity implements ListItemOnClick, SwipeRefreshLayout.OnRefreshListener{


    private RecyclerView rv_multil_layout;
    private SwipeRefreshLayout id_swipe_ly;
    private LinearLayout ll_back;
    private TextView tv_head_title;

    private MultilLayoutAdapter mAdapter;
    private List<TestEntity> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multil_layout);

        initView();
    }

    private void initView() {
        id_swipe_ly = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);
        rv_multil_layout = (RecyclerView) findViewById(R.id.rv_multil_layout);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        tv_head_title = (TextView) findViewById(R.id.tv_head_title);
        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_head_title.setText("多重布局");

        rv_multil_layout.setLayoutManager(new LinearLayoutManager(this));//listview 样式
//        rv_multil_layout.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));//瀑布流 样式
//        rv_list.setLayoutManager(new GridLayoutManager(this,2));//gridview 样式
//        list.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rv_multil_layout.addItemDecoration(new SpacesItemDecoration(20));


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
        mAdapter = new MultilLayoutAdapter(mDatas,this);
        mAdapter.setmListItemOnClick(this);

        rv_multil_layout.setAdapter(mAdapter);



        rv_multil_layout.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("LOG","------->isSlideToBottom:" + isSlideToBottom(recyclerView));
                if (isSlideToBottom(recyclerView)) {
//                    srlLayout.setEnabled(true);

                    mDatas.add(mDatas.size()-1,new TestEntity("yi--加载的--",R.mipmap.test_2));
                    mAdapter.notifyDataSetChanged();
                }
            }
        });

    }


    //判断RecyclerView是否滑动到最底部了
    protected boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    @Override
    public void onRefresh() {
        //刷新操作

        mDatas.add(0,new TestEntity("yi--刷新的--",R.mipmap.test_2));
        mDatas.add(1,new TestEntity("yi--刷新的--",R.mipmap.test_3));
        mAdapter.notifyDataSetChanged();

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
