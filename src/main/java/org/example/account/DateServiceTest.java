package org.example.account;

import java.time.LocalDateTime;

public class DateServiceTest implements DateService{
    @Override
    public LocalDateTime getDateNow() {
        return LocalDateTime.of(2023, 12, 21, 12, 00, 00, 000);
    }
}
