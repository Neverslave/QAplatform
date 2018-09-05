package route;

import com.jfinal.config.Routes;
import controller.MainController;

public class MainRoute extends Routes
{
    @Override
    public void config() {
        add("/main", MainController.class);

    }
}
