package com.xuecheng.manage_course.dao;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.CourseBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testCourseBaseRepository() {
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if (optional.isPresent()) {
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }

    }

    @Test
    public void testCourseMapper() {
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }

    @Test
    public void testPageHelper() {
        PageHelper.startPage(1, 5);
        Page<CourseBase> couseList = courseMapper.findCourseList();
        String s = JSON.toJSONString(couseList);
        //System.out.println(s);
        long total = couseList.getTotal();
        List<CourseBase> result = couseList.getResult();
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put("total", total);
        hashMap.put("result", result);

        Map<String,Object> map = new HashMap<>();
        map.put("data", hashMap);
        String s2 = JSON.toJSONString(map);
        System.out.println(s2);

    }
}
