package com.zz.springboot.mapper;

import com.zz.springboot.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    //主键自增，设置对应的字段。插入之后，主键会封装到department对象
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Select("select * from department where id=#{id}")
    public Department selectById(Integer id);
}
