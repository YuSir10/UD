package com.example.ud;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.ud.com.ud.lvyou.TravelFragment;
import com.example.ud.com.ud.shiping.VedioMainFragment;
import com.example.ud.com.ud.wode.MyselfFragment;
import com.example.ud.com.ud.zhixun.ZixunFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar mbottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragment(new ZixunFragment());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_contain, fragment);
        transaction.commit();
    }

    private void initView() {
        mbottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        mbottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.xiaoyuan, "咨询"))
                .addItem(new BottomNavigationItem(R.drawable.shipin, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.lvxing, "旅行"))
                .addItem(new BottomNavigationItem(R.drawable.gouwu, "购物"))
                .addItem(new BottomNavigationItem(R.drawable.xiaolian, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();

        mbottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        replaceFragment(new ZixunFragment());
                        break;
                    case 1:
                        replaceFragment(new VedioMainFragment());
                        break;
                    case 2:
                        replaceFragment(new TravelFragment());
                        break;
                    case 3:
                        break;
                    case 4:
                        replaceFragment(new MyselfFragment());
                        break;
                        default:
                            return;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
