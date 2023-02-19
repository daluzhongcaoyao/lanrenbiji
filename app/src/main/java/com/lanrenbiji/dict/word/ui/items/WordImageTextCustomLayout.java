package com.lanrenbiji.dict.word.ui.items;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.dict.WebViewFragment;
import com.lanrenbiji.dict.ui.items.ImageTextCustomLayout;
import com.lanrenbiji.dict.word.data.SimpleWordDataDto;
import com.lanrenbiji.dict.word.ui.WordAdapter;
import com.lanrenbiji.dict.word.ui.WordFragment;

import java.util.Objects;
import java.util.Optional;

public class WordImageTextCustomLayout extends ImageTextCustomLayout {


    private final String DICT_TYPE_LONGMAN;
    private final String DICT_TYPE_COLLINS;
    private final String DICT_TYPE_OXFORD;


    public WordImageTextCustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        // click监听
        setOnClickListener(this::onclick);

        // 绑定字典类型
        DICT_TYPE_LONGMAN = getResources().getString(R.string.dict_type_longman);
        DICT_TYPE_COLLINS = getResources().getString(R.string.dict_type_collins);
        DICT_TYPE_OXFORD = getResources().getString(R.string.dict_type_oxford);
    }

    private void onclick(View v) {
        SimpleWordDataDto currentData = getCurrentData();
        String dictType = Optional.of(mText).map(TextView::getText).map(CharSequence::toString).orElse("");
        if (TextUtils.isEmpty(dictType)) {
            return;
        }

        String url = "";
        if (DICT_TYPE_LONGMAN.equals(dictType)) {
            url = "https://www.ldoceonline.com/dictionary/" + currentData.getWord();
        } else if (DICT_TYPE_COLLINS.equals(dictType)) {
            url = "https://www.collinsdictionary.com/dictionary/english/" + currentData.getWord();
        } else if (DICT_TYPE_OXFORD.equals(dictType)) {
            url = "https://www.oxfordlearnersdictionaries.com/definition/english/" + currentData.getWord();
        } else {
            return;
        }

        WebViewFragment fragment = new WebViewFragment(url);
        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setFragment(WordFragment fragment) {
        mFragment = fragment;
    }

    SimpleWordDataDto getCurrentData() {
        SimpleWordDataDto simpleWordDataDto = new SimpleWordDataDto();
        RecyclerView recyclerView = null;
        if (mFragment instanceof WordFragment) {
            recyclerView = ((WordFragment) mFragment).getRecyclerView();
        }

        if (Objects.isNull(recyclerView)) {
            return simpleWordDataDto;
        }
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (Objects.isNull(layoutManager)) {
            return simpleWordDataDto;
        }
        int position = layoutManager.findFirstVisibleItemPosition();
        if (position != RecyclerView.NO_POSITION) {
            // getSimpleWordDataAtPosition
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter instanceof WordAdapter) {
                simpleWordDataDto = ((WordAdapter) adapter).getItemAtPosition(position);
            }
        }
        return simpleWordDataDto;
    }


}


