package com.xzc.androiddemo.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.xzc.androiddemo.R;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-03-08.
 */

public class MyListItemGridViewAdapter extends BaseAdapter{


    private List<TestEntity> mDatas;
    private Context mContext;

    public MyListItemGridViewAdapter(List<TestEntity> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  viewHolder = null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_2_item,null);
            viewHolder = new ViewHolder();

            viewHolder.img = (ImageView) view.findViewById(R.id.iv__gv_img);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.img.setImageResource(mDatas.get(i).getImg());

        return view;
    }

    class ViewHolder{
        ImageView img ;

    }
}
