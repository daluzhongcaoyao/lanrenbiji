package com.lanrenbiji.dict.word.data.sub;

import lombok.Data;

@Data
public class WordCetLevelDto {
    /**
     * 中考词汇
     */
    private Boolean zk;
    /**
     * 高考词汇
     */
    private Boolean gk;
    /**
     * 考研词汇
     */
    private Boolean ky;
    /**
     * 四级词汇
     */
    private Boolean cet4;
    /**
     * 六级词汇
     */
    private Boolean cet6;
    /**
     *托福词汇
     */
    private Boolean toefl;
    /**
     * 雅思词汇
     */
    private Boolean ielts;
    /**
     * GRE词汇
     */
    private Boolean gre;

}
