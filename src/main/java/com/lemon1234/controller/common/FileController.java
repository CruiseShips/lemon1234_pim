package com.lemon1234.controller.common;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemon1234.entity.dict.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{公共端-图片请求}")
@RestController
@RequestMapping("/file")
public class FileController {
	
	@Value("${filePath}")
	private String filePath;

	@ApiOperation(value = "获取文件", notes = "根据文件获取文件，使用流写出去", httpMethod = "GET")
	@RequestMapping(value = "/getFile/{fileType}/{name}", method = RequestMethod.GET)
	public void getFile(@PathVariable(value = "fileType", required = true) String fileType,
						@PathVariable(value = "name", required = true) String name,
						HttpServletResponse response) throws IOException {
		File file = new File(filePath + fileType + File.separator + name);
		if(file.exists()) {
			byte[] b = null;
			try {
				b = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			OutputStream os = null;
			String suffix = name.substring(name.lastIndexOf(".")).replace(".", "");
			try {
				os = response.getOutputStream();
				if(fileType.equals(Constants.IMAGE)) {
					response.setContentType("image/" + suffix);	
				} else {
					response.setContentType("text/html");
				}
				os.write(b);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					os.flush();
					os.close();
				}
			}
		}
	}
}
