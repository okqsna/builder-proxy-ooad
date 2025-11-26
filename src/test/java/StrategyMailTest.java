import edu.ucu.Gender;
import edu.ucu.task2.Client;
import edu.ucu.task2.MailBox;
import edu.ucu.task2.MailCode;
import edu.ucu.task2.MailInfo;
import edu.ucu.task2.MailSender;
import edu.ucu.task2.Strategy.MailGreeting;
import edu.ucu.task2.Strategy.MailGreetingBirthday;
import edu.ucu.task2.Strategy.MailGreetingGift;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyMailTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream)); 
        outputStream.reset();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testMailGreetings() {
        Client c = new Client("Alice", 20, Gender.FEMALE);

        MailGreeting birthday = new MailGreetingBirthday();
        MailGreeting gift = new MailGreetingGift();

        assertEquals("Happy birthday, Alice!", birthday.greetClient(c));
        assertEquals("We have a gift for you, Alice!", gift.greetClient(c));
    }

    @Test
    void testMailSender() {
        Client c = new Client("Bob",25, Gender.MALE);
        MailSender sender = new MailSender();

        MailInfo info = MailInfo.builder()
                .client(c)
                .mailCode(MailCode.GIFT_LETTER)
                .build();

        sender.sendMail(info);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("We have a gift for you, Bob!"));
    }

    @Test
    void testMailBoxSendAll() {
        Client c1 = new Client("Tom", 30, Gender.MALE);
        Client c2 = new Client("Eva", 22, Gender.FEMALE);

        MailBox box = new MailBox();

        box.addMailInfo(MailInfo.builder()
                .client(c1)
                .mailCode(MailCode.BIRTHDAY_GREETING)
                .build());

        box.addMailInfo(MailInfo.builder()
                .client(c2)
                .mailCode(MailCode.GIFT_LETTER)
                .build());

        box.sendAll();

        String output = outputStream.toString();
        assertTrue(output.contains("We have a gift for you, Eva!"), "Gift not found");
    }


    @Test
    void testSenderAddCustomGreeting() {
        MailSender sender = new MailSender();

        sender.addGreeting(MailCode.BIRTHDAY_GREETING, client -> "Custom greeting!");

        Client c = new Client("Mark", 19, Gender.MALE);

        MailInfo info = MailInfo.builder()
                .client(c)
                .mailCode(MailCode.BIRTHDAY_GREETING)
                .build();

        sender.sendMail(info);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Custom greeting!"));
    }
}
