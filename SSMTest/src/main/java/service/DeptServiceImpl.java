package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Dept;
import mappers.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> listDept() {
        // TODO Auto-generated method stub
        return deptMapper.listDept();
    }

    public Integer addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public Integer deleteDept(Integer dno) {
        return deptMapper.deleteDept(dno);
    }

    public Integer updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }
}