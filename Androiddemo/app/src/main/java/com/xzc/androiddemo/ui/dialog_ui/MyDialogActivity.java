package com.xzc.androiddemo.ui.dialog_ui;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.view.ActionSheetDialog;

/**
 * Created by Administrator on 2017-03-10.
 * 选择拍照相册选择
 * 和部分popu
 */

public class MyDialogActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        findViewById(R.id.ll_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       TextView tv_title =  (TextView)findViewById(R.id.tv_head_title);
        tv_title.setText("窗口效果");
    }


    public void popo_xiaoguo(View view){
        initpopu();
        promptBox_tv_content.setText("设置提示内容区域");
        promptBoxPopupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);


    }
    public void chouti_xiaoguo(View view){
        Head_portrait();
    }



    /**
     * Title:  Head_portrait<br>
     * Description: 显示选择头像dialog Action<br>
     * @author xuzhuchao
     * @since JDK 1.7
     */
    public void Head_portrait(){
        new ActionSheetDialog(this)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Grey,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        }).addSheetItem("从相册选择", ActionSheetDialog.SheetItemColor.Grey, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {

            }
        }).show();

    }

    private View prompt_box;
    private PopupWindow promptBoxPopupWindow;
    private TextView promptBox_tv_content, promptBox_tv_submit, promptBox_tv_cancel;



    /**退出登录提示框*/
    private void initpopu() {
        // 空白区域
        prompt_box = getLayoutInflater().inflate(R.layout.popu_out_prompt_box, null);
        // 提示文字
        promptBox_tv_content = (TextView) prompt_box.findViewById(R.id.promptBox_tv_content);
        // 确定按钮
        promptBox_tv_submit = (TextView) prompt_box.findViewById(R.id.promptBox_tv_submit);
        // 取消按钮
        promptBox_tv_cancel = (TextView) prompt_box.findViewById(R.id.promptBox_tv_cancel);

        prompt_box.setOnClickListener(new View.OnClickListener() {
            // 空白区域
            @Override
            public void onClick(View v) {
                promptBoxPopupWindow.dismiss();
            }
        });
        promptBox_tv_submit.setTextColor(getResources().getColor(R.color.but_text_color));
        promptBox_tv_submit.setOnClickListener(new View.OnClickListener() {
            // 确定按钮
            @Override
            public void onClick(View v) {

//                logout();
                promptBoxPopupWindow.dismiss();
            }

        });
        promptBox_tv_cancel.setTextColor(getResources().getColor(R.color.text_blue));
        promptBox_tv_cancel.setOnClickListener(new View.OnClickListener() {
            // 取消按钮
            @Override
            public void onClick(View v) {
                promptBoxPopupWindow.dismiss();
            }
        });

        promptBoxPopupWindow = new PopupWindow(prompt_box, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, true);
        promptBoxPopupWindow.setFocusable(true);
        // 设置弹出动画
        promptBoxPopupWindow.setAnimationStyle(R.style.ActionSheetDialogStyle);
        // 设置popupWindow背景图片(只能通过popupWindow提供的返回键返回)
        ColorDrawable dw = new ColorDrawable(0x32000000);
        promptBoxPopupWindow.setBackgroundDrawable(dw);
        promptBoxPopupWindow.setOutsideTouchable(true);
    }
}
