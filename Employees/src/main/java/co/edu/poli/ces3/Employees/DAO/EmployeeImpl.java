package co.edu.poli.ces3.Employees.DAO;

import co.edu.poli.ces3.Employees.Models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return  entityManager.find(Employee.class,id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        employee.setId(id);
        return entityManager.merge(employee);
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee e=entityManager.find(Employee.class,id);
        entityManager.remove(e);
        return e;
    }
}