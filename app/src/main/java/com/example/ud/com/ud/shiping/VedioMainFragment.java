package com.example.ud.com.ud.shiping;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ud.R;
import java.util.ArrayList;
import java.util.List;

public class VedioMainFragment extends Fragment {

    private List<Fragment> mVedioFragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TabLayout tableLayout;
    private ViewPager vp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVedioFragmentList.add(new VedioFragment_hot());
        mVedioFragmentList.add(new VedioFragmentFouce());
        mVedioFragmentList.add(new VedioFragmentCity());
        titles.add("热门");
        titles.add("关注");
        titles.add("当前城市");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vediofragment_main, container, false);
        tableLayout = view.findViewById(R.id.vedio_fragment_tab);
        vp = view.findViewById(R.id.vedio_view_pager);
        vp.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mVedioFragmentList.get(i);
            }

            @Override
            public int getCount() {
                return mVedioFragmentList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }


        });
        tableLayout.setupWithViewPager(vp);
        return view;
    }
}
