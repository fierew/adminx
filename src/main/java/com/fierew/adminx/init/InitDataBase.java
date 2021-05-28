package com.fierew.adminx.init;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebListener;
import java.sql.*;

/**
 * @author xuyang
 */
@Component
@Slf4j
@WebListener
public class InitDataBase {
    @Value(value = "${spring.datasource.username}")
    private String userName;
    @Value(value = "${spring.datasource.password}")
    private String password;
    @Value(value = "${spring.datasource.url}")
    private String connection;

    @PostConstruct
    public void init() {
        // 创建ScriptRunner，用于执行SQL脚本，如果想要初始化后创建数据库，那么一开始在此处初始化的时候需要连接一个已经存在的数据。
        try(Connection conn = DriverManager.getConnection(connection, userName, password);){
            log.info("正在初始化sql脚本........");
            conn.prepareStatement("show tables");
            ScriptRunner runner = new ScriptRunner(conn);
            // 设置不自动提交
            runner.setAutoCommit(false);
            /*
             * setStopOnError参数作用：遇见错误是否停止；
             * （1）false，遇见错误不会停止，会继续执行，会打印异常信息，并不会抛出异常，当前方法无法捕捉异常无法进行回滚操作，
             * 无法保证在一个事务内执行； （2）true，遇见错误会停止执行，打印并抛出异常，捕捉异常，并进行回滚，保证在一个事务内执行；
             */
            runner.setStopOnError(true);

            /*
             * 按照那种方式执行 方式一：true则获取整个脚本并执行； 方式二：false则按照自定义的分隔符每行执行；
             */
            runner.setSendFullScript(false);


            runner.setErrorLogWriter(null);
            // 设置是否输出日志，null不输出日志，不设置自动将日志输出到控制台
            runner.setLogWriter(null);
            // 定义命令间的分隔符
            runner.setDelimiter(";");
            runner.setFullLineDelimiter(false);
            // 执行SQL脚本
            runner.runScript(Resources.getResourceAsReader("database/schema-mysql.sql"));
            log.info("初始化完成!");
        }catch (Exception e){
            log.error("init sql failed!",e);
        }
    }
}
