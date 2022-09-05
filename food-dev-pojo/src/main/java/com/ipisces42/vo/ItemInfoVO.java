package com.ipisces42.vo;

import com.ipisces42.pojo.Items;
import com.ipisces42.pojo.ItemsImg;
import com.ipisces42.pojo.ItemsParam;
import com.ipisces42.pojo.ItemsSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfoVO {
    private Items item;
    private List<ItemsImg> itemImgList;

    private List<ItemsSpec> itemSpecList;

    private ItemsParam itemParams;
}
