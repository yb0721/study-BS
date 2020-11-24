package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Dept;
import entities.User;
import service.DeptService;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/dept")
public class DeptCpntorller {
    
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "listDept")
    public String listDept(@RequestParam(value = "page",defaultValue = "1")int page,Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user != null) {

            //获取指定页数据
            PageHelper.startPage(page, 5);

            //紧跟的第一个select方法被分页
            List<Dept> depts = deptService.listDept();

            //使用PageInfo包装数据
            PageInfo pageInfo = new PageInfo(depts, 5);
            model.addAttribute("pageInfo", pageInfo);

            return "main";
        }
        return "redirect:/error.jsp";
    }

    // public ModelAndView listDept(ModelAndView mv, HttpSession session) {
    //     User user = (User)session.getAttribute("user");
    //     if(user != null) {
    //         List<Dept> depts = deptService.listDept();

    //         mv.addObject("depts", depts);
    //         mv.setViewName("main");
    //     }
    //     return mv;
    // }

    @RequestMapping(value="addDept", method=RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String addDept(String dname, String loc) {

        System.out.println(dname + ":" + loc);

        Dept dept = new Dept();
        dept.setDname(dname);
        dept.setLoc(loc);

        try {
            deptService.addDept(dept);
            return "redirect:/dept/listDept";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "redirect:/error.jsp";
        }

    }

    @RequestMapping(value="deleteDept", method=RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteDept(Integer dno) {
        try {
            System.out.println(dno);
            deptService.deleteDept(dno);
            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value="updateDept", method=RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateDept(Integer dno, String dname, String loc) {
        try {
            Dept dept = new Dept();
            dept.setDno(dno);
            dept.setDname(dname);
            dept.setLoc(loc);
            deptService.updateDept(dept);
            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }
}
