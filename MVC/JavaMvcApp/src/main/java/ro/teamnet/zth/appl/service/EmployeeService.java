package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public interface EmployeeService {

    public List<Employee> findAllEmployees();

    public Employee findOneEmployee(Long id);
}