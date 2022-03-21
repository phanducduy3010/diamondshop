package com.javawebtesting.entity.mapper;

import com.javawebtesting.entity.Slides;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class  MapperSlides implements RowMapper<Slides> {

    public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
        Slides slides = new Slides();
        slides.setId(rs.getInt("id"));
        slides.setImg(rs.getString("img"));
        slides.setCaption(rs.getString("caption"));
        slides.setContent(rs.getString("content"));
        return slides;
    }

}