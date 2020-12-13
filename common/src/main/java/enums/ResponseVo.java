package enums;

import lombok.Data;

/**
 * 响应体
 * @author 9527
 * @version 1.0
 * @date 2020-10-30 11:19
 */
@Data
public class ResponseVo {

    private Integer code;
    private String msg;
    private Object data;

    /**
     * 手动设置返回vo
     */
    public ResponseVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 默认返回成功的状态码，数据对象
     */
    public ResponseVo(Object data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMessage();
        this.data = data;
    }

    /**
     *返回指定状态码，数据对象
     */
    public ResponseVo(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        this.data = data;
    }

    /**
     *只返回指定状态码
     */
    public ResponseVo(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }
}
