# we-pop

## 1. 获取源码
```
git clone https://github.com/fqliao/we-pop.git
```

## 2. 配置

### 2.1 证书配置
将区块链节点所在目录nodes/${ip}/sdk下的ca.crt、sdk.crt和sdk.key文件拷贝到项目src/main/resources目录。

### 2.2 配置文件设置
将src/main/resources目录下的applicationContext.xml配置实际的区块链节点信息。
```
    <list>
        <value>127.0.0.1:20200</value>
    </list>
```
**若是测试国密wepop，则将applicationContext.xml的国密开关`encryptType`为1。注意需要连接国密区块链节点。**

## 3. 编译
在项目根目录下运行：
```bash
bash wepop_build.sh
```
**若测试国密wepop，则运行：**
```bash
bash wepop_build.sh -g
```
编译成功后，生成dist目录，其中有部署合约脚本deploy.sh和调用合约脚本run.sh。

## 4. 运行

### 4.1 部署we-pop业务合约
在dist目录运行：
```
bash deploy.sh
```
合约部署成功后，生成核心的三个业务合约地址，并自动将三个业务合约地址拷贝到了application.properties中供we-pop使用。

### 4.2 运行we-pop业务合约接口
在dist目录下运行：
```
bash run.sh doTransaction
```
调用doTransaction接口以及getOrderDetailByAbBizNo接口。
```
bash run.sh setExchangeRate
```
调用setExchangeRate接口以及getExchangeRate接口。
