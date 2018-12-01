package it.discovery.book.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Hit {
    private String userName;

    private String ip;

    private String browser;

    private LocalDateTime viewed;

    private String applicationName;

    private String objectId;
}
