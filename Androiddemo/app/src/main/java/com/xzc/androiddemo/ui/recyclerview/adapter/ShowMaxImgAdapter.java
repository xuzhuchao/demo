package com.xzc.androiddemo.ui.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.xzc.androiddemo.R;
import com.xzc.androiddemo.ui.recyclerview.ShowMaxImgActivity;
import com.xzc.androiddemo.ui.recyclerview.entity.TestEntity;
import com.xzc.androiddemo.ui.recyclerview.myinterface.ListItemOnClick;
import com.xzc.androiddemo.utils.SharedPreferencesUtil;
import com.xzc.androiddemo.view.NoScrollGridView;

import java.util.ArrayList;
import java.util.List;

//import uk.co.senab.photoview.PhotoView;
//import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2017-03-07.
 */

public class ShowMaxImgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public final int  ITEM_TYPE_1 = 1;
    public final int  ITEM_TYPE_GRIDVIEW = 2;
    private List<TestEntity> mDatas;
    private Context mContext;
    private ShowMaxImgActivity mActivity;
    private ListItemOnClick mListItemOnClick;
    private RecyclerView mRecyclerView ;


    private int www;//屏幕的宽度
    private int hhh;//屏幕的高度
    private int view_h;//图片的高度


    public ShowMaxImgAdapter(List<TestEntity> mDatas, Context mContext,RecyclerView recyclerView) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mActivity = (ShowMaxImgActivity) mContext;
        this.mRecyclerView = recyclerView;

        www = SharedPreferencesUtil.getScreenWidth();
        hhh = SharedPreferencesUtil.getScreenWidth();
    }

    public void setmListItemOnClick(ListItemOnClick mListItemOnClick) {
        this.mListItemOnClick = mListItemOnClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_TYPE_1){
            final View view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
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

                view_h = mholder.iv_img.getLayoutParams().height;

                mholder.iv_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListItemOnClick.butOnClick(position);
//                        zoomImageFromThumb(view,position);
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
//        return position%2!=0?ITEM_TYPE_1:ITEM_TYPE_GRIDVIEW;
        return ITEM_TYPE_1;
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
//
//
//    float startScale;
//    ViewPager viewPager;
//    Rect startBounds;
//    float startScaleFinal;
//    private RelativeLayout rl_img_ui;
//    private LinearLayout ll_yuandian;
//    private List<RoundImageView> yuandianList;
//
//    private Animator mCurrentAnimator;
//    private int mShortAnimationDuration = 500;
//    private PhotoView photoView;
//
//    private void zoomImageFromThumb(View thumbView, int position) {
//        // If there's an animation in progress, cancel it immediately and
//        // proceed with this one.
//        if (mCurrentAnimator != null) {
//            mCurrentAnimator.cancel();
//        }
//
//        viewPager = (ViewPager)mActivity.findViewById(R.id.vp_img_viewpager);
//        rl_img_ui = (RelativeLayout)mActivity.findViewById(R.id.rl_img_ui);
//        ll_yuandian = (LinearLayout) mActivity.findViewById(R.id.ll_yuandian);
//
//        viewPager.setAdapter(new SamplePagerAdapter(mDatas, mContext));
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if(yuandianList !=null&&yuandianList.size()>0){
//                    for (int i = 0; i <yuandianList.size() ; i++) {
//                        if(i==position){
//                            yuandianList.get(i).setImageResource(R.mipmap.xiaoyuandian_x);
//                        }else {
//                            yuandianList.get(i).setImageResource(R.mipmap.xiaoyuandian_w);
//                        }
//                    }
//                }
//
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        viewPager.setCurrentItem(position);
//        yuandianList = new ArrayList<>();
//        for (int i = 0; i <mDatas.size() ; i++) {
//            RoundImageView imgview= new RoundImageView(mContext);
//            imgview.setType(RoundImageView.TYPE_CIRCLE);
//            LinearLayout.LayoutParams lp =new LinearLayout.LayoutParams(15,15);
//            lp.setMargins(5,0,5,0);
//            imgview.setLayoutParams(lp);
//
//            if(i==position){
//                imgview.setImageResource(R.mipmap.xiaoyuandian_x);
//            }else {
//                imgview.setImageResource(R.mipmap.xiaoyuandian_w);
//            }
//            ll_yuandian.addView(imgview);
//            yuandianList.add(imgview);
//        }
//
//
//
//        // Calculate the starting and ending bounds for the zoomed-in image.
//        // This step
//        // involves lots of math. Yay, math.
//        startBounds = new Rect();
//        final Rect finalBounds = new Rect();
//        final Point globalOffset = new Point();
//
//        // The start bounds are the global visible rectangle of the thumbnail,
//        // and the
//        // final bounds are the global visible rectangle of the container view.
//        // Also
//        // set the container view's offset as the origin for the bounds, since
//        // that's
//        // the origin for the positioning animation properties (X, Y).
//        thumbView.getGlobalVisibleRect(startBounds);
//
//        mActivity.findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset);
//        startBounds.offset(-globalOffset.x, -globalOffset.y);
//        finalBounds.offset(-globalOffset.x, -globalOffset.y);
//
//
//        // Adjust the start bounds to be the same aspect ratio as the final
//        // bounds using the
//        // "center crop" technique. This prevents undesirable stretching during
//        // the animation.
//        // Also calculate the start scaling factor (the end scaling factor is
//        // always 1.0).
//
//        if ((float) finalBounds.width() / finalBounds.height() > (float) startBounds
//                .width() / startBounds.height()) {
//            // Extend start bounds horizontally
//            startScale = (float) startBounds.height() / finalBounds.height();
//            float startWidth = startScale * finalBounds.width();
//            float deltaWidth = (startWidth - startBounds.width()) / 2;
//            startBounds.left -= deltaWidth;
//            startBounds.right += deltaWidth;
//        } else {
//            // Extend start bounds vertically
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startHeight = startScale * finalBounds.height();
//            float deltaHeight = (startHeight - startBounds.height()) /2;
//            startBounds.top -= deltaHeight;
//            startBounds.bottom += deltaHeight;
//        }
//
//        //  show the zoomed-in view. When the animation
//        // begins,
//        // it will position the zoomed-in view in the place of the thumbnail.
//        rl_img_ui.setVisibility(View.VISIBLE);
//        // Set the pivot point for SCALE_X and SCALE_Y transformations to the
//        // top-left corner of
//        // the zoomed-in view (the default is the center of the view).
//
//
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.setDuration(1);
//        animSet.play(ObjectAnimator.ofFloat(rl_img_ui, "pivotX", 0f))
//                .with(ObjectAnimator.ofFloat(rl_img_ui, "pivotY", 0f))
//                .with(ObjectAnimator.ofFloat(rl_img_ui, "alpha", 1.0f));
//        animSet.start();
//
//
//        // Construct and run the parallel animation of the four translation and
//        // scale properties
//        // (X, Y, SCALE_X, and SCALE_Y).
//        AnimatorSet set = new AnimatorSet();
//        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mRecyclerView, "alpha", 1.0f, 0.f);
//        ObjectAnimator animatorX = ObjectAnimator.ofFloat(rl_img_ui, "x", startBounds.left, finalBounds.left);
//        ObjectAnimator animatorY = ObjectAnimator.ofFloat(rl_img_ui, "y", startBounds.top, finalBounds.top);
//        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(rl_img_ui, "scaleX", startScale, 1f);
//        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(rl_img_ui, "scaleY", startScale, 1f);
//
//        set.play(alphaAnimator).with(animatorX).with(animatorY).with(animatorScaleX).with(animatorScaleY);
//        set.setDuration(mShortAnimationDuration);
//        set.setInterpolator(new DecelerateInterpolator());
//        set.addListener(new AnimatorListenerAdapter() {
//
//            public void onAnimationEnd(Animator animation) {
//                mCurrentAnimator = null;
//            }
//
//            public void onAnimationCancel(Animator animation) {
//                mCurrentAnimator = null;
//            }
//        });
//        set.start();
//        mCurrentAnimator = set;
//
//        // Upon clicking the zoomed-in image, it should zoom back down to the
//        // original bounds
//        // and show the thumbnail instead of the expanded image.
//        startScaleFinal = startScale;
//
//    }
//
//
//    public boolean getScaleFinalBounds(int position) {
//
//        View childView = mRecyclerView.getChildAt(position);
//
//        startBounds = new Rect();
//        final Rect finalBounds = new Rect();
//        final Point globalOffset = new Point();
//
//        try {
//            childView.getGlobalVisibleRect(startBounds);
//        } catch (Exception e) {
//            return false;
//        }
//        View view = mActivity.findViewById(R.id.container);
//
//        view.getGlobalVisibleRect(finalBounds, globalOffset);
//        startBounds.offset(-globalOffset.x, -globalOffset.y);
//        finalBounds.offset(-globalOffset.x, -globalOffset.y);
//
//        LogUtils.e("----"+startBounds.left);
//        LogUtils.e("----"+startBounds.top);
//        LogUtils.e("----"+startBounds.right);
//        LogUtils.e("----"+startBounds.bottom);
//
//
//        if ((float) finalBounds.width() / finalBounds.height() > (float) startBounds
//                .width() / startBounds.height()) {
//            // Extend start bounds horizontally
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startWidth = startScale * finalBounds.width();
//            float deltaWidth = (startWidth - startBounds.width()) / 2;
//            startBounds.left -= deltaWidth;
//            startBounds.right += deltaWidth;
//        } else {
//            // Extend start bounds vertically
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startHeight = startScale * finalBounds.height();
//            float deltaHeight;
//            if(startScale>0.4){
////				 deltaHeight = (startHeight - startBounds.height()) /2;
//                deltaHeight = view_h/hhh*startBounds.height();
//                startBounds.top -= deltaHeight;
//
//            }else {
////				deltaHeight = (startHeight - startBounds.height()) /2;
//                deltaHeight = view_h/hhh*startBounds.height();
//                startBounds.top -= deltaHeight;
//            }
//
//            startBounds.bottom += deltaHeight;
//        }
//        if(startScale>0.4){
//
//            startScaleFinal = (float) view_h/hhh;
//        }else {
//
//            startScaleFinal = (float) view_h/hhh;
//        }
//
//        LogUtils.e("photoView.h="+photoView.getDrawable().getIntrinsicHeight());
//        LogUtils.e("startScaleFinal="+startScaleFinal);
//        LogUtils.e("startScale="+startScale);
//        LogUtils.e("f.w/h="+(float)finalBounds.width() / finalBounds.height());
//        LogUtils.e("s.w/w="+(float) startBounds.width() / startBounds.height());
//        return true;
//    }
//
//    class SamplePagerAdapter extends PagerAdapter {
//
//        private List<TestEntity> sDrawables;
//        private Context mContext;
//
//        public SamplePagerAdapter(List<TestEntity> imgIds, Context context) {
//            this.sDrawables = imgIds;
//            this.mContext = context;
//        }
//        @Override
//        public int getCount() {
//            return sDrawables.size();
//        }
//
//        @Override
//        public View instantiateItem(ViewGroup container, final int position) {
//            photoView = new PhotoView(container.getContext());
////			photoView.setImageResource(sDrawables[position]);
//
//
//            ViewGroup childView = (ViewGroup) mRecyclerView.getChildAt(position);
//            ImageView imgview = null;
//            ImageView imgview_2 = null;
//            if(childView.getChildAt(0)!=null){
//                imgview = (ImageView) childView.getChildAt(0);
//            }
//            if(childView.getChildAt(1)!=null){
//                imgview_2 = (ImageView) childView.getChildAt(1);
//            }
//            setImgData_2(sDrawables.get(position).getImg(),imgview.getDrawable(),photoView);
//
//
////			setImgData_2(sDrawables.get(position).getUrl(),photoView);
//
//
//            // Now just add PhotoView to ViewPager and return it
//            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT);
//            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
//                public void onPhotoTap(View paramAnonymousView,
//                                       float paramAnonymousFloat1,
//                                       float paramAnonymousFloat2) {
//                    if (mCurrentAnimator != null) {
//                        mCurrentAnimator.cancel();
//                    }
//
////							photoView.clearZoom();
//
//                    boolean scaleResult = getScaleFinalBounds(position);
//                    // Animate the four positioning/sizing properties in parallel,
//                    // back to their
//                    // original values.
//                    AnimatorSet as = new AnimatorSet();
//                    ObjectAnimator containAlphaAnimator = ObjectAnimator.ofFloat(mRecyclerView, "alpha", 0.f, 1.0f);
//                    if (scaleResult) {
//                        LogUtils.e("startBounds.left==="+startBounds.left);
//                        LogUtils.e("startBounds.top==="+startBounds.top);
////								ViewGroup.LayoutParams lp =	viewPager.getLayoutParams();
////								lp.width =hhh;
////								lp.height =hhh;
////								viewPager.setLayoutParams(lp);
////								LogUtils.e("lp.width ="+lp.width);
////								LogUtils.e("lp.getLayoutParams ="+viewPager.getLayoutParams().height);
////								LogUtils.e("lp.getLayoutParams ="+viewPager.getLayoutParams().width);
//
//                        ObjectAnimator animatorX = ObjectAnimator.ofFloat(rl_img_ui, "x", startBounds.left);
//                        ObjectAnimator animatorY = ObjectAnimator.ofFloat(rl_img_ui, "y",  startBounds.top);
//                        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(rl_img_ui, "scaleX",startScaleFinal);
//                        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(rl_img_ui, "scaleY", startScaleFinal);
//
//                        as.play(containAlphaAnimator).with(animatorX).with(animatorY).with(animatorScaleX).with(animatorScaleY);
//                    }else {
//                        //the selected photoview is beyond the mobile screen display
//                        //so it just fade out
//                        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(rl_img_ui, "alpha", 0.1f);
//                        as.play(alphaAnimator).with(containAlphaAnimator);
//                    }
//                    as.setDuration(mShortAnimationDuration);
//                    as.setInterpolator(new DecelerateInterpolator());
//                    as.addListener(new AnimatorListenerAdapter() {
//
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            rl_img_ui.clearAnimation();
//                            rl_img_ui.setVisibility(View.GONE);
//                            ll_yuandian.removeAllViews();
//                            mCurrentAnimator = null;
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animation) {
//                            rl_img_ui.clearAnimation();
//                            rl_img_ui.setVisibility(View.GONE);
//                            ll_yuandian.removeAllViews();
//                            mCurrentAnimator = null;
//                        }
//                    });
//                    as.start();
//                    mCurrentAnimator = as;
//
//                }
//            });
//
//            return photoView;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//    }
//
//    public void setImgData_2(int url, Drawable rId, ImageView iv){
//        Glide.with(mContext)
//                .load(url)
////                .placeholder(rId)
//                .into(iv);
//    }
}
