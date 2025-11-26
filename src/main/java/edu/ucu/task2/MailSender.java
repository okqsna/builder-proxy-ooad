package edu.ucu.task2;

import java.util.HashMap;
import java.util.Map;
import edu.ucu.task2.Strategy.*;

public class MailSender {
    private static final Map<MailCode, MailGreeting> greetingTypes = new HashMap<>();

    static {
        greetingTypes.put(MailCode.GIFT_LETTER, new MailGreetingGift());
        greetingTypes.put(MailCode.BIRTHDAY_GREETING, new MailGreetingBirthday());
    }

    public void addGreeting(MailCode greeting_name, MailGreeting greeting){
        greetingTypes.put(greeting_name, greeting);
    }

    public void sendMail(MailInfo information){
        MailGreeting mail = greetingTypes.get(information.getMailCode());
        String message = mail.greetClient(information.getClient());

        System.out.println(message);
    }

}
