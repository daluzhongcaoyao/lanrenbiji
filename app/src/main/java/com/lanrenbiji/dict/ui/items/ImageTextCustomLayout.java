package com.lanrenbiji.dict.ui.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.word.ui.WordFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageTextCustomLayout extends LinearLayout {

    @BindView(R.id.icon)
   protected ImageView mIcon;

    @BindView(R.id.text)
    protected TextView mText;

    protected Fragment mFragment;

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
    }


    public void setFragment(WordFragment fragment){
        mFragment =fragment;
    }


}
