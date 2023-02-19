package com.lanrenbiji.dict.word.ui.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.dict.WebViewFragment;
import com.lanrenbiji.dict.word.data.SimpleWordDataDto;
import com.lanrenbiji.dict.word.ui.IRecycleViewDataCallback;
import com.lanrenbiji.dict.word.ui.WordAdapter;
import com.lanrenbiji.dict.word.ui.WordFragment;

import java.util.Objects;
import java.util.Optional;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageTextCustomLayout extends LinearLayout {

    @BindView(R.id.icon)
    ImageView mIcon;

    @BindView(R.id.text)
    TextView mText;

    private final String  DICT_TYPE_LONGMAN;
    private final String  DICT_TYPE_COLLINS;
    private final String  DICT_TYPE_OXFORD;

   private   WordFragment mFragment;

    public ImageTextCustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_layout_image_text, this, true);
        ButterKnife.bind(this);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomLayoutImageText);
        int iconResId = a.getResourceId(R.styleable.CustomLayoutImageText_icon, 0);
        String text = a.getString(R.styleable.CustomLayoutImageText_text);
        a.recycle();

        if (iconResId != 0) {
            mIcon.setImageResource(iconResId);
        }
        if (text != null) {
            mText.setText(text);
        }

        // click监听
        setOnClickListener(this::onclick);

        //
        DICT_TYPE_LONGMAN = getResources().getString(R.string.dict_type_longman);
        DICT_TYPE_COLLINS = getResources().getString(R.string.dict_type_collins);
        DICT_TYPE_OXFORD = getResources().getString(R.string.dict_type_oxford);
    }

   private void onclick(View v){
       SimpleWordDataDto currentData = getCurrentData();
       String dictType = Optional.of(mText).map(TextView::getText).map(CharSequence::toString).orElse("");
       if (TextUtils.isEmpty(dictType)){
           return;
       }

       System.out.println("zktest currentData" +currentData);
       String url = "";
       if (DICT_TYPE_LONGMAN.equals(dictType)){
            url = "https://www.ldoceonline.com/dictionary/" + currentData.getWord();
       }else if (DICT_TYPE_COLLINS.equals(dictType)){
           url = "https://www.collinsdictionary.com/dictionary/english/" + currentData.getWord();
       }else if (DICT_TYPE_OXFORD.equals(dictType)){
           url = "https://www.oxfordlearnersdictionaries.com/definition/english/" + currentData.getWord();
       }else {
           return;
       }

       WebViewFragment fragment = new WebViewFragment(url);
       FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.container, fragment);
       transaction.addToBackStack(null);
       transaction.commit();
   }

   public void setWordFragment(WordFragment fragment){
       mFragment =fragment;
   }

    SimpleWordDataDto getCurrentData(){
        SimpleWordDataDto simpleWordDataDto = new SimpleWordDataDto();
        RecyclerView recyclerView = mFragment.getRecyclerView();
        if (Objects.isNull(recyclerView)){
            return simpleWordDataDto;
        }
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (Objects.isNull(layoutManager)){
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


