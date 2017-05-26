package com.uas.cloud.mall.admin.web;

import com.uas.cloud.mall.admin.domain.Carousel;
import com.uas.cloud.mall.admin.service.CarouselService;
import com.uas.cloud.mall.admin.service.DfsService;
import com.uas.cloud.mall.admin.service.DfsServiceRibbon;
import com.uas.cloud.mall.admin.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 轮播控制器
 *
 * @author yangck
 * @create 2017-02-16 17:57
 */
@Controller
@RequestMapping("/carousels")
public class CarouselController {

    @Autowired
    CarouselService carouselService;

    @Autowired
    DfsService dfsService;

    @Autowired
    DfsServiceRibbon dfsServiceRibbon;

    @GetMapping
    public String getUsedFor(Map<String, Object> model) {
        model.put("usedFor", carouselService.getUsedFor());
        return "carousel";
    }

    @RequestMapping(value = "/{usedFor}", method = RequestMethod.GET)
    public String carousels(@PathVariable String usedFor, Map<String, Object> model) throws IOException {
        List<Carousel> carousels = carouselService.carousels(usedFor);
        model.put("usedFor", usedFor);
        model.put("carousels", carousels);
        model.put("carouselsJson", JsonUtils.writeObjectToJson(carousels));
        model.put("page", "carousel");
        return "carousel-detail";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Carousel create(@RequestBody Carousel carousel) {
        Carousel result = carouselService.save(carousel);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Carousel update(@RequestBody Carousel carousel) {
        Carousel result = carouselService.update(carousel);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable Long id) {
        carouselService.delete(id);
    }

}
