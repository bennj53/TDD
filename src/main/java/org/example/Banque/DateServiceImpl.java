package org.example.Banque;

import java.time.LocalDateTime;

public class DateServiceImpl implements DateService{
    @Override
    public LocalDateTime getDateNow() {
        return LocalDateTime.now();
    }
}
