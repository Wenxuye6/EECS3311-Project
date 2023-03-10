package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Utility class for druid_jdbc connection pooling
 */
public class JdbcUtils_Druid {

    static DataSource dataSource = new DruidDataSource();

    //try connect with DB
    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("druid-config.properties");
            Properties pt = new Properties();
            pt.load(in);

            dataSource = DruidDataSourceFactory.createDataSource(pt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Get Connected
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Release of resources
    public static void release(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
