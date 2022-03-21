package com.javawebtesting.dao;

import com.javawebtesting.entity.mapper.MapperSlides;
import com.javawebtesting.entity.Slides;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SlidesDAO extends BaseDAO{

    public List<Slides> getDataSlide(){
        List<Slides> list = new ArrayList<Slides>();
        String sql = "SELECT * FROM slides";
        list = _jdbcTemplate.query(sql, new MapperSlides());
        return list;
    }
}