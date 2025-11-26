import edu.ucu.Gender;
import edu.ucu.task1.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void testUserBuilder() {
        User user = User.builder()
                .name("Ariana")
                .age(32)
                .gender(Gender.FEMALE)
                .weight(55.5)
                .height(165.0)
                .build();

        assertEquals("Ariana", user.getName());
        assertNotEquals(20, user.getAge());
        assertEquals(Gender.FEMALE, user.getGender());
        assertEquals(55.5, user.getWeight());
        assertEquals(165.0, user.getHeight());
    }
}

