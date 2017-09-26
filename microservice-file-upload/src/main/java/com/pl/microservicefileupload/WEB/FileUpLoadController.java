package com.pl.microservicefileupload.WEB;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by 庞亮 on 2017/9/20.
 */
@Controller
public class FileUpLoadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String  handleFileUpload(@RequestParam(value = "file",required = true)MultipartFile file)throws IOException{
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileToSave);
        return fileToSave.getAbsolutePath();
    }
}
