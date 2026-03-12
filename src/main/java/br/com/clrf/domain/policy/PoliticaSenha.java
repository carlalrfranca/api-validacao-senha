package br.com.clrf.domain.policy;

import java.util.Optional;

public interface PasswordPolicy {

    Optional<String> passwordValidate(String password);
}
