package app.eInvent.eInventDAO;

/**
 * Created by blacknvc on 04/01/2017.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import app.eInvent.eInventModel.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, Long>{
    @Query(value = "SELECT * FROM TRANSACTION T INNER JOIN PRODUCT P ON P.PRODUCT_ID = T.PRODUCT_ID ORDER BY T.TRANS_ID DESC", nativeQuery = true)
    List<Transaction> innerJoinTransaction();
}
