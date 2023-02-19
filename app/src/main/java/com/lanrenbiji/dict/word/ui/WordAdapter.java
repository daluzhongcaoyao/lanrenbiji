package com.lanrenbiji.dict.word.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.word.data.SimpleWordDataDto;

import java.util.ArrayList;
import java.util.List;

class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {
    private final List<SimpleWordDataDto> words = new ArrayList<>();


    WordAdapter() {
        initData();
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = holder.itemView.getContext().getResources().getDisplayMetrics().heightPixels;
        holder.itemView.setLayoutParams(layoutParams);
        // 绑定数据
        SimpleWordDataDto simpleWordDataDto = words.get(position);
        holder.bind(simpleWordDataDto);


    }

    @Override
    public int getItemCount() {
        // 返回数据项数量
        return words.size();
    }

    private void initData(){
        SimpleWordDataDto  community = new SimpleWordDataDto()
                .setWord("community")
                .setTranslation("n. 社区, 公众, 共有, 共同体<br>[经] 公众, 共有, 社会")
                .setCollins(5)
                .setPhonetic("kә'mju:niti")
                .setPos("名词")
                .setPrefix(null)
                .setRoot("commun")
                .setSuffix("-ity");

        SimpleWordDataDto  consumer = new SimpleWordDataDto()
                .setWord("consumer")
                .setTranslation("n. 消费者<br>[经] 消费者, 用户")
                .setCollins(4)
                .setPhonetic("kәn'sju:mә")
                .setPos("名词")
                .setPrefix(null)
                .setRoot("consume")
                .setSuffix("-er");

        SimpleWordDataDto  breed = new SimpleWordDataDto()
                .setWord("breed")
                .setTranslation("n. 种类, 品种<br>v. 养育, 引起, 饲养, 繁殖")
                .setCollins(3)
                .setPhonetic("bri:d")
                .setPos("名词/动词")
                .setPrefix(null)
                .setRoot(null)
                .setSuffix(null);

        SimpleWordDataDto  beloved = new SimpleWordDataDto()
                .setWord("beloved")
                .setTranslation("a. 心爱的<br>n. 心爱的人")
                .setCollins(2)
                .setPhonetic("bi'lʌvd")
                .setPos("形容词/名词")
                .setPrefix("be-")
                .setRoot("lov-")
                .setSuffix("-ed");

        SimpleWordDataDto  collaborate = new SimpleWordDataDto()
                .setWord("collaborate")
                .setTranslation("vi. 合作, 勾结<br>[法] 合作, 合著, 通敌")
                .setCollins(1)
                .setPhonetic("kә'læbәreit")
                .setPos("动词")
                .setPrefix("col-")
                .setRoot("labor-")
                .setSuffix("-ate");
        SimpleWordDataDto  corresponding = new SimpleWordDataDto()
                .setWord("corresponding")
                .setTranslation("a. 相当的, 一致的, 通信的<br>[计] 对应")
                .setCollins(0)
                .setPhonetic(".kɒri'spɒndiŋ")
                .setPos("形容词")
                .setPrefix("")
                .setRoot("correspond")
                .setSuffix("-ing");

        words.add(community);
        words.add(consumer);
        words.add(breed);
        words.add(beloved);
        words.add(collaborate);
        words.add(corresponding);
    }
}

