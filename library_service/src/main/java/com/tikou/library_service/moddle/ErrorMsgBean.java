package com.tikou.library_service.moddle;

import java.io.Serializable;

/**
 * Created by Tikou on 2016/10/18.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：错误码返回
 * 参考：
 */

public class ErrorMsgBean implements Serializable {

    private static final long serialVersionUID = -8610440979394689380L;
    /**
     * code : 3400005
     * desc : Verify code send too many
     * timestamp : 1460431878014
     */

    private int code;
    private String desc;
    private long timestamp;


    public ErrorMsgBean() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorMsgBean(int code, String desc, long timestamp) {
        this.code = code;
        this.desc = desc;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorMsgBean{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
