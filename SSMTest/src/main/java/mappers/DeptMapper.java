package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entities.Dept;

public interface DeptMapper {
    public List<Dept> listDept();

    public Integer addDept(Dept dept);

    public Integer deleteDept(@Param(value = "dno")Integer dno);

    public Integer updateDept(Dept dept);

}