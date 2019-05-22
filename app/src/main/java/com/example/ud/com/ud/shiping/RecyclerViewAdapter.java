package com.example.ud.com.ud.shiping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ud.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHodler> {
    private Context mContext;
    private List<Message> mMessageList;
    private RecyclerView mRecyclerView;

    public RecyclerViewAdapter(Context mContext, List<Message> mMessageList, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mMessageList = mMessageList;
        this.mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RecyclerViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerViewHodler recyclerViewHodler = new RecyclerViewHodler(LayoutInflater.from(mContext).inflate(R.layout.vedio_hot_listitem, viewGroup, false));
        return recyclerViewHodler;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHodler recyclerViewHodler, int position) {
        recyclerViewHodler.mImageView.setImageResource(mMessageList.get(position).getmImageid());
        recyclerViewHodler.mTitleTextView.setText(mMessageList.get(position).getmTitle());
        recyclerViewHodler.mContentTextView.setText(mMessageList.get(position).getmContent());

        /**
         * 只在瀑布流布局中使用随机高度
         */
        if (mRecyclerView.getLayoutManager().getClass() == StaggeredGridLayoutManager.class) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getRandHeight());
            recyclerViewHodler.linearLayout.setLayoutParams(params);
        }
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
        return (int) (500+Math.random() * (800-500+1));
    }

    public class RecyclerViewHodler extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitleTextView;
        TextView mContentTextView;
        LinearLayout linearLayout;

        public RecyclerViewHodler(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.vedio_img_view);
            mTitleTextView = itemView.findViewById(R.id.vedio_title_view);
            mContentTextView = itemView.findViewById(R.id.vedio_content_view);
            linearLayout = itemView.findViewById(R.id.vedio_hot_layout);
        }
    }
}
