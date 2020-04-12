**简要描述：**

- 获取组件可以选择部署的主机
从matrix获取主机节点的信息

**请求URL：**
- `/snac/deploy/v1.0/app/scale_target_hosts`

**请求方式：**
- GET

**请求参数说明**

|参数名|类型|说明|备注|
|:-----  |:-----|:-----|:-----|
|appName |String   |组件名称  |现在只支持两个组件：APP_CAMPUS，APP_DC|

 **返回参数说明**

|参数名|类型|说明|备注|
|:-----  |:-----|:-----|:-----|
|nodeId |String   |节点ID  ||
|nodeName |String   |节点名称  ||
|role |String   |节点类型|取值为Master和Worker，分别表示主节点和工作节点|
|status |String   |节点状态  |取值为ACTIVE、DOWN，分别表示节点正常或异常|
|hostIfNameList|List|物理网卡列表||
|∟hostIfName|String|物理网卡名称|||

**请求示例**
```
http://127.0.0.1:8080/snac/deploy/v1.0/app/scale_target_hosts?appName=APP_CAMPUS
```

 **返回示例**

 ```
 {
  "code": "SUCCESS",
  "message": "operate success",
  "data": [
    {
      "nodeId": "node4",
      "nodeName": "nodename4",
      "role": "Worker",
      "status": "ACTIVE",
      "hostIfNameList": [
        "eth11",
        "eth22",
        "eth22"
      ]
    }
  ]
}

 ```



 **备注**

- 更多返回错误代码请看首页的错误代码描述

