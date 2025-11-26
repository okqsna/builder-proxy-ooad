package edu.ucu.task2.Strategy;

import edu.ucu.task2.Client;

public class MailGreetingBirthday implements MailGreeting{
    @Override
    public String greetClient(Client client){
        return "Happy birthday, " + String.valueOf(client.getName()) + "!";
    }
}
