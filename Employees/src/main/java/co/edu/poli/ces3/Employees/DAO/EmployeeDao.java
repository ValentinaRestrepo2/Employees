package co.edu.poli.ces3.Employees.DAO;

import co.edu.poli.ces3.Employees.Models.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployees();

    Employee getEmployee(int id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    Employee deleteEmployee(int id);
}