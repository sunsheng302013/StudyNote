/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.oss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.cq.common.enums.ResultCode;
import com.cq.common.exception.ServiceException;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月10日
 * @author chengq
 */
public class OssTest {

    private static final Integer CONNECTTIMEOU = 200;

    public static void main(String[] args) {
        String url = "http://jkyun.oss-cn-hangzhou.aliyuncs.com/longterm/666666/attachment/oa/533786325436629632/549717533711405952.jpg?Expires=4703642807&OSSAccessKeyId=LTAIh08vjrfC7HV0&Signature=YKabWBDiCiv6N%2FUjvHHoH2764OQ%3D";
        InputStream input = getInputStream(url);
        File file = new File("D:\\photocreator.jpg");
        try {
            file = inputstreamtofile(input, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file);
    }

    /**
     * 从oss上面获取文件流
     *
     * @param processDownloadUrl
     *            下载地址
     * @return inputstream
     */
    public static InputStream getInputStream(String processDownloadUrl) {
        // 取得文件流
        int code = 0;
        HttpURLConnection urlCon = null;
        try {
            URL url = new URL(processDownloadUrl);
            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setConnectTimeout(CONNECTTIMEOU);
            code = urlCon.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 文件下载失败
        if (code != HttpURLConnection.HTTP_OK) {
            throw new ServiceException(ResultCode.DOWNLOAD_FAIL);
        }
        // 得到文件流
        InputStream inputStream = null;
        try {
            inputStream = urlCon.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static File inputstreamtofile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        return file;
    }
}
