package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.User_SQL;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isep.acme.controllers.ResourceNotFoundException;
import com.isep.acme.model.User;

import java.util.Optional;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserRepository extends CrudRepository<User_SQL, Long> {

    @Override
    @Caching(evict = {
            @CacheEvict(key = "#p0.userId", condition = "#p0.userId != null"),
            @CacheEvict(key = "#p0.username", condition = "#p0.username != null") })
    <S extends User_SQL> S save(S entity);

    @Override
    @Cacheable
    Optional<User_SQL> findById(Long userId);

    @Cacheable
    default User getById(final Long userId){
        final Optional<User_SQL> optionalUser = findById(userId);

        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException(User.class, userId);
        }
        if (!optionalUser.get().isEnabled()) {
            throw new ResourceNotFoundException(User.class, userId);
        }
        return optionalUser.get();
    }

    @Cacheable
    Optional<User> findByUsername(String username);


}