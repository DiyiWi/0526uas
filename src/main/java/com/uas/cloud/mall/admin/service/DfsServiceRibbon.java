package com.uas.cloud.mall.admin.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yangck
 * @create 2017-02-25 17:55
 */
@Service
public class DfsServiceRibbon {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "saveFallback")
    public String save(MultipartFile multipartFile) {
        //try {
        //    Files.write(Paths.get("C:\\Users\\chaokunyang\\Desktop\\picture.jpg"), multipartFile.getBytes());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        LinkedMultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        final String filename = multipartFile.getOriginalFilename();
        parts.add("name", filename);
        parts.add("filename", filename);
        try {
            ByteArrayResource contentsAsResource = new ByteArrayResource(multipartFile.getBytes()) {
                @Override
                public String getFilename() {
                    return filename;
                }
            };
            parts.add("file", contentsAsResource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<> (parts, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://BASE-DFS-SERVICE/file/part", HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public String saveFallback(MultipartFile multipartFile) {
        logger.error("BASE-DFS-SERVICE unavailable");
        return null;
    }

}
