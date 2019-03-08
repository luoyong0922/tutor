package com.etc.service;

import com.etc.dao.StudentsDao;
import com.etc.entity.CoursesExample;
import com.etc.entity.Students;
import com.etc.entity.StudentsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("studentsservice")
public class StudentsService {
    @Autowired
    public StudentsDao studentsMapper;
    public int insert(Students students){
        return studentsMapper.insert(students);
    }

    public String getstuphonebyname(String studentname) {
        StudentsExample stuexample = new StudentsExample();
        StudentsExample.Criteria criteria = stuexample.createCriteria();
        criteria.andStudentnameEqualTo(studentname);
        return studentsMapper.selectByExample(stuexample).get(0).getPhone();
    }

    public Long getgendercount(String grade, String gender) {
        StudentsExample stuexample = new StudentsExample();
        StudentsExample.Criteria criteria = stuexample.createCriteria();
        criteria.andGradeEqualTo(grade);
        criteria.andGenderEqualTo(gender);
       return studentsMapper.countByExample(stuexample);
    }

    public Long getCourseCount(String course, String gender) {
        StudentsExample stuexample = new StudentsExample();
        StudentsExample.Criteria criteria = stuexample.createCriteria();
        criteria.andCourseEqualTo(course);
        criteria.andGenderEqualTo(gender);
        return studentsMapper.countByExample(stuexample);
    }
}
