package org.example.account;

public interface VirementService {

    String virement(String iban, String ibanTo, int somme);
}
