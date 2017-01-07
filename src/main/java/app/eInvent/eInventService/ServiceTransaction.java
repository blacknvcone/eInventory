package app.eInvent.eInventService;

/**
 * Created by blacknvc on 04/01/2017.
 */

import app.eInvent.eInventController.ProductControllers;
import app.eInvent.eInventDAO.ProductDAO;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.eInvent.eInventDAO.TransactionDAO;
import app.eInvent.eInventModel.Transaction;

import java.util.List;

@Service
public class ServiceTransaction {

   // @Autowired
   private ServiceProduct servPro;
   private TransactionDAO transDAO;
   private Transaction trans;

    //Add Transaction
    public void addTrans(JSONObject data){

        Transaction theTrans;

        JSONArray itemArr = data.getJSONArray("item_data");
        int intLoop = itemArr.length();

        //Looping Update Jumlah Stock + Save per transaction
        for (int i=0; i < intLoop; i++){
            //update stock first
            JSONObject item = new JSONObject(itemArr.get(i).toString());
            servPro.editStock(item.getLong("product_id"),item.getInt("product_quantity"));

            //SaveTransaction
            theTrans = new Transaction();
            theTrans.setSalesName(data.getString("sales_name"));
            theTrans.setProductId(item.getLong("product_id"));
            theTrans.setTotalItem(item.getInt("product_quantity"));

            //TransDateSoon

            transDAO.save(theTrans);

        }


    }

    //Delete Transaction
    //Will Be Added Soon

    //Update Transaction
    //Will Be Added Soon
}
