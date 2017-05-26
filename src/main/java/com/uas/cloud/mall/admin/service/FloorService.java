package com.uas.cloud.mall.admin.service;

import com.uas.cloud.mall.admin.domain.Floor;
import com.uas.cloud.mall.admin.domain.Item;
import com.uas.cloud.mall.admin.service.fallback.FloorServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangck
 * @create 2017-02-28 9:30
 */
@FeignClient(value = "MALL-FLOOR-SERVICE", fallback = FloorServiceFallback.class)
public interface FloorService {

    @RequestMapping(value = "/floors", method = RequestMethod.GET, produces = "application/json")
    List<Floor> getFloors(@RequestParam("usedFor") String usedFor);

    @RequestMapping(value = "/floors/{id}", method = RequestMethod.GET, produces = "application/json")
    Floor getFloor(@PathVariable("id") String id);

    @RequestMapping(value = "/floors", method = RequestMethod.POST, consumes = "application/json")
    Floor save(@RequestBody Floor floor);

    @RequestMapping(value = "/floors/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id);

    @RequestMapping(value = "/floors/{id}/item", method = RequestMethod.POST)
    void saveItem(@PathVariable("id") String id, @RequestBody Item item);
}
