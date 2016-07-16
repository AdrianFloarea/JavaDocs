package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao=new DepartmentDao();

    @Override
    public List<Department> findAllDepartments() {
        return departmentDao.findAllDepartments();
    }
}
