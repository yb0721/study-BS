package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import entities.Dept;

public interface DeptMapper {

    // @Insert("insert into dept(dno,dname) values (#{dno,dname})")
    // public int add(Dept dept);
    
    // @Select("select * from dept")
    // public List<Dept> list();

    @Select("select * from dept where dno = #{dno}")
    public List<Dept> listByDept(int dno);

}