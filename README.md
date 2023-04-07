### biz_config_a

#### 打包
```shell script
mvn clean package -Dmaven.test.skip=true
```


记得将Dockerfile文件内容修改为对应的 Dockerfile-none-envoy 和 Dockerfile-have-envoy
```shell
# 有envoy
docker build -t biz-a-service:1.0.0-have-envoy .
# 有envoy【本地调试版本】
docker build -t biz-a-service:1.0.0-have-envoy-debug .
# 有envoy【链路数据】
docker build -t biz-a-service:1.0.0-have-envoy-trace .
# 没有envoy
docker build -t biz-a-service:1.0.0-none-envoy .
```

```shell
# 有envoy
docker run -d --name biz-a-service -p 18000:18000 biz-a-service:1.0.0-have-envoy
# 没有envoy
docker run -d --name biz-a-service -p 18000:18000 biz-a-service:1.0.0-none-envoy
```
