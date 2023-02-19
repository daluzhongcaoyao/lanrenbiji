package com.lanrenbiji.dict.word.data;

import com.lanrenbiji.dict.word.data.sub.WordCetLevelDto;
import com.lanrenbiji.dict.word.data.sub.WordDerivative;
import com.lanrenbiji.dict.word.data.sub.WordPosDto;
import com.lanrenbiji.dict.word.data.sub.WordVerbDto;

import lombok.Data;

/**
 * 单词详情页的数据
 */
@Data
public class WordDataDto {

    /**
     * 单词
     */
    private String word;
    /**
     * 中文翻译
     */
    private String translation;
    /**
     * 例句
     */
    private String exampleSentence;
    /**
     * 音标
     */
    private String phonetic;
    /**
     * 古代英语词频排名
     */
    private Integer bnc;
    /**
     * 现代英语词频排名
     */
    private Integer frq;
    /**
     * 柯林斯星级
     */
    private Integer collins;
    /**
     * 词性
     */
    private WordPosDto pos;
    /**
     * 动词的类型，vi/vt
     * 只有pos为verb时才会有此属性
     */
    private WordVerbDto verb;
    /**
     * 考试等级
     */
    private WordCetLevelDto level;
    /**
     * 词根词缀
     */
    private WordDerivative root;
}
