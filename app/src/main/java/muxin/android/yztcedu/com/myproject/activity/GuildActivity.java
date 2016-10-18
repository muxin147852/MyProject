package muxin.android.yztcedu.com.myproject.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import muxin.android.yztcedu.com.myproject.R;
import muxin.android.yztcedu.com.myproject.adapter.MyViewAdapter;

public class GuildActivity extends AppCompatActivity {
    //画面图片的下标
    public static final int[] RES_IDS = {R.mipmap.bb, R.mipmap.cc, R.mipmap.dd};
    private ViewPager guideVp;
    //引导画面View的集合
    private List<View>guideViews;
    //适配器
    private MyViewAdapter guideAdapter;

    private LinearLayout dotlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild);

        dotlayout= (LinearLayout) findViewById(R.id.dot_layout);
        guideVp= (ViewPager) findViewById(R.id.guide_vp);

        initItemView();
        initView();
        initDot();

    }

    private void initDot() {
        for (int i=0; i<RES_IDS.length; i++) {
            ImageView iv = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            if (i < RES_IDS.length - 1) {
                params.rightMargin = 30;
            }
            if (i == 0) {
                iv.setSelected(true);
            }
            iv.setLayoutParams(params); //设置布局
            iv.setImageResource(R.drawable.dot); //设置图片资源
            iv.setScaleType(ImageView.ScaleType.FIT_XY); //设置填充属性
            dotlayout.addView(iv);
        }
    }

    private void initView() {
        guideAdapter= new MyViewAdapter(guideViews);
        guideVp.setAdapter(guideAdapter);
        //ViewPager的滑动监听
        guideVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int item=dotlayout.getChildCount();
                for (int i=0;i<item;i++){
                    View view=dotlayout.getChildAt(i);
                    if (i==position){
                        view.setSelected(true);
                    }else{
                        view.setSelected(false);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //初始化ViewPager数据源
    private void initItemView() {
        guideViews=new ArrayList<>();
        for(int i=0;i<RES_IDS.length;i++){
            ImageView iv=new ImageView(this);
            iv.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            ));//设置布局
            iv.setImageResource(RES_IDS[i]);//设置图片资源
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            guideViews.add(iv);
        }
        guideViews.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GuildActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
