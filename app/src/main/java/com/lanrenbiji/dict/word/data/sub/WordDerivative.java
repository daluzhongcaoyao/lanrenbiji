package com.lanrenbiji.dict.word.data.sub;

import lombok.Data;

/**
 * 词根词缀信息
 */
@Data
public class WordDerivative {

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
