package com.lanrenbiji.dict.word.ui;

import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.word.data.SimpleWordDataDto;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

class WordViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_word)
    TextView textWord;

    @BindView(R.id.text_phonetic)
    TextView textPronunciation;

    @BindView(R.id.text_example)
    TextView textExampleSentence;

    @BindView(R.id.text_pos)
    TextView textPartOfSpeech;

    @BindView(R.id.text_translation)
    TextView textTranslation;


    // 使用ButterKnife绑定ViewHolder内部控件变量

    public WordViewHolder(View itemView) {
        super(itemView);
        // 初始化ViewHolder内部控件变量
        ButterKnife.bind(this, itemView);
    }

    public void bind(SimpleWordDataDto dataDto) {
        textWord.setText(dataDto.getWord());
        Integer collins = dataDto.getCollins();
        textWord.setTextColor(getColor(collins));
        textPronunciation.setText(dataDto.getPhonetic());
        textExampleSentence.setText(dataDto.getExampleSentence());
        textPartOfSpeech.setText(dataDto.getPos());
        textTranslation.setText(dataDto.getTranslation());
    }

    private int getColor(Integer collins) {
        int color = ContextCompat.getColor(itemView.getContext(), R.color.gray_9);
        if (Objects.isNull(collins)){
            return color;
        }
        switch (collins) {
            case 5:
                color = ContextCompat.getColor(itemView.getContext(), R.color.dust_red_6);
                break;
            case 4:
                color = ContextCompat.getColor(itemView.getContext(), R.color.sunset_orange_6);
                break;
            case 3:
                color = ContextCompat.getColor(itemView.getContext(), R.color.golden_purple_6);
                break;
            case 2:
                color = ContextCompat.getColor(itemView.getContext(), R.color.daybreak_blue_6);
                break;
            case 1:
                color = ContextCompat.getColor(itemView.getContext(), R.color.ploar_green_6);
                break;
            default:
                break;
        }

        return color;
    }


}
