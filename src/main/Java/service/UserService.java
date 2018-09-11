package service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
     // 获取用户
    public User getUser(String account){
        String sql = Db.getSql("user.getUser");
        User user =User.dao.findFirst(sql);
        return  user ;
    }

        //登录校验
     public boolean loginCheck(String account,String pwd){
         List password;
         String sql = Db.getSql("user.getpwd");
         password = Db.find(sql,account);
          if(password.get(0)==pwd) {
              return true;
          }
          return  false;
     }

     //检查登录用户是否存在
     public boolean checkExist(String account){
         String  sql =  Db.getSql("user.getUser");
         return  Db.queryBoolean(sql);
    }
     //增加用户
    public  boolean addUser(User user){
         if(checkExist(user.getAccount())) {
             Record record = user.toRecord();
             Db.save("user", record);
            return true;
         }
         return  false;
    }

        //删除用户
    public   boolean deleteUser(User user){
         Record record = user.toRecord();
         if(checkExist(user.getAccount())){
             Db.delete("user",record);
             return  true ;
         }
         return  false;
    }
    //更新登陆时间
    public void  updateLoginTime(User user){
         String sql = Db.getSql("user.updateLogintime");
         Db.update(sql,user.getAccount(), new Timestamp(new Date().getTime()));
    }

    //更新密码
    public void updatepwd(User user ,String pwd){
         String sql = Db.getSql("user.updatepwd");

         Db.update(sql,user.getAccount(),pwd);

    }
    //查询所有用户
    public  List<User> getAllUsers(){
     List<User> users =  new ArrayList<>();
       String sql =  Db.getSql("user.getAllUsers");
       users = User.dao.find(sql);
       return users ;
    }




}
