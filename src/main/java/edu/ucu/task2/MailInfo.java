package edu.ucu.task2;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class MailInfo {
    private Client client;
    private MailCode mailCode;
}
