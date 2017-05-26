package com.uas.cloud.mall.admin.service.fallback;

import com.uas.cloud.mall.admin.domain.Category;
import com.uas.cloud.mall.admin.service.CategoryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangck
 * @create 2017-02-16 17:25
 */
@Component
public class CategoryServiceFallback implements CategoryService {

    private Logger logger = LogManager.getLogger(getClass());


    @Override
    public Category get(@PathVariable("id") Long id) {
        logger.error("MALL-CATEGORY-SERVICE unavailable");
        return null;
    }

    @Override
    public Category save(@RequestParam Category category) {
        logger.error("MALL-CATEGORY-SERVICE unavailable");

        return null;
    }
}
