package com.example.ud.com.ud.shiping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ud.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHodler> {
    private OnItemClickListenner onItemClickListenner;
    private Context mContext;
    private List<Message> mMessageList;
    private RecyclerView mRecyclerView;

    public RecyclerViewAdapter(Context mContext, List<Message> mMessageList, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mMessageList = mMessageList;
        this.mRecyclerView = recyclerView;
    }

    public OnItemClickListenner getOnItemClickListenner() {
        return onItemClickListenner;
    }

    public void setOnItemClickListenner(OnItemClickListenner onItemClickListenner) {
        this.onItemClickListenner = onItemClickListenner;
    }

    @NonNull
    @Override
    public RecyclerViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerViewHodler recyclerViewHodler = new RecyclerViewHodler(LayoutInflater.from(mContext).inflate(R.layout.vedio_hot_listitem, viewGroup, false));
        return recyclerViewHodler;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHodler recyclerViewHodler, final int position) {
        recyclerViewHodler.mImageView.setImageResource(mMessageList.get(position).getmImageid());
        recyclerViewHodler.mTitleTextView.setText(mMessageList.get(position).getmTitle());
        recyclerViewHodler.mContentTextView.setText(mMessageList.get(position).getmContent());

        /**
         * 只在瀑布流布局中使用随机高度
         */
//        if (mRecyclerView.getLayoutManager().getClass() == StaggeredGridLayoutManager.class) {
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getRandHeight());
//            recyclerViewHodler.linearLayout.setLayoutParams(params);
//        }
        if (position % 3 == getRandHeight()) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getImageWidth(), getImageWidth());
            recyclerViewHodler.linearLayout.setLayoutParams(params);
        }
        recyclerViewHodler.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                if (onItemClickListenner != null) {
                    onItemClickListenner.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    /**
     * 返回不同的item高度
     *
     * @return
     */
    private int getRandHeight() {
        return (int) ( Math.random() * (4 - 0 + 1));
    }

    public class RecyclerViewHodler extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitleTextView;
        TextView mContentTextView;
        LinearLayout linearLayout;
        View mItemView;

        public RecyclerViewHodler(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.vedio_img_view);
            mTitleTextView = itemView.findViewById(R.id.vedio_title_view);
            mContentTextView = itemView.findViewById(R.id.vedio_content_view);
            linearLayout = itemView.findViewById(R.id.vedio_hot_layout);
            mItemView = itemView;
        }
    }

    interface OnItemClickListenner {
        void onItemClick(int positon);

    }

    public int getImageWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）        //130是在xml文件中那一排recyclerview之间的间距加上recyclerview和父控件的间距的和
        int imageWidth = (int) (width  * density) / 4;
        return imageWidth;
    }

}
