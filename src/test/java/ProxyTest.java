
import edu.ucu.task3.ProxyImage;
import edu.ucu.task3.RealImage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    void testProxyCreatesRealImageLazily() {
        ProxyImage proxy = new ProxyImage("ooad.png");

        assertNull(getRealImage(proxy));
        proxy.display();
        assertNotNull(getRealImage(proxy));
    }

    private RealImage getRealImage(ProxyImage proxy) {
        try {
            var field = ProxyImage.class.getDeclaredField("realImage");
            field.setAccessible(true);
            return (RealImage) field.get(proxy);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    void testDisplayDoesNotCreateTwice() {
        ProxyImage proxy = new ProxyImage("ooad.png");

        proxy.display();
        RealImage first = getRealImage(proxy);
        proxy.display();
        RealImage second = getRealImage(proxy);
        assertSame(first, second);
    }
}
