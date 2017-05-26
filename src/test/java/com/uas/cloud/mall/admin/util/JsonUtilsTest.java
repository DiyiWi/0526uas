package com.uas.cloud.mall.admin.util;

import com.uas.cloud.mall.admin.domain.Carousel;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaokunyang on 2017/4/14.
 */
public class JsonUtilsTest {
    @Test
    public void testJson() throws IOException {
        Carousel carousel1 = new Carousel(null, "home", 0L, "http://dfs.ubtob.com/group1/M00/17/F3/CgpkyFjaM62AQafMAACiyPLUFOk177.jpg", "", "http://mall.ubtob.com/product#/kinds/100", null, "轮播1");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("background-color", "#db143c");
        carousel1.setMetadata(metadata);

        Carousel carousel2 = new Carousel(null, "home", 100L, "http://dfs.ubtob.com/group1/M00/17/F3/CgpkyFjaM5aAV7RiAADmRfkFf9w389.jpg", null, "http://mall.ubtob.com/product#/kinds/100", null, "轮播2");
        metadata.put("background-color", "#ff98be");
        carousel2.setMetadata(metadata);

        List<Carousel> carousels = new ArrayList<>();
        carousels.add(carousel1);
        carousels.add(carousel2);

        System.out.println(JsonUtils.writeObjectToJson(carousels));
    }
}