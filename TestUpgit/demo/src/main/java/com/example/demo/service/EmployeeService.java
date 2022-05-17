package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeDao{
    @Autowired
    EmployeeDao employeeDao;
    public List<Employee> employeeList() {
        return employeeDao.employeeList();
    }

    public void insert(Employee employee) {
        if(employee!=null){
            employeeDao.insert(employee);
        }
    }


    public void delete(long id) {
        if(id>0){
            if(employeeDao.findById(id)!=null){
                employeeDao.delete(id);
            }
        }
    }

    public void update(Employee employee) {
        employee.getId();
        if(employeeDao.findById(employee.getId())!=null){
            Employee employee1 = employeeDao.findById(employee.getId());
            if(employee.getName()!=null){
                employee1.setName(employee.getName());
            }
            if(employee.getAddress()!=null){
                employee1.setAddress(employee.getAddress());
            }
            employeeDao.update(employee1);
        }
    }
    public Employee findById(long id){
        if(employeeDao.findById(id)!=null){
            return employeeDao.findById(id);
        }
        return null;
    }


}
