package com.joaovq.usecase;

import com.joaovq.domain.Employer;

import java.util.List;
import java.util.Set;

public interface IEmployerManager {
    void insertAll(List<Employer> newEmployers);
    List<Employer> getEmployers();
    Set<String> getRoles();
    void insert(Employer newEmployer);
    void deleteEmployerByName(String name);
}
