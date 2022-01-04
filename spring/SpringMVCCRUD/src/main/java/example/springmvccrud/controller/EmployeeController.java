package example.springmvccrud.controller;

import example.springmvccrud.bean.Employee;
import example.springmvccrud.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDAO dao;

    @RequestMapping(value="/")
    public String displayHomepage() {
        return "index";
    }

    @RequestMapping(value="/viewemployee")
    public String viewEmployee(Model m) {
        List<Employee> list = dao.getEmployeeList();
        m.addAttribute("list",list);
        return "viewemployee";
    }

    @RequestMapping(value="/addemployee")
    public String addEmployee(Model m) {
        m.addAttribute("command", new Employee());
        return "addemployee";
    }

    @RequestMapping(value="/addsave")
    public String addSave(@ModelAttribute("employee") Employee employee) {
        dao.add(employee);
        return "redirect:/viewemployee";
    }

    @RequestMapping(value="/editemployee/{id}")
    public String editEmployee(@PathVariable int id, Model m) {
        Employee employee = dao.getEmployeeById(id);
        m.addAttribute("command",employee);
        return "editemployee";
    }

    @RequestMapping(value="/editsave")
    public String editSave(@ModelAttribute("employee") Employee employee) {
        dao.edit(employee);
        return "redirect:/viewemployee";
    }

    @RequestMapping(value="/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewemployee";
    }
}
