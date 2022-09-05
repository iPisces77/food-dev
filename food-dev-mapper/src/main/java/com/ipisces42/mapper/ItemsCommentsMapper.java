package com.ipisces42.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipisces42.dto.ItemsCommentDTO;
import com.ipisces42.pojo.ItemsComments;
import com.ipisces42.vo.request.ItemsCommentsRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemsCommentsMapper extends BaseMapper<ItemsComments> {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(ItemsComments record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ItemsComments record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ItemsComments selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ItemsComments record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ItemsComments record);

    Page<ItemsCommentDTO> queryItemComments(IPage<?> page, @Param("request") ItemsCommentsRequest request);


}