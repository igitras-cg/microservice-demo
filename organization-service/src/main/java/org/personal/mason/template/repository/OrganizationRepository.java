package org.personal.mason.template.repository;

import org.personal.mason.template.model.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationRepository {

    @PostConstruct
    private void init() {
        this.add(new Organization("Microsoft", "Redmond, Washington, USA"));
        this.add(new Organization("Oracle", "Redwood City, California, USA"));
    }

    private List<Organization> organizations = new ArrayList<>();

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size() + 1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (organization.isPresent())
            return organization.get();
        else
            return null;
    }

    public List<Organization> findAll() {
        return organizations;
    }
}
