package com.uas.cloud.mall.admin.web;

import com.uas.cloud.mall.admin.domain.Floor;
import com.uas.cloud.mall.admin.domain.FloorPictures;
import com.uas.cloud.mall.admin.domain.Item;
import com.uas.cloud.mall.admin.service.DfsServiceRibbon;
import com.uas.cloud.mall.admin.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 楼层
 *
 * @author yangck
 * @create 2017-03-02 9:13
 */
@Controller
@RequestMapping("/floors")
public class FloorController {

    @Autowired
    DfsServiceRibbon dfsServiceRibbon;

    @Autowired
    FloorService floorService;

    @GetMapping
    public String getFloors(@RequestParam(value = "usedFor", defaultValue = "home") String usedFor, Map<String, Object> model) {
        List<Floor> floors = floorService.getFloors(usedFor);
        model.put("floors", floors);
        model.put("page", "floors");
        return "floor";
    }

    /**
     * 楼层详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}")
    public String getFloorsById(@PathVariable("id") String id, Map<String, Object> model) {
        Floor floor = floorService.getFloor(id);
        model.put("floor", floor);
        model.put("page", "floors");
        return "floorDetail";
    }

    /**
     * 修改或保存明细
     * @param id
     * @param item
     */
    @PostMapping(value = "/{id}/item")
    @ResponseBody
    public void updateItem(@PathVariable("id") String id, Item item) {
        floorService.saveItem(id, item);
    }

    @PostMapping
    public @ResponseBody void save(Floor floor, FloorPictures floorPictures) {
        floor.getItems().get(0).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile1()));
        floor.getItems().get(1).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile2()));
        floor.getItems().get(2).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile3()));
        floor.getItems().get(3).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile4()));
        floor.getItems().get(4).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile5()));
        floor.getItems().get(5).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile6()));
        floor.getItems().get(6).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile7()));
        floor.getItems().get(7).setPictureUrl(dfsServiceRibbon.save(floorPictures.getFile8()));
        floorService.save(floor);
    }

}
