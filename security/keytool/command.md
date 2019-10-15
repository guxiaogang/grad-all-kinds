### 构建自签名证书
1 生成本地数字证书
* keytool -genkeypair -keyalg RSA -keysize 2048 -sigalg SHA1withRSA -validity 36000 \
    -alias www.stu.com -keystore stu.keystore \
    -dname "CN=www.stu.com,OU=stu,O=stu,L=GZ,ST=GD,C=CN"
    

2 导出证书
* keytool -exportcert -alias www.stu.com -keystore stu.keystore -file stu.cer -rfc
* keytool -printcert -file stu.cer

3 迁移到行业标准格式 PKCS12
* keytool -importkeystore -srckeystore stu.keystore \
  -destkeystore stu.keystore -deststoretype pkcs12
* keytool -exportcert -alias www.stu.com \
  -keystore stu.keystore -file stu.p12 -rfc
* keytool -printcert -file stu.p12

### 构建CA签名证书

1 导出证书申请
* keytool -certreq -alias www.stu.com -keystore stu.keystore -file stu.csr -v

2 导入数字证书
* keytool -delete -alias www.stu.com -keystore stu.keystore
* keytool -importcert -trustcacerts -alias \
  www.stu.com -file stu.p12 -keystore stu.keystore