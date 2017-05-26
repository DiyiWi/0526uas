package com.uas.cloud.mall.admin.service;

import com.uas.cloud.mall.admin.domain.Carousel;
import com.uas.cloud.mall.admin.service.fallback.CarouselServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 轮播服务
 *
 * @author yangck
 * @create 2017-02-16 17:29
 */
@FeignClient(value = "MALL-CAROUSEL-SERVICE", fallback = CarouselServiceFallback.class)
public interface CarouselService {

    @RequestMapping(value = "/carousels", method = RequestMethod.GET)
    List<Carousel> carousels(@RequestParam("usedFor") String usedFor);

    @RequestMapping(value = "/carousels/{id}", method = RequestMethod.GET)
    Carousel get(@PathVariable("id") Long id);

    @RequestMapping(value = "/carousels", method = RequestMethod.POST)
    Carousel save(@RequestBody Carousel carousel);

    @RequestMapping(value = "/carousels", method = RequestMethod.PUT)
    Carousel update(@RequestBody Carousel carousel);

    @RequestMapping(value = "/carousels/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

    @RequestMapping(value = "/carousels/usedFor", method = RequestMethod.GET)
    List<String> getUsedFor();
}
