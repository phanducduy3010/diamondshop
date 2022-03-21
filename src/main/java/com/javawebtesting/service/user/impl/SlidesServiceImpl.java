package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.SlidesDAO;
import com.javawebtesting.entity.Slides;
import com.javawebtesting.service.user.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlidesServiceImpl implements ISlidesService {

    @Autowired
    private SlidesDAO slideDAO;

    @Override
    public List<Slides> getDataSlides() {
        return slideDAO.getDataSlide();
    }
}
