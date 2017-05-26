package com.uas.cloud.mall.admin.service;

import com.uas.cloud.mall.admin.service.fallback.DfsServiceFallback;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 分布式文件服务
 * 后续开放
 * @author yangck
 * @create 2017-02-23 18:12
 */
@Deprecated
@FeignClient(value = "BASE-DFS-SERVICE", fallback = DfsServiceFallback.class)
public interface DfsService {

    /**
     * 使用feign无法发送multipart/form-data数据？
     * @param file
     * @return
     */
    @Headers("Content-Type: multipart/form-data")
    @RequestMapping(value = "/file/part", method = RequestMethod.POST, consumes = "multipart/form-data")
    String save(@RequestParam("file") MultipartFile file);

    @RequestMapping(value = "/file/commPart", method = RequestMethod.POST)
    String save(@RequestParam("file") CommonsMultipartFile file);

    @RequestMapping(value = "/file/content", method = RequestMethod.POST)
    String save(@RequestParam("fileName") String fileName, @RequestParam("content") byte[] content);
}