package com.sapati.a_common.repositories;

import com.sapati.a_common.entities.Transaction;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TransactionRepository extends CrudRepository<Transaction,Long> {
    Optional<Transaction> findByLenderName(String username);
    Optional<Transaction> findByBorrowerName(String username);

    @Query("UPDATE public.\"Transaction\" SET paymentStatus = : msg WHERE transactionId = :id")
    void setPendingStatus(Long id,String msg);
}

