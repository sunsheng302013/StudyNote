**简要描述：**

- 获取所有组件信息
读取的是src/main/resources下的app.json中配置的数据和matrix中安装包信息信息

**请求URL：**
- ` /snac/deploy/v1.0/app/get_all_app `

**请求方式：**
- GET

 **返回参数说明**

|参数名|类型|说明|备注|
|:-----  |:-----|:-----|:-----|
|name |String   |SNAC前端展示的app名字  ||
|id |String   SNAC后端定义的组件名字  ||
|installCondition |list   |组件依赖的场景名字  ||
|relation |String   |依赖关系 |OR/AND |
|isPublic |String   |是否是公共组件|true/false|
|matrixPdtName |String   |matrix中组件名称|组件安装包下description.json中path值，matrix用于标识是哪个组件|
|packageList|List<Map<String,String>>|app软件包信息||
|∟packageName|String|安装包名称||
|∟version|String|安装包版本|||

 **返回示例**

 ```
 {
  "code": "SUCCESS",
  "message": "operate success",
  "data": [
    {
      "name": "VCFC-Campus",
      "id": "APP_CAMPUS",
      "installCondition": [
        "DNE_CAMPUS"
      ],
      "relation": "OR",
      "isPublic": "false",
      "matrixPdtName": "VCFCCampus",
      "installStatus": "false",
      "packageList": [
        {
          "version": "E3103",
          "packageName": "VCFC_CAMPUS-E3103-MATRIX.zip"
        }
      ]
    },
    {
      "name": "VCFC-DC",
      "id": "APP_DC",
      "installCondition": [
        "DNE_DC"
      ],
      "relation": "OR",
      "isPublic": "false",
      "matrixPdtName": "VCFCDC",
      "installStatus": "false",
      "packageList": [
        {
          "version": "E3104",
          "packageName": "VCFC_DC-E3104-MATRIX.zip"
        }
      ]
    },
    {
      "name": "VCFC-WAN",
      "id": "APP_WAN",
      "installCondition": [
        "DNE_WAN"
      ],
      "relation": "OR",
      "isPublic": "false",
      "matrixPdtName": "VCFCWAN",
      "installStatus": "false",
      "packageList": [
        {
          "version": "E3102L23",
          "packageName": "VCFC-WAN-E3102L23.zip"
        }
      ]
    },
    {
      "name": "VCFC-NFVO",
      "id": "APP_NFVO",
      "installCondition": [
        "DNE_NFVO"
      ],
      "relation": "OR",
      "isPublic": "false",
      "matrixPdtName": "NFVOrchestrator",
      "installStatus": "false",
      "packageList": [
        {
          "version": "E3101H01",
          "packageName": "NFV_ORCHESTRATOR-HA-PACKAGE-E3101H01-new2.zip"
        }
      ]
    },
    {
      "name": "VDHCP Server",
      "id": "APP_VDHCP",
      "installCondition": [
        "DNE_CAMPUS",
        "DNE_DC"
      ],
      "relation": "OR",
      "isPublic": "true",
      "matrixPdtName": "vDHCPS",
      "installStatus": "false",
      "packageList": [
        {
          "version": "E1102-X64",
          "packageName": "vDHCPS-E1102-X64.zip"
        },
        {
          "version": "E1103",
          "packageName": "vDHCPS-E1103.zip"
        }
      ]
    },
    {
      "name": "Config Channel",
      "id": "APP_NMS",
      "installCondition": [
        "DNE_ANL_ENGINE"
      ],
      "relation": "OR",
      "isPublic": "true",
      "matrixPdtName": "imc",
      "installStatus": "false",
      "packageList": [
        {
          "version": "9.0.0",
          "packageName": "ConfigChannel-9.0.0.zip"
        }
      ]
    },
    {
      "name": "SeerAnalyzer",
      "id": "APP_SEERENGINE",
      "installCondition": [
        "DNE_ANL_ENGINE"
      ],
      "relation": "OR",
      "isPublic": "false",
      "matrixPdtName": "ITOA",
      "installStatus": "false",
      "packageList": []
    },
    {
      "name": "Oasis Platform",
      "id": "APP_OASIS",
      "installCondition": [
        "DNE_ANL_ENGINE",
        "DNE_CAMPUS"
      ],
      "relation": "AND",
      "isPublic": "false",
      "matrixPdtName": "oasis",
      "installStatus": "false",
      "packageList": []
    }
  ]
}

 ```



 **备注**

- 更多返回错误代码请看首页的错误代码描述

