package muxin.android.yztcedu.com.myproject.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import muxin.android.yztcedu.com.myproject.R;
import muxin.android.yztcedu.com.myproject.adapter.MainAdapter;
import muxin.android.yztcedu.com.myproject.fragment.MainFragment;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    //----ViewPager相关
    public static final String[] TABS={"推荐","版本","视频","职业","娱乐"};
    private List<Fragment>mainFragment;
    private MainAdapter mainAdapter;
    private ViewPager mainviewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbat
        initToolBar();
        //darwlayout
        initMainViewPager();
        //初始化侧滑菜单
        initinvatation();
    }

    private void initinvatation() {
        navigationView= (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_tab1:
                        Toast.makeText(MainActivity.this, "地下城", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_tab2:
                        Toast.makeText(MainActivity.this, "英雄联盟", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_tab3:
                        Toast.makeText(MainActivity.this, "穿越火线", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_tab4:
                        Toast.makeText(MainActivity.this, "2K", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_tab5:
                        Toast.makeText(MainActivity.this, "添加更多", Toast.LENGTH_SHORT).show();
                        break;
                }
                //关闭菜单
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initMainViewPager() {
        // 初始化数据源
        mainFragment = new ArrayList<>();
        for (int i=0; i<TABS.length; i++) {
            Fragment fragment =new MainFragment();
            mainFragment.add(fragment);
        }
        //初始化适配器
        mainAdapter=new MainAdapter(getSupportFragmentManager(),mainFragment,TABS);
        mainviewPager= (ViewPager) findViewById(R.id.viewpager_main);
        mainviewPager.setAdapter(mainAdapter);
        //绑定Tab
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mainviewPager);
        //设置超屏数量
        mainviewPager.setOffscreenPageLimit(mainFragment.size()-1);
    }

    //初始化ToolBar
    private void initToolBar() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        //设置标题
        toolbar.setTitle("我的");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.one);

        //替换ActionBar
        setSupportActionBar(toolbar);

        //返回按钮的设置
        drawerLayout= (DrawerLayout) findViewById(R.id.drawlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();//展现返回按钮，监听Drawer的展开与隐藏
        drawerLayout.addDrawerListener(toggle);

    }
}
