package com.xzc.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.xzc.androiddemo.base.BaseActivity;
import com.xzc.androiddemo.entity.ProvinceNameEntity;
import com.xzc.androiddemo.ui.CalendarActivity;
import com.xzc.androiddemo.ui.dialog_ui.MyDialogActivity;
import com.xzc.androiddemo.ui.recyclerview.MultiLayoutActivity;
import com.xzc.androiddemo.ui.recyclerview.ShowMaxImgActivity;
import com.xzc.androiddemo.ui.recyclerview.WaterfallFlowActivity;
import com.xzc.androiddemo.utils.SharedPreferencesUtil;
import com.xzc.androiddemo.utils.ShowUtil;

import java.util.ArrayList;
import java.util.List;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_enlarge;
    private TextView dateChoice;
    private TextView cityChoice;
    private TextView popoChoice;
    private TextView tv_pubuliu;
    private TextView tv_multil_ui;
    private TextView tv_show_max_img;
    private final String SHOWCASE_ID = "code_weiyi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.ll_back).setVisibility(View.GONE);

        tv_enlarge = (TextView) findViewById(R.id.tv_enlarge);
        dateChoice = (TextView) findViewById(R.id.dateChoice);
        cityChoice = (TextView) findViewById(R.id.cityChoice);
        popoChoice = (TextView) findViewById(R.id.popoChoice);
        tv_pubuliu = (TextView) findViewById(R.id.tv_pubuliu);
        tv_multil_ui = (TextView) findViewById(R.id.tv_multil_ui);
        tv_show_max_img = (TextView) findViewById(R.id.tv_show_max_img);

        tv_enlarge.setOnClickListener(this);
        dateChoice.setOnClickListener(this);
        cityChoice.setOnClickListener(this);
        popoChoice.setOnClickListener(this);
        tv_pubuliu.setOnClickListener(this);
        tv_multil_ui.setOnClickListener(this);
        tv_show_max_img.setOnClickListener(this);
        presentShowcaseView(500);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_enlarge:
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.balloonscale);
                tv_enlarge.startAnimation(animation);
                break;
            case R.id.dateChoice:
                startActivityForResult(new Intent(this, CalendarActivity.class),1);
                break;
            case R.id.cityChoice:
                initCityData();
                pvOptions.show();
                break;
            case R.id.popoChoice:
                startActivity(new Intent(this, MyDialogActivity.class));
                break;
            case R.id.tv_pubuliu:
                startActivity(new Intent(this, WaterfallFlowActivity.class));
                break;
            case R.id.tv_multil_ui:
                startActivity(new Intent(this, MultiLayoutActivity.class));
                break;
            case R.id.tv_show_max_img:
                startActivity(new Intent(this, ShowMaxImgActivity.class));
                break;
        }
    }

    private void presentShowcaseView(int withDelay) {
        MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
        new MaterialShowcaseView.Builder(this)
                .setTarget(tv_enlarge)
//                .setTitleText("Hello")
//                .setDismissText("                       ")
//                .setContentText("This is some amazing feature you should know about")
                .setDelay(withDelay) // optional but starting animations immediately in onCreate can make them choppy
                .singleUse(SHOWCASE_ID) // provide a unique ID used to ensure it is only shown once
                .show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 1:
                    if (data!=null){
                        ShowUtil.showToast(data.getStringExtra("riqi"));
                    }
                    break;

            }
        }
    }

    private ArrayList<ProvinceNameEntity.Province> provinceList;
    private ArrayList<ProvinceNameEntity.City> cityList;


    private ArrayList<String> proName =new ArrayList<>();
    private ArrayList<ArrayList<String>> cityItems = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> dItems = new ArrayList<>();

    private List<ProvinceNameEntity.District> areaList;
    private OptionsPickerView pvOptions;



    private void initCityData(){
        String str = SharedPreferencesUtil.getAllCityJson();
        Gson gson = new Gson();
        ProvinceNameEntity entity = gson.fromJson(str,ProvinceNameEntity.class);
        String result = entity.getResult();
        if(result.equals("1")){
            if(entity.getData()!=null&&entity.getData().size()>0){

                provinceList = (ArrayList<ProvinceNameEntity.Province>) entity.getData();
                for (int i = 0; i < provinceList.size(); i++) {
                    String name = provinceList.get(i).getProvincename();
                    cityList = (ArrayList<ProvinceNameEntity.City>) provinceList.get(i).getList();
                    proName.add(name);
                    ArrayList<String> c = new ArrayList<>();
                    ArrayList< ArrayList<String>> ds = new ArrayList<>();
                    for (int j = 0; j < cityList.size(); j++) {
                        String cName = cityList.get(j).getCityname();
                        ArrayList<String> d = new ArrayList<>();
                        for (int k = 0; k < cityList.get(j).getList().size(); k++) {
                            d.add(cityList.get(j).getList().get(k).getDistrictname());
                        }
                        ds.add(d);
                        c.add(cName);
                    }

                    cityItems.add(c);
                    dItems.add(ds);
                }



                //选项选择器
                pvOptions = new OptionsPickerView(this);

                //二级联动效果
                pvOptions.setPicker(proName, cityItems,dItems, true);
                //设置选择的二级单位
                pvOptions.setLabels("", "","");
//		pvOptions.setTitle("选择地址");
                pvOptions.setCyclic(false, false, false);
                //设置默认选中的二级项目
                //监听确定选择按钮
                pvOptions.setSelectOptions(0, 0, 0);
                pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {

                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3) {
                        //返回的分别是二个级别的选中位置
                        String provinceName = proName.get(options1);
                        String city = cityItems.get(options1).get(options2);
                        String d = dItems.get(options1).get(options2).get(options3);

                        ShowUtil.showToast(provinceName + " " + city+" "+d);


                    }
                });

            }
        }
    }
    long mExitTime = 0L;
    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ShowUtil.showToast("再按一次退出程序");
            mExitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
    }
}
