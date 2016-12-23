package app.eInvent.eInventController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
@Controller
public class AuthControllers {

    /**
     * Digunakan untuk melakukan eksekusi request mapping dari http://localhost:8090/auth/sigin
     * @param webRequest
     * @return
     */
    @RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
    public String signin(WebRequest webRequest)
    {
        String postDataName = webRequest.getParameter("name");
        if(postDataName != null && !postDataName.isEmpty()) {
            //Kondisi dengan adanya data yang di post
            return "redirect:/dashboard";
        }
        else
        {
            //Kondisi tidak ada data yang dikirim
            return "redirect:/";
        }
    }
}
