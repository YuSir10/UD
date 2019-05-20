package com.example.ud.com.ud.shiping;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ud.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class VedioFragment_hot extends Fragment {
    private Context mcontext;
    private ListView mlistView1;
    ListViewAdapter mlistViewAdapter1;
    List<Message> mdatas;
    private String TAG = "VedioFragment";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mcontext = getContext();
        mdatas = getMessageData();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vediofragment_hot, container, false);
        mlistView1 = view.findViewById(R.id.vedio_hot_list_view1);
        mlistViewAdapter1 = new ListViewAdapter(getContext(), mdatas);
        mlistView1.setAdapter(mlistViewAdapter1);
        return view;
    }

    public List<Message> getMessageData() {
        List<Message> messageslist = new ArrayList<>();
        Message message1 = new Message(1, R.drawable.img01, "学习慕课Android技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message2 = new Message(2, R.drawable.img02, "学习慕课Java技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message3 = new Message(3, R.drawable.img03, "学习慕课Python技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
        Message message4 = new Message(4, R.drawable.img04, "学习慕课C#技术", "阿斯蒂芬记录卡撒旦金佛i叫我欸请您耐心爱撒娇的佛海");
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

    public class ListViewAdapter extends BaseAdapter {
        private Context acontext;
        private List<Message> aMessageList;

        public ListViewAdapter(Context acontext, List<Message> aMessageList) {
            this.acontext = acontext;
            this.aMessageList = aMessageList;
        }

        @Override
        public int getCount() {
            return aMessageList.size();
        }

        @Override
        public Object getItem(int position) {
            return aMessageList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) acontext.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.vedio_hot_listitem, parent, false);
                viewHolder.mCardViewLeft = convertView.findViewById(R.id.vedio_card_left);
                viewHolder.mCardViewRight = convertView.findViewById(R.id.vedio_card_right);
                viewHolder.mImageView1 = convertView.findViewById(R.id.id_img_view1);
                viewHolder.mTitleText1 = convertView.findViewById(R.id.id_tv_title1);
                viewHolder.mContentText1 = convertView.findViewById(R.id.id_tv_content1);
                viewHolder.mImageView2 = convertView.findViewById(R.id.id_img_view2);
                viewHolder.mTitleText2 = convertView.findViewById(R.id.id_tv_title2);
                viewHolder.mContentText2 = convertView.findViewById(R.id.id_tv_content2);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mCardViewRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(acontext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.mCardViewLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(acontext, "" + aMessageList.get(position).getmTitle(), Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.mImageView1.setImageResource(aMessageList.get(position).getmImageid());
            viewHolder.mTitleText1.setText(aMessageList.get(position).getmTitle());
            viewHolder.mContentText1.setText(aMessageList.get(position).getmContent());
            viewHolder.mImageView2.setImageResource(aMessageList.get(position).getmImageid());
            viewHolder.mTitleText2.setText(aMessageList.get(position).getmTitle());
            viewHolder.mContentText2.setText(aMessageList.get(position).getmContent());

            return convertView;
        }


        public class ViewHolder {
            private CardView mCardViewLeft;
            private CardView mCardViewRight;
            public ImageView mImageView1;
            public TextView mTitleText1;
            public TextView mContentText1;
            public ImageView mImageView2;
            public TextView mTitleText2;
            public TextView mContentText2;

        }
    }
}
