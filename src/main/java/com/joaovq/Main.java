package com.joaovq;

import com.joaovq.domain.Employer;
import com.joaovq.domain.Person;
import com.joaovq.usecase.EmployerManager;
import com.joaovq.utils.SalaryBusinessUtils;
import com.joaovq.utils.converter.BigDecimalConverter;
import com.joaovq.utils.mock.EmployerMock;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EmployerManager employerManager = new EmployerManager();
//      3.1  Inserindo todos os funcionários de uma vez
        employerManager.insertAll(EmployerMock.buildEmployersList());
//        3.2 Remover o funcionário "João" da lista
        employerManager.deleteEmployerByName("João");
//        3.3 Imprimir todos os funcionários
        printRequisite("3.3 Imprimir todos os funcionários");
        employerManager.getEmployers().forEach(
                employer -> System.out.println(employer.toString())
        );
//        3.4 Aumento de 10% para todos os funcionários
        employerManager.getEmployers().forEach(
                employer -> employer.setSalary(
                        increaseSalary(employer.getSalary(), 0.1)
                )
        );
//        3.5 Agrupar os funcionários em um MAP, sendo "função" como chave e valor "lista de funcionários"
        Set<String> roles = employerManager.getRoles();
        HashMap<String, List<Employer>> map = new HashMap<>();
        employerManager.getEmployers().forEach(
                employer -> {
                    if (map.get(employer.getRole()) == null) {
                        map.put(employer.getRole(), new ArrayList<>() {{
                            add(employer);
                        }});
                    } else {
                        map.get(employer.getRole()).add(employer);
                    }
                }
        );
        System.out.println("\n");
//        3.6 Imprimir os funcionários, agrupados por função (role)
        printRequisite("3.6 Imprimir os funcionários, agrupados por função (role)");
        map.forEach((role, employerList) -> {
            System.out.println(role);
            employerList.forEach(
                    (employer) -> {
                        System.out.println("\b\b" + employer);
                    }
            );
            System.out.println("\n");
        });
//        3.8  Imprimir os funcionários que fazem aniversário no mês 10 e 12
        printRequisite("3.8  Imprimir os funcionários que fazem aniversário no mês 10 e 12");
        Stream<Employer> employersFiltered = employerManager.getEmployers()
                .stream().filter(employer -> {
                    int monthBirth = employer.getBirth().getMonthValue();
                    return monthBirth == 12 || monthBirth == 10;
                });
        employersFiltered.forEach(
                System.out::println
        );
        System.out.println("\n");
//        3.9 Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade
        printRequisite("3.9 Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade");
        Optional<Employer> optional = employerManager.getEmployers().stream().max(Comparator.comparing(Person::getAge));
        Employer employerReturned = optional.orElseThrow(
                RuntimeException::new
        );
        System.out.println("Nome: " + employerReturned.getName() + ", Idade :" + employerReturned.getAge());
        System.out.println("\n");
//        3.10 Imprimir a lista de funcionários por ordem alfabética
        printRequisite("3.10 Imprimir a lista de funcionários por ordem alfabética");
        Stream<Employer> employerStream = employerManager.getEmployers()
                .stream()
                .sorted(Comparator.comparing(Person::getName));
        employerStream.forEach(System.out::println);
        System.out.println("\n");
//        3.11 Imprimir o total dos salários dos funcionários
        printRequisite("3.11 Imprimir o total dos salários dos funcionários");
        var totalSalaryIndustry = SalaryBusinessUtils.getTotalSalaryEmployers(employerManager.getEmployers());
        System.out.println(
                "SALÁRIO TOTAL DA INDÚSTRIA: " +
                BigDecimalConverter.toBigDecimalFormatLocale(totalSalaryIndustry, Locale.forLanguageTag("pt-BR"))
        );
        System.out.println("\n");
//        3.12 Imprimir o total dos salários dos funcionários
        printRequisite("3.12 Imprimir o total dos salários dos funcionários");
        employerManager.getEmployers().forEach(
                employer ->
                        System.out.println(
                                employer
                                        + ", Quantidade de salários mínimos: "
                                        + SalaryBusinessUtils
                                        .getQuantityMinSalaryAtSalaryValue(employer.getSalary())
                        )
        );
    }

    public static BigDecimal increaseSalary(BigDecimal actualSalary, Double percentInDecimal) {
        BigDecimal salaryIncrement = actualSalary.multiply(BigDecimal.valueOf(percentInDecimal));
        return actualSalary.add(salaryIncrement);
    }

    public static void printRequisite(String requisiteMessage) {
        System.out.println("Requisito: "+ requisiteMessage);
    }
}