package com.onspring6916.Spring_boot_tuts.service;

import com.onspring6916.Spring_boot_tuts.entity.Department;
import com.onspring6916.Spring_boot_tuts.error.DepartmentNotFoundExeption;

import java.util.List;

public interface DepartmentService {
  public Department updateDepartment(Long id, Department department);

  public  Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();

  public Department fetchDepartmentById(Long id) throws DepartmentNotFoundExeption;

  public String deleteDepartmentByID(Long id);

 public List<Department> fetchByName(String name);
}
