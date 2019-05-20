package com.example.ud.com.ud.lvyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ud.R;

import java.util.ArrayList;
import java.util.List;


public class TravelFragment extends Fragment {
    private ImageView HotImageView1, HotImageView2, HotImageView3, HotImageView4, HotImageView5, HotImageView6, NowgoImageView1, NowgoImageView2, NowgoImageView3, NowgoImageView4, NowgoImageView5, NowgoImageView6;
    private TextView HotTextView1, HotTextView2, HotTextView3, HotTextView4, HotTextView5, HotTextView6, NowgoTextView1, NowgoTextView2, NowgoTextView3, NowgoTextView4, NowgoTextView5, NowgoTextView6;
    private List<HotPlace> mhotPlaceList = new ArrayList<>();
    private List<String> addresslist = new ArrayList<>();
    private List imagelist = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.travel_fragment, container, false);
        addresslist.add("杭州");
        addresslist.add("西安");
        addresslist.add("襄阳");
        addresslist.add("桂林");
        addresslist.add("厦门");
        addresslist.add("北京");
        imagelist.add(R.drawable.img01);
        imagelist.add(R.drawable.img02);
        imagelist.add(R.drawable.img03);
        imagelist.add(R.drawable.img04);
        imagelist.add(R.drawable.img05);
        imagelist.add(R.drawable.img01);
        mhotPlaceList = getMhotPlaceList();
        initView(view);
        return view;

    }

    public List<HotPlace> getMhotPlaceList() {
        List<HotPlace> hotPlaceslist = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            HotPlace hotPlace = new HotPlace(addresslist.get(index), (Integer) imagelist.get(index));
            hotPlaceslist.add(hotPlace);
        }
        return hotPlaceslist;
    }

    public class HotPlace {
        private String adressName;
        private int imageid;

        public HotPlace(String adressName, int imageid) {
            setAdressName(adressName);
            setImageid(imageid);
        }

        public String getAdressName() {
            return adressName;
        }

        public void setAdressName(String adressName) {
            this.adressName = adressName;
        }

        public int getImageid() {
            return imageid;
        }

        public void setImageid(int imageid) {
            this.imageid = imageid;
        }
    }

    private void initView(View view) {
        List<ImageView> HotPlaceimageViewList = new ArrayList<>();
        List<ImageView> NowGoimageViewList = new ArrayList<>();
        List<TextView> HotPlacetextViewList = new ArrayList<>();
        List<TextView> NowGotextViewList = new ArrayList<>();
        HotImageView1 = view.findViewById(R.id.travel_fragment_hotPlace_img_1);
        HotImageView2 = view.findViewById(R.id.travel_fragment_hotPlace_img_2);
        HotImageView3 = view.findViewById(R.id.travel_fragment_hotPlace_img_3);
        HotImageView4 = view.findViewById(R.id.travel_fragment_hotPlace_img_4);
        HotImageView5 = view.findViewById(R.id.travel_fragment_hotPlace_img_5);
        HotImageView6 = view.findViewById(R.id.travel_fragment_hotPlace_img_6);
        NowgoImageView1 = view.findViewById(R.id.travel_fragment_go_img_1);
        NowgoImageView2 = view.findViewById(R.id.travel_fragment_go_img_2);
        NowgoImageView3 = view.findViewById(R.id.travel_fragment_go_img_3);
        NowgoImageView4 = view.findViewById(R.id.travel_fragment_go_img_4);
        NowgoImageView5 = view.findViewById(R.id.travel_fragment_go_img_5);
        NowgoImageView6 = view.findViewById(R.id.travel_fragment_go_img_6);
        HotTextView1 = view.findViewById(R.id.travel_fragment_hotPlace_tx_1);
        HotTextView2 = view.findViewById(R.id.travel_fragment_hotPlace_tx_2);
        HotTextView3 = view.findViewById(R.id.travel_fragment_hotPlace_tx_3);
        HotTextView4 = view.findViewById(R.id.travel_fragment_hotPlace_tx_4);
        HotTextView5 = view.findViewById(R.id.travel_fragment_hotPlace_tx_5);
        HotTextView6 = view.findViewById(R.id.travel_fragment_hotPlace_tx_6);
        NowgoTextView1 = view.findViewById(R.id.travel_fragment_go_tx_1);
        NowgoTextView2 = view.findViewById(R.id.travel_fragment_go_tx_2);
        NowgoTextView3 = view.findViewById(R.id.travel_fragment_go_tx_3);
        NowgoTextView4 = view.findViewById(R.id.travel_fragment_go_tx_4);
        NowgoTextView5 = view.findViewById(R.id.travel_fragment_go_tx_5);
        NowgoTextView6 = view.findViewById(R.id.travel_fragment_go_tx_6);

        HotPlaceimageViewList.add(HotImageView1);
        HotPlaceimageViewList.add(HotImageView2);
        HotPlaceimageViewList.add(HotImageView3);
        HotPlaceimageViewList.add(HotImageView4);
        HotPlaceimageViewList.add(HotImageView5);
        HotPlaceimageViewList.add(HotImageView6);
        NowGoimageViewList.add(NowgoImageView1);
        NowGoimageViewList.add(NowgoImageView2);
        NowGoimageViewList.add(NowgoImageView3);
        NowGoimageViewList.add(NowgoImageView4);
        NowGoimageViewList.add(NowgoImageView5);
        NowGoimageViewList.add(NowgoImageView6);

        HotPlacetextViewList.add(HotTextView1);
        HotPlacetextViewList.add(HotTextView2);
        HotPlacetextViewList.add(HotTextView3);
        HotPlacetextViewList.add(HotTextView4);
        HotPlacetextViewList.add(HotTextView5);
        HotPlacetextViewList.add(HotTextView6);
        NowGotextViewList.add(NowgoTextView1);
        NowGotextViewList.add(NowgoTextView2);
        NowGotextViewList.add(NowgoTextView3);
        NowGotextViewList.add(NowgoTextView4);
        NowGotextViewList.add(NowgoTextView5);
        NowGotextViewList.add(NowgoTextView6);

        for (int index = 0; index < 6; index++) {
            HotPlaceimageViewList.get(index).setBackgroundResource(mhotPlaceList.get(index).getImageid());
            HotPlacetextViewList.get(index).setText(mhotPlaceList.get(index).getAdressName());
            final int finalIndex = index;
            HotPlaceimageViewList.get(index).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = mhotPlaceList.get(finalIndex).getAdressName();
                    Intent intent = new Intent(getActivity(), TravelActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("addressName",name);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
        }

    }


}
