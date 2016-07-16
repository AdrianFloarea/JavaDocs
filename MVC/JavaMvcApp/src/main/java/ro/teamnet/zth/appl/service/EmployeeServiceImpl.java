package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao=new EmployeeDao();

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee(Long id) {
        return employeeDao.getEmployeeById(id);
    }
}
