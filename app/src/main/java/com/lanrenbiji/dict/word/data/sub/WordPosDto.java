package com.lanrenbiji.dict.word.data.sub;

import lombok.Data;

/**
 * 词性
 */
@Data
public class WordPosDto {

    /**
     * 副词r
     */
    private Boolean adv;
    /**
     * 形容词j
     */
    private Boolean adj;
    /**
     * 数词m
     */
    private Boolean num;
    /**
     * 名词n
     */
    private Boolean noun;
    /**
     * 动词v
     */
    private Boolean verb;
    /**
     * 不定式t
     */
    private Boolean inf;
    /**
     * 代词p
     */
    private Boolean pron;
    /**
     * 限定词d
     */
    private Boolean det;
    /**
     * 冠词a
     */
    private Boolean art;
    /**
     * 感叹词u
     */
    private Boolean intU;
    /**
     * 介词i
     */
    private Boolean prep;
    /**
     * 连词c
     */
    private Boolean conj;

}
