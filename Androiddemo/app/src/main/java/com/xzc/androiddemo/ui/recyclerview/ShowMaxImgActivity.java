package com.xzc.androiddemo.ui.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.ui.recyclerview.adapter.ShowMaxImgAdapter;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;
import com.xzc.androiddemo.ui.recyclerview.myinterface.ListItemOnClick;
import com.xzc.androiddemo.ui.recyclerview.utils.SpacesItemDecoration;
import com.xzc.androiddemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-16.
 */

public class ShowMaxImgActivity extends BaseActivity implements ListItemOnClick{

    private RecyclerView rv_gridview;
    private LinearLayout ll_back;
    private TextView tv_head_title;
    private TextView tv_;

    private ShowMaxImgAdapter mAdapter;
    private List<TestEntity> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_max_img);
        initView();
    }
    private void initView(){

        rv_gridview = (RecyclerView) findViewById(R.id.rv_gridview);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        tv_head_title = (TextView) findViewById(R.id.tv_head_title);
        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_head_title.setText("查看大图");

    //        rv_list.setLayoutManager(new LinearLayoutManager(this));//listview 样式
//        rv_gridview.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));//瀑布流 样式
        rv_gridview.setLayoutManager(new GridLayoutManager(this,3));//gridview 样式
    //        list.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rv_gridview.addItemDecoration(new SpacesItemDecoration(20));



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
        mAdapter = new ShowMaxImgAdapter(mDatas,this,rv_gridview);
        mAdapter.setmListItemOnClick(this);

        rv_gridview.setAdapter(mAdapter);

    }



    @Override
    public void itemOnClick(int position) {
        //瀑布流 item点击事件
        LogUtils.i("我 要 开始 崩溃了");
        tv_.setText("111111");
    }

    @Override
    public void butOnClick(int position) {
        // item 中按钮点击事件
    }
}
