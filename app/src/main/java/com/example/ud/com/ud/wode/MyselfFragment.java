package com.example.ud.com.ud.wode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.example.ud.R;

public class MyselfFragment extends Fragment {

    private CardView cardView1, cardView2, cardView3, cardView4,maincardView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myself_fragment, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        cardView1 = view.findViewById(R.id.pay_card_view1);
        cardView2 = view.findViewById(R.id.pay_card_view2);
        cardView3 = view.findViewById(R.id.pay_card_view3);
        cardView4 = view.findViewById(R.id.pay_card_view4);
        maincardView = view.findViewById(R.id.myself_card_view);
//        AlphaAnimation alphaAni = new AlphaAnimation(0, 1);
//        //设置动画执行的时间，单位是毫秒
//        alphaAni.setDuration(500);
//        maincardView.setAnimation(alphaAni);淡化
        //参数1：x轴的初始值
        //参数2：x轴收缩后的值
        //参数3：y轴的初始值
        //参数4：y轴收缩后的值
        //参数5：确定x轴坐标的类型
        //参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数7：确定y轴坐标的类型
        //参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        // Animation.RELATIVE_TO_SELF, 0.5f表示绕着自己的中心点进行动画
        ScaleAnimation scaleAni = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        //设置动画执行的时间，单位是毫秒
        scaleAni.setDuration(500);
        // 设置动画重复次数
        // -1或者Animation.INFINITE表示无限重复，正数表示重复次数，0表示不重复只播放一次
        scaleAni.setRepeatCount(0);
        // 设置动画模式（Animation.REVERSE设置循环反转播放动画,Animation.RESTART每次都从头开始）
        scaleAni.setRepeatMode(Animation.REVERSE);
        // 启动动画


        Animation translateAnimation1 = new TranslateAnimation(100, 0, 400, 0);//平移动画  从0,0,平移到100,100
        Animation translateAnimation2 = new TranslateAnimation(100, 0, 400, 0);//平移动画  从0,0,平移到100,100
        Animation translateAnimation3 = new TranslateAnimation(100, 0, 400, 0);//平移动画  从0,0,平移到100,100
        Animation translateAnimation4 = new TranslateAnimation(100, 0, 400, 0);//平移动画  从0,0,平移到100,100
        translateAnimation1.setDuration(500);//动画持续的时间为1.5s
        translateAnimation2.setDuration(500);//动画持续的时间为1.5s
        translateAnimation3.setDuration(500);//动画持续的时间为1.5s
        translateAnimation4.setDuration(500);//动画持续的时间为1.5s
        cardView1.setAnimation(translateAnimation1);
        cardView2.setAnimation(translateAnimation2);
        translateAnimation2.setStartOffset(200);
        cardView3.setAnimation(translateAnimation3);
        translateAnimation3.setStartOffset(300);
        cardView4.setAnimation(translateAnimation4);
        translateAnimation4.setStartOffset(400);
        //cardView.setAnimation(translateAnimation_left_up);//给imageView添加的动画效果
        //translateAnimation.setFillEnabled(true);//使其可以填充效果从而不回到原地
        //translateAnimation.setFillAfter(true);//不回到起始位置        //如果不添加setFillEnabled和setFillAfter则动画执行结束后会自动回到远点
        translateAnimation1.startNow();
        translateAnimation2.startNow();
        translateAnimation3.startNow();
        translateAnimation4.startNow();
        maincardView.startAnimation(scaleAni);//动画开始执行 放在最后即可

    }
}
