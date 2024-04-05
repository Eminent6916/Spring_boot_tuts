package com.onspring6916.Spring_boot_tuts.repository;

import com.onspring6916.Spring_boot_tuts.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
//    public Department findAllByDepartmentName(String departmentName);
    @Query(value = "SELECT * FROM DEPARTMENT WHERE department_name = :departmentName", nativeQuery = true)
    public List<Department> findAllByDepartmentNameIgnoreCase(String departmentName);

}
