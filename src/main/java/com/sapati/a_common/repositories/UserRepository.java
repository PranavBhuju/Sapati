package com.sapati.a_common.repositories;

import com.sapati.a_common.entities.Person;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends CrudRepository<Person,Long> {
    Optional<Person> findByUserName(String username);
    Optional<Person> findByUserType(String userType);

    @Query("UPDATE public.\"Person\"  SET verification = true WHERE id = :userId")
    void updateVerification(Long userId);

    @Query("UPDATE public.\"Person\"  SET balance = :bal WHERE id = :userId")
    void updateBalance(Long userId,Long bal);

    @Query("UPDATE public.\"Person\" SET balance = : newBalance WHERE username = :username")
    void addBalance(String username, Long newbBalance);

    @Query("UPDATE public.\"Person\" SET balance = : newBalance WHERE id = :id")
    void setBalance(Long id, Long newBalance);
}
