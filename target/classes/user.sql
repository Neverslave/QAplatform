

#sql("getpwd")
select pwd  from user where account = ?
#end

#sql("findUser")
select  accound from user where  account = ?
#end

#sql("addUser")
update  user set
 #for(x : cond)
   #(x.key) = #para(x.value)
  #end
#end


#sql("updatepwd")
update user  set pwd = ?
WHERE account= ?
#end

#sql ("updateLogintime")
update  user  set logintime = ?
WHERE account= ?
#end

#sql("getUser")
select * from user where account = ?
#end

#sql("getAllUsers")
select  * from  user
#end
