package com.patterns;

public class ConfigurationManager {
    private static ConfigurationManager instance; //Статическая переменная, хранящая единственный экземпляр класса
    private String appName;
    private String logLevel;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private ConfigurationManager() {
    }

    // Статический метод для получения единственного экземпляра
    public static ConfigurationManager getInstance() {

        //При первом вызове создает экземпляр,
        // а при последующих возвращает существующий.

        if (instance == null) {
            instance = new ConfigurationManager();
            System.out.println("ConfigurationManager created");
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public void printConfiguration(){
        System.out.println("Название Application: " + appName + " уровень регистрации: " + logLevel);
    }
}