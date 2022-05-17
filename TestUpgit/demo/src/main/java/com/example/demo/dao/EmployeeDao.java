package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface EmployeeDao {
    public List<Employee> employeeList();
    Employee findById(long id);
    void insert(Employee employee);
    void update(Employee employee);
    void delete(long id);
}
