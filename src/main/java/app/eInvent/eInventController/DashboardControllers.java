package app.eInvent.eInventController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardControllers {

    /**
     * Digunakan untuk melakukan eksekusi dari request mapping http://localhost:8090/dashboard
     * @return
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard/index";
    }
}
