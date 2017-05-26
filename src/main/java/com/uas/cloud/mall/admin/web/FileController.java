package com.uas.cloud.mall.admin.web;

import com.uas.cloud.mall.admin.service.DfsServiceRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by suntg on 2017/4/1.
 */
@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private DfsServiceRibbon dfsServiceRibbon;

	/**
	 * 上传附件
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping
	public String upload(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String path = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mf = entity.getValue();
			path = dfsServiceRibbon.save(mf);
		}
		return path;
	}

	@PostMapping(value = "/part")
	public String upload(@RequestParam("file") MultipartFile file) {
		return dfsServiceRibbon.save(file);
	}
}
