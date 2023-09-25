package com.sapati.a_common.repositories;

import com.sapati.a_common.entities.Borrow;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface BorrowerRepository extends CrudRepository<Borrow,Long> {
    Optional<Borrow> findByBorrowerName(String borrowerName);
    Optional<Borrow> findByRequestedAmount(Long requestedAmount);

    @Query("SELECT * FROM public.\"BorrowRequests\"  Where requested_amount <= :lenderBal")
    List<Borrow> findAllRequestsLessThanLenderBal(Long lenderBal);

}
