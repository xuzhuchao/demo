package com.xzc.androiddemo.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.xzc.androiddemo.MainActivity;
import com.xzc.androiddemo.R;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */

public class GuideActivity extends BaseActivity implements GestureDetector.OnGestureListener{


    private ViewPager vp_guide_viewpager;
    private TextView tv_jinru_weizi;
    private int [] imgs = {R.mipmap.guide_1, R.mipmap.guide_2,R.mipmap.guide_3};
    private List<ImageView> imageViewList = new ArrayList<>();

    private GestureDetector gesture; //手势识别
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
    }

    private void initView() {
        vp_guide_viewpager = (ViewPager) findViewById(R.id.vp_guide_viewpager);
        tv_jinru_weizi = (TextView) findViewById(R.id.tv_jinru_weizi);
        tv_jinru_weizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(vp_guide_viewpager.getCurrentItem()==2){

                    Intent intent= new Intent(GuideActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
//                    overridePendingTransition(R.anim.default_anim_in, R.anim.anim_stay);
                }

            }
        });

        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgs[i]);
            imageViewList.add(imageView);
        }

        //为mainactivity设置手势识别
        gesture = new GestureDetector(this, this);
        MyOnTouchListener myOnTouchListener = new MyOnTouchListener() {
            @Override
            public boolean onTouch(MotionEvent ev) {
                boolean result = gesture.onTouchEvent(ev);
                return result;
            }
        };
        registerMyOnTouchListener(myOnTouchListener);


        GoodDetailImagePagerAdapter imagePagerAdapter = new GoodDetailImagePagerAdapter(this, imageViewList);
        vp_guide_viewpager.setAdapter(imagePagerAdapter);
        vp_guide_viewpager.setCurrentItem(0);

        vp_guide_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
               if(arg0==2){
                   tv_jinru_weizi.setVisibility(View.VISIBLE);
               }else {
                   tv_jinru_weizi.setVisibility(View.GONE);
               }
                index =arg0;

                LogUtils.i("arg0====="+arg0);
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {


            }
        });

    }




    /**
     * Title:  GoodDetailImagePagerAdapter<br>
     * Description: TODO  大图适配器<br>
     *
     * @since JDK 1.7
     */
    public class GoodDetailImagePagerAdapter extends PagerAdapter {
        private Context context;
        private List<ImageView> imageViewList;

        public GoodDetailImagePagerAdapter(Context context, List<ImageView> imageViewList) {
            super();
            this.context = context;
            this.imageViewList = imageViewList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            // TODO Auto-generated method stub
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            // TODO Auto-generated method stub
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }
    }



    /****
     * 触摸事件
     *****/
    private ArrayList<MyOnTouchListener> onTouchListeners = new ArrayList<MyOnTouchListener>(10);

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for (MyOnTouchListener listener : onTouchListeners) {
            listener.onTouch(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void registerMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
        onTouchListeners.add(myOnTouchListener);
    }

    public void unregisterMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
        onTouchListeners.remove(myOnTouchListener);
    }

    public interface MyOnTouchListener {
        boolean onTouch(MotionEvent ev);
    }
    /*****触摸事件*****/


    ///**********触摸事件 处理***********//
    @Override
    public boolean onDown(MotionEvent arg0) {
        LogUtils.e("-----被点击了-----");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1 != null && e2 != null) {
            try {
                if ((e1.getX() - e2.getX() > 100) && Math.abs(velocityX) > 200) {
                    LogUtils.e("------左滑了");

//                    if (index==2){
//                        Intent intent= new Intent(GuideActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                        finish();
//                        overridePendingTransition(R.anim.default_anim_in, R.anim.anim_stay);
//                    }

                    return true;
                } else if ((e2.getX() - e1.getX() > 100) && Math.abs(velocityX) > 200) {
                    LogUtils.e("右滑了----------");
                    return true;
                }
            } catch (Exception e) {
                LogUtils.e("--------Exception--------" + e.getMessage().toString());
            }
        } else {
            LogUtils.e("都是空的");
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}
