package demo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Statement;

public class Demo4 {
    /**
     * 查询所有员工
     */
    public void findAll(){
        //用局部变量，就算关闭了自已的连接，不会影响它人
        //用实例变量，就算关闭了自已的连接，也会影响它人        
        Connection conn = null;
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from emp";
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                int esal = rs.getInt("esal");
                Timestamp ehiredate = rs.getTimestamp("ehiredate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
                String strDate = sdf.format(new Date(ehiredate.getTime()));
                System.out.println(empno+" "+ename+" "+esal+" "+strDate);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有员工失败");
        }finally{
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(conn);
        }
    }
}

