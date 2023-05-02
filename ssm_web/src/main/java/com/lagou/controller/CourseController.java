package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyang
 * @date 2023/4/25
 * @program lagou_edu_home_parent
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVo courseVo){
        List<Course> courseList = courseService.findCourseByCondition(courseVo);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",courseList);
        return responseResult;
    }
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        try {
            if(file.isEmpty()){
                throw new RuntimeException();
            }
            String realPath = request.getServletContext().getRealPath("/");
            System.out.println(realPath);
            String uploadPath = realPath.substring(0,realPath.indexOf("ssm_web"))+"upload\\";
            System.out.println(uploadPath);
            //获取原文件名变成新文件名
            String filename = System.currentTimeMillis()+file.getOriginalFilename();
            //保存文件
            File file1 = new File(uploadPath,filename);
            if(!file1.getParentFile().exists()){
                file1.getParentFile().mkdirs();
            }
            file.transferTo(file1);
            Map<String,Object> map = new HashMap<>();
            map.put("fileName",filename);
            map.put("filePath",uploadPath+filename);
            ResponseResult responseResult = new ResponseResult(true,200,"响应成功",map);
            return responseResult;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
