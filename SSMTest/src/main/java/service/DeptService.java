package service;

import java.util.List;

import entities.Dept;

public interface DeptService {
    public List<Dept> listDept();

    public Integer addDept(Dept dept);

    public Integer deleteDept(Integer dno);

    public Integer updateDept(Dept dept);
}