package com.ipisces42.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ItemsSearchByKeywordsRequest", description = "产品列表搜索参数")
public class ItemsSearchByKeywordsRequest {
    @Schema(name = "keywords", required = true, description = "关键字")
    @NotBlank(message = "关键字不能为空")
    private String keywords;
    @Schema(name = "sort",required = false,description = "关键字")
    private String sort;
    @Schema(name = "page",required = false,description = "查询下一页的第几页")
    private Long page = 1L;
    private Long pageSize = 10L;
}
