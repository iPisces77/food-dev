package com.ipisces42.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ipisces42.mapper.CarouselMapper;
import com.ipisces42.pojo.Carousel;
import com.ipisces42.service.CarouselService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return carouselMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Carousel record) {
        return carouselMapper.insert(record);
    }

    @Override
    public int insertSelective(Carousel record) {
        return carouselMapper.insertSelective(record);
    }

    @Override
    public Carousel selectByPrimaryKey(String id) {
        return carouselMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Carousel record) {
        return carouselMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carousel record) {
        return carouselMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        return    carouselMapper.selectList(new LambdaQueryWrapper<Carousel>().eq(Carousel::getIsShow, isShow));
    }
}
