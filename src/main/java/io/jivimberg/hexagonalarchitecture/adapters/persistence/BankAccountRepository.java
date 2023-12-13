package io.jivimberg.hexagonalarchitecture.adapters.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jivimberg.hexagonalarchitecture.application.domain.BankAccount;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.LoadAccountPort;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.SaveAccountPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
    BankAccountRepository connects the outgoing ports with the SpringDataBankAccountRepository
 */
@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {

    private static final String FILE_PATH = "bank-accounts.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Optional<BankAccount> load(Long id) {
        try {
            Resource resource = new ClassPathResource(FILE_PATH);
            File file = resource.getFile();
            List<BankAccount> accounts = objectMapper.readValue(file, new TypeReference<List<BankAccount>>() {});

            return accounts.stream().filter(acc -> acc.getId().equals(id)).findFirst();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void save(BankAccount bankAccount) {
        try {
            Resource resource = new ClassPathResource(FILE_PATH);
            File file = resource.getFile();
            List<BankAccount> accounts;

            if (!file.exists() || file.length() == 0) {
                accounts = new ArrayList<>();
            } else {
                accounts = objectMapper.readValue(file, new TypeReference<List<BankAccount>>() {});
            }

            // Check if account already exists
            Optional<BankAccount> existingAccount = accounts.stream()
                    .filter(acc -> acc.getId().equals(bankAccount.getId()))
                    .findFirst();

            if (existingAccount.isPresent()) {
                // Update existing account
                accounts.remove(existingAccount.get());
                accounts.add(bankAccount);
            } else {
                // Add new account
                accounts.add(bankAccount);
            }

            objectMapper.writeValue(file, accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
