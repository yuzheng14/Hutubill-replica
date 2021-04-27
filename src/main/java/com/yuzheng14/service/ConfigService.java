package com.yuzheng14.service;

import com.yuzheng14.dao.ConfigDAO;
import com.yuzheng14.entity.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author yuzheng14
 */
@Service
public class ConfigService {
    private final static String BUDGET ="budget";
    private final static String MYSQL_PATH ="mysqlPath";
    private final static String DEFAULT_BUDGET ="500";

    private final static ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
    private final static ConfigDAO configDAO;

    static {
        configDAO= context.getBean("configDAO",ConfigDAO.class);
        init();
    }

    private static void init(){
        init(BUDGET,DEFAULT_BUDGET);
        init(MYSQL_PATH,"");
    }

    private static void init(String key,String value){
        Config config=configDAO.getByKey(key);
        if (config==null){
            config=new Config();
            config.setKey(key);
            config.setValue(value);
            configDAO.add(config);
        }
    }

    public String get(String key){
        Config config=configDAO.getByKey(key);
        return config.getValue();
    }

    public void update(String key,String value){
        Config config=configDAO.getByKey(key);
        config.setValue(value);
        configDAO.update(config);
    }

    public static String getBudget() {
        return BUDGET;
    }

    public static String getMysqlPath() {
        return MYSQL_PATH;
    }

    public int getIntBudget(){
        return Integer.parseInt(get("budget"));
    }
}
