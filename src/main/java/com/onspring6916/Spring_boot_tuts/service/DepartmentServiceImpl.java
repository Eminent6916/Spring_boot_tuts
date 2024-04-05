package com.onspring6916.Spring_boot_tuts.service;

import com.onspring6916.Spring_boot_tuts.entity.Department;
import com.onspring6916.Spring_boot_tuts.error.DepartmentNotFoundExeption;
import com.onspring6916.Spring_boot_tuts.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long Id) throws DepartmentNotFoundExeption {
        Optional<Department> department = departmentRepository.findById(Id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundExeption("Department not found");
        }
        return department.get();
    }
    @Override
    public String deleteDepartmentByID(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted";
    }

    @Override
    public List<Department> fetchByName(String name) {
        return departmentRepository.findAllByDepartmentNameIgnoreCase(name);
    }

    @Override

    @Transactional
    public Department updateDepartment(Long id, Department department) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Received request to update department with ID {}: {}", id, department);
        try {
            Department depDB = departmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                depDB.setDepartmentName(department.getDepartmentName());
            }

            if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                depDB.setDepartmentCode(department.getDepartmentCode());
            }

            if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                depDB.setDepartmentAddress(department.getDepartmentAddress());
            }

            Department updatedDepartment = departmentRepository.save(depDB);
            logger.info("Department updated successfully: {}", updatedDepartment);
            return updatedDepartment;
        } catch (Exception e) {
            logger.error("Error updating department with ID {}: {}", id, e.getMessage());
            throw e;
        }
    }

}
