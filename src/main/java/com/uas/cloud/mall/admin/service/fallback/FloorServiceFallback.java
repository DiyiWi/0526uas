package com.uas.cloud.mall.admin.service.fallback;

import com.uas.cloud.mall.admin.domain.Floor;
import com.uas.cloud.mall.admin.domain.Item;
import com.uas.cloud.mall.admin.service.FloorService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangck
 * @create 2017-02-28 9:37
 */
@Component // 必须加上
public class FloorServiceFallback implements FloorService {

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public List<Floor> getFloors(String usedFor) {
        logger.error("MALL-FLOOR-SERVICE unavailable");
        return new ArrayList<>();
    }

    @Override
    public Floor getFloor(String id) {
        logger.error("MALL-FLOOR-SERVICE unavailable");
        return new Floor();
    }

    @Override
    public Floor save(Floor floor) {
        logger.error("MALL-FLOOR-SERVICE unavailable");
        return new Floor();
    }

    @Override
    public void delete(String id) {
        logger.error("MALL-FLOOR-SERVICE unavailable");
    }

    @Override
    public void saveItem(@PathVariable("id") String id, @RequestBody Item item) {
        logger.error("MALL-FLOOR-SERVICE unavailable");
    }
}
