package controller;

import com.jfinal.core.Controller;


public class BaseController  extends Controller {

    public void index(){
        render("/index.jsp");

    }

}
