package com.example.ud.com.ud.shiping;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.ud.R;

import org.w3c.dom.Text;

import java.net.URL;

import javax.xml.transform.Transformer;

public class VedioPlayActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private ImageView imageView;
    private int paramsType = 1;
    private static final String TAG = "VedioPlayActivity";
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_play);
        initView();
        Log.e(TAG, "onCreate: " + android.os.Process.myTid());

//        mVideoView.setMediaController(new MediaController(this));
//
//        //播放完成回调
//
//        //设置视频路径
//        mVideoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
//
//        //开始播放视频
//        mVideoView.start();
    }


    private void initView() {
        imageView = findViewById(R.id.shiping_vedio_img);
        mVideoView = findViewById(R.id.shiping_vedio_play);
        textView = findViewById(R.id.shiping_vedio_tx);
//        mVideoView.setBackgroundResource(R.drawable.img02);
        final MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(mVideoView);
        //播放完成回调
        //设置视频路径
        Log.e(TAG, "run: ");
        Log.e(TAG, "run: " + android.os.Process.myTid());
        mVideoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
                mVideoView.pause();
                mediaController.show();
                imageView.setVisibility(View.INVISIBLE);
                mVideoView.setFocusable(true);
                textView.setText("asdfasdfasdfasdf");
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.resume();
                mVideoView.pause();
                mediaController.show();
            }
        });
    }


}



