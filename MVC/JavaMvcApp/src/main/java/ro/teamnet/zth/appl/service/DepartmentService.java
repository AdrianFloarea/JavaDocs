package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public interface DepartmentService {
    public List<Department> findAllDepartments();
}
