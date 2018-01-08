package com.xzc.androiddemo.ui.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;
import com.xzc.androiddemo.ui.recyclerview.myinterface.ListItemOnClick;
import com.xzc.androiddemo.view.NoScrollGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-07.
 */

public class MultilLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public final int  ITEM_TYPE_1 = 1;
    public final int  ITEM_TYPE_GRIDVIEW = 2;
    private List<TestEntity> mDatas;
    private Context mContext;
    private ListItemOnClick mListItemOnClick;


    public MultilLayoutAdapter(List<TestEntity> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    public void setmListItemOnClick(ListItemOnClick mListItemOnClick) {
        this.mListItemOnClick = mListItemOnClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_TYPE_1){
            final View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            return new MyListViewHolder_1(view) ;
        }else if (viewType==ITEM_TYPE_GRIDVIEW){
            final View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_2, parent, false);
            return new MyListViewHolder_2(view) ;
        }else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        switch (getItemViewType(position)){
            case ITEM_TYPE_1:
                final MyListViewHolder_1 mholder = (MyListViewHolder_1) holder;
                mholder.iv_img.setImageResource(mDatas.get(position).getImg());
                mholder.textView.setText(mDatas.get(position).getName());
                mholder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListItemOnClick.butOnClick(position);
                    }
                });
                mholder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListItemOnClick.itemOnClick(position);
                    }
                });
            break;
            case ITEM_TYPE_GRIDVIEW:
                final MyListViewHolder_2 mholder_2 = (MyListViewHolder_2) holder;

                List<TestEntity>  mDatas_1 = new ArrayList<>();
                mDatas_1.add(new TestEntity("yi--0--",R.mipmap.test_1));
                mDatas_1.add(new TestEntity("yi--1--",R.mipmap.test_1));
                mDatas_1.add(new TestEntity("yi--3--",R.mipmap.test_1));
                mDatas_1.add(new TestEntity("yi--3--",R.mipmap.test_1));
                mDatas_1.add(new TestEntity("yi--3--",R.mipmap.test_1));
                mDatas_1.add(new TestEntity("yi--3--",R.mipmap.test_1));
                MyListItemGridViewAdapter myListItemGridViewAdapter = new MyListItemGridViewAdapter(mDatas_1,mContext);
                mholder_2.ngv_gridview.setAdapter(myListItemGridViewAdapter);

            break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position%2!=0?ITEM_TYPE_1:ITEM_TYPE_GRIDVIEW;
//        return ITEM_TYPE_1;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class MyListViewHolder_1 extends RecyclerView.ViewHolder{

        private ImageView iv_img;
        private TextView textView;

        public MyListViewHolder_1(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_text_name);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }

    public static class MyListViewHolder_2 extends RecyclerView.ViewHolder{

        private NoScrollGridView ngv_gridview;

        public MyListViewHolder_2(View itemView) {
            super(itemView);
            ngv_gridview = (NoScrollGridView) itemView.findViewById(R.id.ngv_gridview);
        }
    }



}
