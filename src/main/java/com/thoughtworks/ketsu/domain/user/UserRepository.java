package com.thoughtworks.ketsu.domain.user;

import java.util.Map;
import java.util.Optional;

public interface UserRepository {

    Optional<User> postUser(Map<String, Object> info);

    Optional<User> findById(long id);
}
