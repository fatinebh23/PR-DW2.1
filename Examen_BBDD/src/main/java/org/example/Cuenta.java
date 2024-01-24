package org.example;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cuenta {
 private int accountid;
    private String iban;
    private Double balance;
   private int clientid;

    public Cuenta(String iban, String balance, String clientid) {
    }
}
