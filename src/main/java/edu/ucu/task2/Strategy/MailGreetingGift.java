package edu.ucu.task2.Strategy;

import edu.ucu.task2.Client;

public class MailGreetingGift implements MailGreeting{
    @Override
    public String greetClient(Client client){
        return "We have a gift for you, " + String.valueOf(client.getName()) + "!";
    }
}