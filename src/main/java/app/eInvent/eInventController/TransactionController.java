package app.eInvent.eInventController;

/**
 * Created by blacknvc on 04/01/2017.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.awt.*;

@Controller
public class TransactionController {

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String index()
    {
        return "transactions/index";
    }

    @RequestMapping(value = "/transaction/submit", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String JSONParse(WebRequest webRequest)
    {
        return "Yeay :3";
    }
    //SaveTransaction
    //DeleteTransaction
    //UpdateTransaction


}
