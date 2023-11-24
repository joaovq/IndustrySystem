package com.joaovq.utils.mock;

import com.joaovq.domain.Employer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployerMock {
    private static List<Employer> employerList = null;

    public static List<Employer> buildEmployersList() {
        if (employerList == null) {
            employerList = new ArrayList<>() {{
                add(
                        buildEmployer(
                                "Maria",
                                LocalDate.of(2000, 10, 18),
                                BigDecimal.valueOf(2009.44),
                                "Operador"
                        )
                );
                add(
                        buildEmployer(
                                "João",
                                LocalDate.of(1990, 5, 12),
                                BigDecimal.valueOf(2284.38),
                                "Operador"
                        )
                );
                add(
                        buildEmployer(
                                "Caio",
                                LocalDate.of(1961, 5, 2),
                                BigDecimal.valueOf(9836.14),
                                "Coordenador"
                        )
                );
                add(
                        buildEmployer(
                                "Miguel",
                                LocalDate.of(1988, 10, 14),
                                BigDecimal.valueOf(19119.88),
                                "Diretor"
                        )
                );
                add(
                        buildEmployer(
                                "Alice",
                                LocalDate.of(1995, 1, 5),
                                BigDecimal.valueOf(2234.68),
                                "Recepcionista"
                        )
                );
                add(
                        buildEmployer(
                                "Heitor",
                                LocalDate.of(1999, 11, 19),
                                BigDecimal.valueOf(1582.72),
                                "Operador"
                        )
                );
                add(
                        buildEmployer(
                                "Arthur",
                                LocalDate.of(1993, 3, 31),
                                BigDecimal.valueOf(4071.84),
                                "Contador"
                        )
                );
                add(
                        buildEmployer(
                                "Laura",
                                LocalDate.of(1994, 7, 8),
                                BigDecimal.valueOf(3017.45),
                                "Gerente"
                        )
                );
                add(
                        buildEmployer(
                                "Heloísa",
                                LocalDate.of(2003, 5, 24),
                                BigDecimal.valueOf(1606.85),
                                "Eletricista"
                        )
                );
                add(
                        buildEmployer(
                                "Helena",
                                LocalDate.of(1996, 9, 2),
                                BigDecimal.valueOf(2799.93),
                                "Gerente"
                        )
                );
            }};
            return employerList;
        }
        return employerList;
    }

    public static Employer buildEmployer(
            String name,
            LocalDate birth,
            BigDecimal salary,
            String role
    ) {
        return new Employer(
                name == null ? "João" : name,
                birth == null ? LocalDate.now() : birth,
                salary,
                role
        );
    }
}
