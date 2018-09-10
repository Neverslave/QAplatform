package config;

import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.BaseController;
import controller.UserController;
import model._MappingKit;
import route.MainRoute;


public class Config extends JFinalConfig {

    /**
     *
     * @param me
     */
    @Override
    public void configConstant(Constants me){
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", true));
        me.setViewType(ViewType.JSP); //设置渲染方式为JSP
    }

    @Override
    public void configRoute(Routes me) {

       me.add(new MainRoute());
       me.add("/", BaseController.class);
       me.add("/user", UserController.class);
        // me.add("/", IndexController.class); //所有的根目录访问转到这个类 viewpath相对于webapp的位置。可以加到第三个参数。

    }

    @Override
    public void configEngine(Engine me) {
        //配置模板引擎

    }

    @Override
    public void configPlugin(Plugins me) {
        //配置外部引擎 数据库等
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath());//设置sql模板位置
        arp.addSqlTemplate("common.sql");
        _MappingKit.mapping(arp);
        //arp.addMapping("user", Blog.class);//表与model相关联 数据库映射需要在加入plugin前
        me.add(arp);





    }

    @Override
    public void configInterceptor(Interceptors me) {
        //配置全局！！拦截器每一个请求都拦截
    }

    @Override
    public void configHandler(Handlers me) {
        //接管所有的web请求，可以进行扩展
    }
}
