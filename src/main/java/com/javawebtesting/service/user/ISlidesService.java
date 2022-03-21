package com.javawebtesting.service.user;

import com.javawebtesting.entity.Slides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISlidesService {

    @Autowired
    public List<Slides> getDataSlides();
}
