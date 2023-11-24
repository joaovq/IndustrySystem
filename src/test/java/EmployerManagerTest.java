import com.joaovq.usecase.EmployerManager;
import com.joaovq.utils.mock.EmployerMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Objects;

public class EmployerManagerTest {

    private final EmployerManager employerManager = new EmployerManager();

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
