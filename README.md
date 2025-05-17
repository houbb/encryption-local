# encryption-local

[encryption-local](https://github.com/houbb/encryption-local) 一个离线版本的金融敏感信息加解密工具，用于数据库敏感信息存储。

创作目的：为金融敏感数据，提供一个简单易用的离线加解密工具。加密机服务可以在此基础上很容易的实现。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/encryption-local/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/encryption-local)
[![Build Status](https://www.travis-ci.org/houbb/encryption-local.svg?branch=master)](https://www.travis-ci.org/houbb/encryption-local?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/encryption-local/badge.svg?branch=master)](https://coveralls.io/github/houbb/encryption-local?branch=master)

## 特性

- 身份证加解密

- 地址加解密

- 姓名加解密

- 邮箱加解密

- 手机号加解密

- 银行卡加解密

- 密码加解密

## 项目推荐

下面是一些日志、加解密、脱敏安全相关的库推荐：

| 项目                                                                    | 介绍                    |
|:----------------------------------------------------------------------|:----------------------|
| [sensitive-word](https://github.com/houbb/sensitive-word)             | 高性能敏感词核心库             |
| [sensitive-word-admin](https://github.com/houbb/sensitive-word-admin) | 敏感词控台，前后端分离           |
| [sensitive](https://github.com/houbb/sensitive)                       | 高性能日志脱敏组件             |
| [auto-log](https://github.com/houbb/auto-log)                         | 统一日志切面组件，支持全链路traceId |
| [encryption-local](https://github.com/houbb/encryption-local)         | 离线加密机组件               |
| [encryption](https://github.com/houbb/encryption)         | 加密机标准API+本地客户端        |
| [encryption-server](https://github.com/houbb/encryption-server)        | 加密机服务                 |

# 变更日志

> [变更日志](CHANGELOG.md)

# 快速开始 

## 需要 

jdk1.7+

maven 3.x+

## maven 引入 

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>encryption-local-core</artifactId>
    <version>1.2.0</version>
</dependency>
```

## 方法概览

常见方法都在 `EncryptionLocalUtil#xxx` 工具类中可见。

### 加密

| 方法                | 说明    |
|:------------------|:------|
| addressEncrypt    | 地址加密  |
| nameEncrypt       | 姓名加密  |
| emailEncrypt      | 邮箱加密  |
| phoneEncrypt      | 手机号加密 |
| idCardEncrypt     | 身份证加密 |
| bankCardNoEncrypt | 银行卡加密 |
| passwordEncrypt   | 密码加密  |

统一入参：`(text, salt)` text 为待加密的内容, salt 为秘钥。v1.1.0 支持不带 salt 的方法。

统一出参：`CommonEncryptResponse` 对象，有 3 个属性：

| 属性 | 说明 |
|:---|:---|
| cipher | 密文 |
| mask | 掩码 |
| hash | 摘要 |

### 解密

| 方法                | 说明    |
|:------------------|:------|
| addressDecrypt    | 地址解密  |
| nameDecrypt       | 姓名解密  |
| emailDecrypt      | 邮箱解密  |
| phoneDecrypt      | 手机号解密 |
| idCardDecrypt     | 身份证解密 |
| bankCardNumDecrypt | 银行卡解密 |
| passwordDecrypt   | 密码解密  |

统一入参：`cipher` 为加密之后的密文字符串

统一出参：解密之后的明文字符串

## 使用

用法都是类似的，此处以手机号为例：

```java
final String email = "18888888888";
final String salt = "99886622";

CommonEncryptResponse response = EncryptionLocalUtil.phoneEncrypt(email, salt);
String cipher = response.getCipher();
String mask = response.getMask();
String hash = response.getHash();
Assert.assertEquals("08276740AEC8AAC11C6D0F84184DE2B5", cipher);
Assert.assertEquals("188****8888", mask);
Assert.assertEquals("381FA900C0626D7D7E2DB185B3558166", hash);

// 解密
String plain = EncryptionLocalUtil.phoneDecrypt(cipher, salt);
Assert.assertEquals(email, plain);
```

其他的各种数据效果示例整理如下，秘钥统一使用 `99886622`。

注意：生产环境使用，**必须保证秘钥的复杂性（建议不低于 10 位）**。

| 类别  | 明文                      | 秘文 | 掩码 | 摘要 |
|:----|:------------------------|:---|:---|:---|
| 地址  | 太平洋比基尼海滩比奇堡镇贝壳街124号的波萝屋 | D8D9E99FB8286107C2F75325C0B9046CF335EE4AC4FCD3F27E0D6BFD8B3DBF39440A3D69422A3AF933576798CF3860F330F288E196CEACB22CCCDA0623B94355 | `太平洋比基尼*************的波萝屋` | 31912515337902B8A3CC1CBDB5772358 |
| 姓名  | 海绵宝宝                    | 91AF56071FA8830391144DBEAE3967DA | `海**宝` | 94B221D98E0EF588B5304A88752DC6C7 |
| 邮箱  | haimian@baobao.com      | 15768CD9C0E70E2C798451E7982C8877DF991568ECD7BC3E1A9E9AD72455B085 | `hai****@baobao.com` | 4C651B4CDACA3CFA4876277B678282A9 |
| 手机  | 18888888888             | 08276740AEC8AAC11C6D0F84184DE2B5 | `188****8888` | 381FA900C0626D7D7E2DB185B3558166 |
| 身份证 | 330781198509079479      | 74101E0AAF25796680E40F3198D1AEFBC00E25FD8316F40CE90B425338894A42 | `330781*********479` | 2C7E7A814C36DE11EF01F39C35CECF12 |
| 银行卡 | 4427290920309717        | 288D5EC5432203677D3714E9A270F9998AC04BF65E5A36C6773187A4239D05EE | `442729******9717` | DE550BAF362B3EF640FF5AEC7D6E2F38 |
| 密码  | 123456                  | 8B208237BEB2E6A4390E7128E5E000D7 | `******` | FEB408A10822A55A939E8E38A6612515 |

> 完整例子参考 [EncryptionLocalUtilTest.java](https://github.com/houbb/encryption-local/blob/master/encryption-local-test/src/test/java/com/github/houbb/encryption/local/test/EncryptionLocalUtilTest.java)

## 引导类

为了便于用于拓展，加密支持通过引导类 `EncryptionLocalBs` 灵活指定配置。

### 配置

EncryptionLocalBs 中支持用户自定义下列配置。

| 属性 | 说明 | 默认值 |
|:---|:---|:---|
| salt | 秘钥 | null |
| hash | 哈希策略 | md5 |
| secret | 加密策略 | aes |

在指定秘钥之后，其他方法不再需要传递秘钥。

方法和工具类中一致。

### 例子

```java
EncryptionLocalBs localBs = EncryptionLocalBs.newInstance();

// 加密
CommonEncryptResponse encryptResponse = localBs.encrypt("123456", EncryptTypeEnum.PASSWORD.getCode());
Assert.assertEquals("CommonEncryptResponse{cipher='8B208237BEB2E6A4390E7128E5E000D7', mask='******', hash='FEB408A10822A55A939E8E38A6612515'}", encryptResponse.toString());

// 解密
String plainText = localBs.decrypt(encryptResponse.getCipher(), EncryptTypeEnum.PASSWORD.getCode());
Assert.assertEquals("123456", plainText);
```

# ROAD-MAP

- [ ] 允许用户自定义实现策略

- [ ] 基于注解的属性映射

@Address  

_cipher _mask _hash

数据库写入的正向处理，读取的反向处理
