package com.joaovq.usecase;

import com.joaovq.domain.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EmployerManager implements IEmployerManager {
    private final List<Employer> industryEmployers = new ArrayList<Employer>();
    ;

    @Override
    public void insertAll(List<Employer> newEmployers) {
        industryEmployers.addAll(newEmployers);
    }

    @Override
    public List<Employer> getEmployers() {
        return industryEmployers;
    }

    @Override
    public Set<String> getRoles() {
        return Set.copyOf(
                industryEmployers.stream().map(Employer::getRole).toList()
        );
    }

    @Override
    public void insert(Employer newEmployer) {
        industryEmployers.add(newEmployer);
    }

    @Override
    public void deleteEmployerByName(String name) {
        industryEmployers.removeIf(employer -> Objects.equals(employer.getName(), name));
    }
}
