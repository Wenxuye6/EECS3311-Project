package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtils_Druid;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * General database operations
 */
public abstract class BaseDAO<T> {

    //Instantiates the object runner of the QueryRunner class
    private final QueryRunner runner = new QueryRunner();

    //Instantiate the class object clazz
    private final Class<T> clazz;

    //Get the generic type in the parent class inherited by the current BaseDAO subclass
    {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        Type[] types = paramType.getActualTypeArguments(); //The generic parameters of the parent class are obtained
        clazz = (Class<T>) types[0];
    }

    /**
     * General operations for adding, deleting and changing
     *
     * @param sql  The sql statement to be executed
     * @param args Several Object objects
     * @return >0 success == 0 failure
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils_Druid.getConnection();
        int count = 0;
        try {
            count = runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_Druid.release(conn, null, null);
        }
        return count;
    }

    /**
     * Querying a single piece of data
     *
     * @param sql  The sql statement to be executed
     * @param args Several Object objects
     * @return An object of the specified class
     */
    public T getBean(String sql, Object... args) {
        Connection conn = JdbcUtils_Druid.getConnection();
        T t = null;
        try {
            t = runner.query(conn, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_Druid.release(conn, null, null);
        }
        return t;
    }

    /**
     * Querying multiple pieces of data
     *
     * @param sql  The sql statement to be executed
     * @param args Several Object objects
     * @return Specify a collection of class objects
     */
    public List<T> getBeanList(String sql, Object... args) {
        Connection conn = JdbcUtils_Druid.getConnection();
        List<T> list = null;
        try {
            list = runner.query(conn, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_Druid.release(conn, null, null);
        }
        return list;
    }

    /**
     * @param sql  The sql statement to be executed
     * @param args Several Object objects
     * @return Each piece of data obtained is stored in an array
     */
    public List<Object[]> getArrayList(String sql, Object... args) {
        Connection conn = JdbcUtils_Druid.getConnection();
        List<Object[]> list = null;
        try {
            list = runner.query(conn, sql, new ArrayListHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_Druid.release(conn, null, null);
        }
        return list;
    }
}
