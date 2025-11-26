import edu.ucu.task3.ProxyImage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    void testProxyDisplayCanBeCalledTwice() {
        ProxyImage proxy = new ProxyImage("dummy.png");

        assertDoesNotThrow(proxy::display, "display() without error");
        assertDoesNotThrow(proxy::display, "display() without error");
    }
}
