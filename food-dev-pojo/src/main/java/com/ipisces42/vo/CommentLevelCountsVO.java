package com.ipisces42.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于展示商品评价数量的VO
 *
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLevelCountsVO {
    private Long totalCounts;
    private Long goodCounts;
    private Long normalCounts;
    private Long badCounts;
}
