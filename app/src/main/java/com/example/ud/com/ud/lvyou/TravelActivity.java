package com.example.ud.com.ud.lvyou;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ud.R;

import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity {
    private ListView mTravelListView;
    private String addressName;
    List<TravelMessage> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        Intent intent = getIntent();
        addressName = intent.getStringExtra("addressName");
        Toast.makeText(this, ""+addressName, Toast.LENGTH_SHORT).show();
        mDatas = getmDatas();
        mTravelListView = findViewById(R.id.travel_list_view);
        TravelListViewAdapter travelListViewAdapter = new TravelListViewAdapter(this, mDatas);
        mTravelListView.setAdapter(travelListViewAdapter);
        mTravelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(getApplicationContext(),TravelDetailActivity.class);
                startActivity(intent1);
            }
        });

    }

    public List<TravelMessage> getmDatas(){
        List<TravelMessage> travelMessageList = new ArrayList<>();
        TravelMessage travelMessage1 = new TravelMessage(R.drawable.img01, "一日游", "小哥哥", "dsafasdfkjalksdfgjohasdhg", "1000");
        TravelMessage travelMessage2 = new TravelMessage(R.drawable.img02, "两日游", "小姐姐", "dsafasdfkjalksdfgjohasdhg", "1300");
        TravelMessage travelMessage3 = new TravelMessage(R.drawable.img03, "三日游", "啦啦啦", "dsafasdfkjalksdfgjohasdhg", "1450");
        TravelMessage travelMessage4 = new TravelMessage(R.drawable.img04, "四日游", "哈哈哈", "dsafasdfkjalksdfgjohasdhg", "1550");
        TravelMessage travelMessage5 = new TravelMessage(R.drawable.img05, "五日游", "呵呵呵", "dsafasdfkjalksdfgjohasdhg", "1263");
        travelMessageList.add(travelMessage1);
        travelMessageList.add(travelMessage2);
        travelMessageList.add(travelMessage3);
        travelMessageList.add(travelMessage4);
        travelMessageList.add(travelMessage5);

        return travelMessageList;
    }

    public class TravelListViewAdapter extends BaseAdapter{
        private Context aContext;
        private List<TravelMessage> aTravelMessage ;

        public TravelListViewAdapter(Context aContext, List<TravelMessage> aTravelMessage) {
            this.aContext = aContext;
            this.aTravelMessage = aTravelMessage;
        }

        @Override
        public int getCount() {
            return aTravelMessage.size();
        }

        @Override
        public Object getItem(int position) {
            return aTravelMessage.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) aContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.travel_listitem, parent, false);
                viewHolder.imageView = convertView.findViewById(R.id.travel_list_img);
                viewHolder.NameTextView = convertView.findViewById(R.id.travel_list_name);
                viewHolder.OrganizerNameTextView = convertView.findViewById(R.id.travel_list_organizer_name);
                viewHolder.ContentTextView = convertView.findViewById(R.id.travel_list_content);
                viewHolder.PriceTextView = convertView.findViewById(R.id.travel_list_price);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.imageView.setBackgroundResource(mDatas.get(position).getImagerid());
            viewHolder.NameTextView.setText(mDatas.get(position).getName());
            viewHolder.OrganizerNameTextView.setText(mDatas.get(position).getOrganizerName());
            viewHolder.ContentTextView.setText(mDatas.get(position).getContent());
            viewHolder.PriceTextView.setText(mDatas.get(position).getPrice());

            return convertView;
        }
        public class ViewHolder{
            private ImageView imageView;
            private TextView NameTextView;
            private TextView OrganizerNameTextView;
            private TextView ContentTextView;
            private TextView PriceTextView;
        }
    }
}
