package ru.itfbgroup.deleteservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class DatabaseData {

    @Id
    private Long id;
    private LocalDateTime dateTime;
}
