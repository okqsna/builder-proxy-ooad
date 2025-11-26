import edu.ucu.task3.ProxyImage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {
    static class TestProxyImage extends ProxyImage {
        public boolean displayCalled = false;
        public TestProxyImage(String filename) {
            super(filename);
        }

        @Override
        public void display() {
            displayCalled = true;
        }
    }

    @Test
    void testDisplayCalled() {
        TestProxyImage proxy = new TestProxyImage("ooad.png");
        assertFalse(proxy.displayCalled);
        proxy.display();
        assertTrue(proxy.displayCalled);
        proxy.display();
        assertTrue(proxy.displayCalled);
    }
}
