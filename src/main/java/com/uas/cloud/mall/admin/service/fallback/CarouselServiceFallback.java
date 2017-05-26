package com.uas.cloud.mall.admin.service.fallback;

import com.uas.cloud.mall.admin.service.CarouselService;
import com.uas.cloud.mall.admin.domain.Carousel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yangck
 * @create 2017-02-16 17:32
 */
@Component
public class CarouselServiceFallback implements CarouselService {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public List<Carousel> carousels(String usedFor) {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel get(Long id) {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel save(Carousel carousel) {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel update(@RequestBody Carousel carousel) {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public void delete(Long id) {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
    }

    @Override
    public List<String> getUsedFor() {
        logger.error("MALL-CAROUSEL-SERVICE unavailable");
        return null;
    }
}
