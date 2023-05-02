package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;

import java.util.List;

/**
 * @author xiaoyang
 * @date 2023/4/25
 * @program lagou_edu_home_parent
 */
public interface CourseMapper {
    List<Course> findCourseByCondition(CourseVo courseVo);
    
}
