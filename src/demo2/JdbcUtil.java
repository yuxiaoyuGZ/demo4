package demo2;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * JDBC工具类
 */
public final class JdbcUtil {

    //连接数据库的四个必要的属性
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    //加载资源文件中的数据库服务器属性
    static{
        try {
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("mysql.properties");//利用反射。可以是这个web应用中的任意一个类
            Properties props = new Properties();
            props.load(is);
            driver = props.getProperty("driver");//属性文件中driver的值是 com.mysql.jdbc.Driver
            url = props.getProperty("url");
//属性文件中url的值    jdbc:mysql://(可以写本机iP地址或者localhost或者127.0.0.1):3306/数据库名称 例子jdbc:mysql://192.168.1.101:3306/mydb1
            user = props.getProperty("user");//属性文件中user的值  数据库名称
            password = props.getProperty("password");//属性文件中password的值  数据库密码
    }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("加载资源文件失败");
        }
    } 
    //注册数据库服务器驱动
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("注册数据库驱动失败");
        }
    }

    //不想让外界通过new来创建工具类
    private JdbcUtil(){}

    //获取数据库连
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }

    //关闭Connection对象
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }

    //关闭ResultSet对象
    public static void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs = null;
            }
        }
    }

    //关闭Statement对象
    public static void close(Statement stmt){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                stmt = null;
            }
        }
    }
}