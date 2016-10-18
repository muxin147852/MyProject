package muxin.android.yztcedu.com.myproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class MainAdapter extends FragmentPagerAdapter{
    private List<Fragment>mainFragment;
    private String[]tabs;
    public MainAdapter(FragmentManager fm,List<Fragment>mainFragment,String[]tabs) {
        super(fm);
        this.mainFragment=mainFragment;
        this.tabs=tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return mainFragment.get(position);
    }

    @Override
    public int getCount() {
        return mainFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
