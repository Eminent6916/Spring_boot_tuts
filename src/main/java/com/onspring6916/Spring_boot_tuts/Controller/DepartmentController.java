package com.onspring6916.Spring_boot_tuts.Controller;

import com.onspring6916.Spring_boot_tuts.entity.Department;
import com.onspring6916.Spring_boot_tuts.error.DepartmentNotFoundExeption;
import com.onspring6916.Spring_boot_tuts.service.DepartmentService;
import com.onspring6916.Spring_boot_tuts.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
//    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long Id) throws DepartmentNotFoundExeption {
        return departmentService.fetchDepartmentById(Id);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        return departmentService.deleteDepartmentByID(id);
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department ){
        return departmentService.updateDepartment(id, department);
    }
    @GetMapping("/departments/name/{name}")
    public  List<Department> fetchByName(@PathVariable("name") String name){
        return departmentService.fetchByName(name);
    }

}
