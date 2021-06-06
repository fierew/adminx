# adminx Spring Boot 后台管理系统服务端

## 入门

使用IDEA安装依赖项

启动开发服务,

```bash
$ mvnw spring-boot:run
```

## 打包

在根目录运行,

```bash
$ mvnw clean package
```

## 运行JAR文件

输入命令

```
$ java -jar target/verification-0.0.1-SNAPSHOT.jar
```

## 优雅停止服务
```
$ cat application.pid | xargs kill
```