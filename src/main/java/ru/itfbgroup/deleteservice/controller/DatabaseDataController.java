package ru.itfbgroup.deleteservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.itfbgroup.deleteservice.service.DatabaseDataService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DatabaseDataController {

    private final DatabaseDataService dataService;

    @DeleteMapping("/delete/{date}")
    public void deleteOldData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        dataService.deleteOldData(date);
    }
}
