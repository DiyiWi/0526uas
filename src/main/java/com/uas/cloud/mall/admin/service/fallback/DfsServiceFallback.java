package com.uas.cloud.mall.admin.service.fallback;

import com.uas.cloud.mall.admin.service.DfsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author yangck
 * @create 2017-02-23 18:15
 */
@Component
public class DfsServiceFallback implements DfsService {

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public String save(@RequestBody MultipartFile file) {
        logger.error("BASE-DFS-SERVICE unavailable");
        return null;
    }

    @Override
    public String save(CommonsMultipartFile file) {
        logger.error("BASE-DFS-SERVICE unavailable");
        return null;
    }

    @Override
    public String save(String fileName, byte[] content) {
        logger.error("BASE-DFS-SERVICE unavailable");
        return null;
    }
}
