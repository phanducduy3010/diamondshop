package com.javawebtesting.service.user;

import com.javawebtesting.dto.PaginationDTO;
import org.springframework.stereotype.Service;

@Service
public interface IPaginationService {
    public PaginationDTO getPaginationInfo(int totalProducts, int limit, int currentPage);
}
