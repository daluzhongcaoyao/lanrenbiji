package com.lanrenbiji.dict.ui.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final List<String> words = new ArrayList<>();


    MyAdapter() {
        for (int i = 0; i < 10; i++) {
            words.add("Word " + (i + 1));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = holder.itemView.getContext().getResources().getDisplayMetrics().heightPixels;
        holder.itemView.setLayoutParams(layoutParams);
        // 绑定数据
        String word = words.get(position);
        holder.bind(word);


    }

    @Override
    public int getItemCount() {
        // 返回数据项数量
        return words.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    // 定义ViewHolder内部控件变量

    public MyViewHolder(View itemView) {
        super(itemView);
        // 初始化ViewHolder内部控件变量
        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(String string) {
        textView.setText(string);
    }
}
