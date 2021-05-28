package com.fierew.adminx.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xuyang
 */
@Component
@Slf4j
public class InitDataBase {
    @Value(value = "${datasource.username}")
    private String userName;
    @Value(value = "${datasource.password}")
    private String password;
    @Value(value = "${datasource.url}")
    private String connection;

    @PostConstruct
    public void init() {
        // 创建ScriptRunner，用于执行SQL脚本，如果想要初始化后创建数据库，那么一开始在此处初始化的时候需要连接一个已经存在的数据。
        try(Connection conn = DriverManager.getConnection(connection, userName, password);){
            log.info("正在初始化sql脚本........");
            conn.prepareStatement("");
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            // 执行SQL脚本
            runner.runScript(Resources.getResourceAsReader("database/schema-mysql.sql"));
            log.info("初始化完成!");
        }catch (Exception e){
            log.error("init sql failed!",e);
        }
    }
}
