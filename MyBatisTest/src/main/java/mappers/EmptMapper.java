package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import entities.Empt;

public interface EmptMapper {

    @Select("select * from empt")
    @Results({
                @Result(property = "empno", column = "empno"),
                @Result(property = "dept", javaType = List.class, column = "dno", many = 
                @Many(select = "mappers.DeptMapper.listByDept"))
    })
    public List<Empt> list();
}