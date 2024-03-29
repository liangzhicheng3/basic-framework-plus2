package devtool.flyway;

import org.flywaydb.core.Flyway;
import org.junit.Test;

/**
 * 除了在springboot的yml配置文件配置flyway，启动时自动更新数据库为最新版本；
 *              还可以将spring.flyway.enable设置为false，之后通过代码执行clean、migrate、info、validate、baseline、repair等操作
 * @author liangzhicheng
 */
public class FlywayTool {

    static String URL = "jdbc:mysql://127.0.0.1:3306/basic_framework_plus2?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    static String USER = "root";
    static String PASSWORD = "admin";

    /**
     * 把整个库所有的表结构清空
     * @param
     */
    @Test
    public void clean(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.clean();
    }

    /**
     * 指数据库非空状态下使用flyway首先执行的命令，用于创建flyway_schema_history表
     * @param
     */
    @Test
    public void baseline(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.baseline();
    }

    /**
     * 把数据库表版本更新到最新，自动检查数据库脚本是否有变化，如果有变化，则执行脚本，更新数据库版本，
     *              如果数据库初始状态是空库，则会自动创建flyway_schema_history表，用于存储数据库操作的版本记录，
     *              只要数据库脚本有变化，都需要执行此命令
     * @param
     */
    @Test
    public void migrate(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.migrate();
    }

    /**
     * 打印flyway_schema_history中记录信息
     * @param
     */
    @Test
    public void info(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.info();
    }

    /**
     * 指验证当前数据库是否最新版本，或者已经Apply的Migrations是否有变更，Flyway是默认是开启验证，
     *              也就是说已经执行过的sql文件是否被修改过，如果有，执行mvn flyway:validate会输出ERROR错误
     * @param
     */
    @Test
    public void validate(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.validate();
    }

    /**
     * Repair会修复Metadata表的错误，通常有两种用途：
     *              1.移除失败的Migration记录，该问题只是针对不支持DDL事务的数据库
     *              2.重新调整已经应用的Migratons的Checksums值
     * @param
     */
    @Test
    public void repair(){
        Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
        flyway.repair();
    }

}
