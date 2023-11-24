package com.joaovq.domain;


import com.joaovq.utils.converter.BigDecimalConverter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Employer extends Person {
    private BigDecimal salary;
    private String role;

    public Employer(String name, LocalDate birth, BigDecimal salary, String role) {
        super(name, birth);
        this.salary = salary;
        this.role = role;
    }

    public Employer(BigDecimal salary, String role) {
        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSalaryToLocale(Locale locale) {
        return BigDecimalConverter.toBigDecimalFormatLocale(this.salary, locale);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Funcionário { " +
                "nome = " + getName() +
                ", salário = " + getSalaryToLocale(Locale.forLanguageTag("pt-BR")) +
                ", função = '" + role + '\'' + ", data de nascimento = " +
                getBirthFormatted(null) +
                " }";
    }
}
