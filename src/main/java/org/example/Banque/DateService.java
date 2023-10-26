package org.example.Banque;

import java.time.LocalDateTime;

public interface DateService {
    LocalDateTime getDateNow();
    default LocalDateTime getDate(int annee, int mois, int jour, int heure, int minute, int seconde, int nanoSeconde){
        return LocalDateTime.of(annee, mois, jour,heure, minute, seconde, nanoSeconde);
    };
}
