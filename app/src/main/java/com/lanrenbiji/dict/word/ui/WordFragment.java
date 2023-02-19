package com.lanrenbiji.dict.word.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.word.data.SimpleWordDataDto;
import com.lanrenbiji.dict.word.ui.items.ImageTextCustomLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.longman)
    ImageTextCustomLayout longman;

    @BindView(R.id.collins)
    ImageTextCustomLayout collins;

    @BindView(R.id.oxford)
    ImageTextCustomLayout oxford;

    public WordFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        ButterKnife.bind(this, view);

        WordAdapter adapter = new WordAdapter();
        mRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        // 给按钮增加获取recycleView当前数据的监听器
        longman.setRecycleViewDataCallback(adapter::getCurrentData);
        collins.setRecycleViewDataCallback(adapter::getCurrentData);
        oxford.setRecycleViewDataCallback(adapter::getCurrentData);

        return view;
    }


}

