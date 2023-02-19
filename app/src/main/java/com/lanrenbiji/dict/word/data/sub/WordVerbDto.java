package com.lanrenbiji.dict.word.data.sub;

import lombok.Data;

/**
 * 动词的类型
 */
@Data
public class WordVerbDto {

    /**
     * 不及物动词
     */
    private Boolean vi;
    /**
     * 及物动词
     */
    private Boolean vt;
    /**
     * 单及物动词
     */
    private Boolean vt1;
    /**
     * 双及物动词
     */
    private Boolean vt2;
    /**
     * 复杂及物动词
     */
    private Boolean vtx;

}
