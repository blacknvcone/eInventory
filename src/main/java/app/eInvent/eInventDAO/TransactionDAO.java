package app.eInvent.eInventDAO;

/**
 * Created by blacknvc on 04/01/2017.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import app.eInvent.eInventModel.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Long>{
}
