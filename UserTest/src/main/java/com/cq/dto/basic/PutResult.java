/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.basic;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月28日
 * @author chengq
 */
public class PutResult extends BaseResult {

    /** 文件id */
    private long fileId;
    /** oss bucketName */
    private String ossType;
    /** oss 文件的位置 */
    private String key;
    /** 文件名 */
    private String fileName;
    /** 原始文件名 */
    private String fileNameOriginal;
    /** 文件内容类型 */
    private String fileContentType;
    /** 文件大小 */
    private long fileSize;
    /** 文件所在文件夹下 */
    private String filePath;
    /** oss 会员id */
    private long userId;
    /** oss endpoint */
    private String endpoint;
    /** oss 下载连接 */
    private String downloadUrl;

    /**
     * @return the fileId
     */
    public long getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     *            要设置的 fileId
     */
    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the ossType
     */
    public String getOssType() {
        return ossType;
    }

    /**
     * @param ossType
     *            要设置的 ossType
     */
    public void setOssType(String ossType) {
        this.ossType = ossType;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            要设置的 key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     *            要设置的 fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileNameOriginal
     */
    public String getFileNameOriginal() {
        return fileNameOriginal;
    }

    /**
     * @param fileNameOriginal
     *            要设置的 fileNameOriginal
     */
    public void setFileNameOriginal(String fileNameOriginal) {
        this.fileNameOriginal = fileNameOriginal;
    }

    /**
     * @return the fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * @param fileContentType
     *            要设置的 fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    /**
     * @return the fileSize
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     *            要设置的 fileSize
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     *            要设置的 filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * @param endpoint
     *            要设置的 endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * @return the downloadUrl
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * @param downloadUrl
     *            要设置的 downloadUrl
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
