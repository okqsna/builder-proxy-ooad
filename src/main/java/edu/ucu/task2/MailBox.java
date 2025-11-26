package edu.ucu.task2;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<MailInfo> allMessagesInformation = new ArrayList<>();
    private MailSender mailSender = new MailSender();

    public void addMailInfo(MailInfo newInfo){
        allMessagesInformation.add(newInfo);
    }

    public void sendAll(){
        for(MailInfo msg: allMessagesInformation){
            mailSender.sendMail(msg);
        }
        allMessagesInformation.clear();
        
    }

}
