package com.example.ud.com.ud.shiping;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ud.R;

import java.util.ArrayList;
import java.util.List;

public class VedioFragmentCity extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Message> mdatas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vediofragment_city, container, false);
        mdatas = getMessageData();
        mRecyclerView = view.findViewById(R.id.vedio_hot_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        RecyclerViewAdapter mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(),mdatas,mRecyclerView);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        return view;

    }
    public List<Message> getMessageData() {
        List<Message> messageslist = new ArrayList<>();
        Message message1 = new Message(1, R.drawable.img01, "学习慕课Android技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message2 = new Message(2, R.drawable.img02, "学习慕课Java技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message3 = new Message(3, R.drawable.img03, "学习慕课Python技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message4 = new Message(4, R.drawable.timg, "学习慕课C#技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message5 = new Message(1, R.drawable.img05, "学习慕课C++技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        messageslist.add(message1);
        messageslist.add(message2);
        messageslist.add(message3);
        messageslist.add(message4);
        messageslist.add(message5);
        messageslist.add(message1);
        messageslist.add(message2);
        messageslist.add(message3);
        messageslist.add(message4);
        messageslist.add(message5);
        return messageslist;
    }
}
