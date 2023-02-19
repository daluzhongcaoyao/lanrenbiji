package com.lanrenbiji.dict.word.data.sub;

import lombok.Data;

/**
 * 单词变形
 */
@Data
public class WordChangeDto {

    /**
     * 原型
     */
    private String origin;
    /**
     * 过去式
     */
    private String did;
    /**
     * 过去分词
     */
    private String done;
    /**
     * 进行时
     */
    private String doing;
    /**
     * 第三人称单数
     */
    private String does;
    /**
     * 比较级
     */
    private String er;
    /**
     * 最高级
     */
    private String est;

}
