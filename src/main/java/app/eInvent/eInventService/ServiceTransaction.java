package app.eInvent.eInventService;

/**
 * Created by blacknvc on 04/01/2017.
 */

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.eInvent.eInventDAO.TransactionDAO;
import app.eInvent.eInventModel.Transaction;

import java.util.List;

@Service
public class ServiceTransaction {

    @Autowired
    private TransactionDAO transDAO;

    /**
     * Digunakan untuk melakukan input transaksi
     * @param transaction
     */
    public void add(Transaction transaction) {
        transDAO.save(transaction);
    }

    public List<Transaction> getAllTransaction(){
        return transDAO.findAll();
    }
}
