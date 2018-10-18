package org.personal.mason.template.repository;

import org.personal.mason.template.model.Department;
import org.personal.mason.template.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentRepository {

    @PostConstruct
    private void init() {
        this.add(new Department(1L, "Development"));
        this.add(new Department(1L, "Operations"));
        this.add(new Department(2L, "Development"));
        this.add(new Department(2L, "Operations"));
    }

    private List<Department> departments = new ArrayList<>();

    public Department add(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
        return department.orElse(null);
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }
}
