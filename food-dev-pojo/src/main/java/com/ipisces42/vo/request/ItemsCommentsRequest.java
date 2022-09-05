package com.ipisces42.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "商品评论展示请求参数")
public class ItemsCommentsRequest {
    @NotBlank(message = "商品id不能为空")
    @Schema(name = "itemId", required = true, description = "商品id")
    private String itemId;
    @NotNull(message = "商品等级不能为空")
    @Schema(name = "level", required = false, description = "评价等级")
    private String level;
    @Schema(name = "page", required = false, description = "查询下一页的第几页")
    private Long page = 1L;
    @Schema(name = "pageSize", required = false, description = "分页的每一页显示的条数")
    private Long pageSize = 10L;
}
