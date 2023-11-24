package utils;

import com.joaovq.domain.Employer;
import com.joaovq.utils.SalaryBusinessUtils;
import com.joaovq.utils.mock.EmployerMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryBusinessUtilsTest {
    @Test
    void shouldReturnTotalSalary_8000() {
        //given
        List<Employer> employers = new ArrayList<>() {{
            add(
                    EmployerMock.buildEmployer(
                            "João",
                            null,
                            BigDecimal.valueOf(3000),
                            null
                    )
            );
            add(
                    EmployerMock.buildEmployer(
                            "João",
                            null,
                            BigDecimal.valueOf(5000),
                            null
                    )
            );
        }};
        // when
        BigDecimal actualTotalSalary = SalaryBusinessUtils.getTotalSalaryEmployers(employers);
        //then
        Assertions.assertEquals(BigDecimal.valueOf(8000),actualTotalSalary);
    }

    @Test
    void shouldGetQuantityMinSalary3() {
        //given
        Employer employer = EmployerMock.buildEmployer(
                "João",
                null,
                BigDecimal.valueOf(3636),
                null
        );
        // when
        Double quantityMinSalary = SalaryBusinessUtils.getQuantityMinSalaryAtSalaryValue(employer.getSalary());
        //then
        Assertions.assertEquals(3,quantityMinSalary);
    }
}
