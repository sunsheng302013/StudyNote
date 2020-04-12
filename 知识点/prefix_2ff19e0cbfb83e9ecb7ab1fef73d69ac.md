**简要描述：**

- 获取所有的安装包

**请求URL：**
- `/snac/deploy/v1.0/app/get_packages`

**请求方式：**
- GET

 **返回参数说明**

|参数名|类型|说明|备注|
|:-----  |:-----|:-----|:-----|
|name|String|软件包名||
|size|String|软件包大小||
|uploadTime|String|上传时间||
|path|String|软件包中path||
|version|String|软件包版本号|||

 **返回示例**

 ```
 {
  "code": "SUCCESS",
  "message": "operate success",
  "data": [
    {
      "name": "PackageName—VCFCCampus",
      "size": null,
      "uploadTime": null,
      "path": "VCFCCampus",
      "version": "version1"
    },
    {
      "name": "PackageName2-VCFCDC",
      "size": null,
      "uploadTime": null,
      "path": "VCFCDC",
      "version": "version2"
    },
    {
      "name": "PackageName4-VCFCWAN",
      "size": null,
      "uploadTime": null,
      "path": "VCFCWAN",
      "version": "version1"
    },
    {
      "name": "PackageName6-vDHCPS",
      "size": null,
      "uploadTime": null,
      "path": "vDHCPS",
      "version": "version2"
    },
    {
      "name": "PackageName8-imc",
      "size": null,
      "uploadTime": null,
      "path": "imc",
      "version": "version1"
    },
    {
      "name": "PackageName10-ITOA",
      "size": null,
      "uploadTime": null,
      "path": "ITOA",
      "version": "version2"
    },
    {
      "name": "PackageName12-dataengine",
      "size": null,
      "uploadTime": null,
      "path": "dataengine",
      "version": "version1"
    },
    {
      "name": "PackageName14-oasis",
      "size": null,
      "uploadTime": null,
      "path": "oasis",
      "version": "version2"
    },
    {
      "name": "PackageName17-NFVO",
      "size": null,
      "uploadTime": null,
      "path": "NFVOrchestrator",
      "version": "version2"
    }
  ]
}

 ```


 **备注**

- 更多返回错误代码请看首页的错误代码描述

