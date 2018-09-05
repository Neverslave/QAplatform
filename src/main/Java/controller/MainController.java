package controller;

import com.jfinal.core.Controller;

public class MainController extends Controller {

 public void index(){
     render("/views/version.jsp");
    }

 public void getversion(){


 }
 public  void gete(){
     renderHtml("<h1>我知道</h1>");
 }

}
