package ru.itfbgroup.deleteservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class DatabaseDataService {

    private final JdbcTemplate jdbcTemplate;
    @Value("${app.limit}")
    private int limit;

    public void deleteOldData(LocalDateTime dateTime) {

        int count = countOldData(dateTime);
        log.info("Начинаем удаление " + count + " элементов");
        while (count > 0) {
            String SQL = "DELETE FROM data WHERE CTID IN (SELECT CTID FROM data " +
                    "WHERE (datetime < ?) LIMIT " + limit + ")";
            jdbcTemplate.update(SQL, dateTime);
            count -= 10000;
        }

        log.info("Удалено");
    }

    public int countOldData(LocalDateTime dateTime) {
        String query = "SELECT COUNT(*) FROM data WHERE datetime < ?";
        return jdbcTemplate.queryForObject(query, new Object[]{dateTime}, Integer.class);
    }
}
