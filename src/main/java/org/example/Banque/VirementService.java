package org.example.Banque;

public interface VirementService {

    String virement(String iban, String ibanTo, int somme);
}
