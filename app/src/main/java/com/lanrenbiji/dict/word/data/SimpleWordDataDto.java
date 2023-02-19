package com.lanrenbiji.dict.word.data;

import com.lanrenbiji.dict.word.data.sub.WordPosDto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 单词闪过页面的单词信息，只有很少一部分数据
 */
@Data
@Accessors(chain = true)
public class SimpleWordDataDto {

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
     * 柯林斯星级
     */
    private Integer collins;
    /**
     * 词性
     */
    private String pos;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 词根
     */
    private String root;
    /**
     * 后缀
     */
    private String suffix;

}
