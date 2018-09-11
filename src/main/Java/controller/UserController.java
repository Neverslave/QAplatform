package controller;

import com.jfinal.core.Controller;
import service.UserService ;
public class UserController extends Controller {

    //登陆界面
    public void  index(){
     render("/WEB-INF/layui/views/login.html");
    }
     UserService userService;
    //登录校验
    public void check(){
        }


}
