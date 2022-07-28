package co.edu.poli.ces3.Employees.Controllers;

import co.edu.poli.ces3.Employees.DAO.EmployeeDao;
import co.edu.poli.ces3.Employees.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "test")
    public String test(){
        return "Hola Spring Boot";
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
             return employeeDao.getEmployees();
    }
    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int id){
        return employeeDao.getEmployee(id);
    }

    @RequestMapping(value = "api/employee", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee e){
        return employeeDao.createEmployee(e);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee e){
        return employeeDao.updateEmployee(id, e);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable("id") int id){
        return employeeDao.deleteEmployee(id);
    }


}
