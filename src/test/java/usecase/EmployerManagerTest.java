package usecase;

import com.joaovq.domain.Employer;
import com.joaovq.usecase.EmployerManager;
import com.joaovq.utils.mock.EmployerMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class EmployerManagerTest {

    private final EmployerManager employerManager = new EmployerManager();

    @Test
    void shouldInsertEmployer() {
        //given
        Employer employer = EmployerMock.buildEmployer(
                "João Queiroz",
                null,
                BigDecimal.valueOf(5678.90),
                "Zelador"
        );
        //when
        employerManager.insert(employer);
        //then
        Assertions.assertEquals(1, employerManager.getEmployers().size());
        Assertions.assertEquals("João Queiroz", employerManager.getEmployers().get(0).getName());
    }

    @Test
    void shouldGetEmployers() {
        // given
        List<Employer> employers = EmployerMock.buildEmployersList();
        employerManager.insertAll(employers);
        // when
        List<Employer> employerList = employerManager.getEmployers();
        //then
        Assertions.assertEquals(employers, employerList);
    }

    @Test
    void shouldDeleteEmployerByName() {
//        given
        employerManager.insertAll(EmployerMock.buildEmployersList());
//        when
        String key = "João";
        employerManager.deleteEmployerByName(key);
//        then
        Assertions.assertFalse(
                employerManager.getEmployers()
                        .stream()
                        .anyMatch(employer -> Objects.equals(employer.getName(), key))
        );
    }
}
