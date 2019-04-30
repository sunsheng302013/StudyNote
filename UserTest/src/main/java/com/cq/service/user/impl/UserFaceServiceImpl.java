/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cq.model.user.UserInfo;
import com.cq.service.user.UserFaceService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月26日
 * @author chengq
 */
@Service
public class UserFaceServiceImpl implements UserFaceService {

    private static final Integer BYTE_MAX = 8192;

    @Override
    public Long createUserFaceInfo(UserInfo user, MultipartFile jarFile) {
        File file = multipartFileToFile(jarFile);
        FileSystemResource resource = new FileSystemResource(file);
        System.out.println(resource);
        return null;
    }

    /**
     * file格式转换
     *
     * @author chengq
     * @param jarFile
     *            文件
     * @return file类型文件
     */
    public File multipartFileToFile(MultipartFile jarFile) {
        File f = null;
        try {
            if (jarFile == null || jarFile.getSize() <= 0) {
                jarFile = null;
            } else {
                InputStream ins = jarFile.getInputStream();
                f = new File(jarFile.getOriginalFilename());
                OutputStream os = new FileOutputStream(f);
                int bytesRead = 0;
                byte[] buffer = new byte[BYTE_MAX];
                while ((bytesRead = ins.read(buffer, 0, BYTE_MAX)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                ins.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
