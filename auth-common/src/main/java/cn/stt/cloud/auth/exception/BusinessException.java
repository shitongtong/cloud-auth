package cn.stt.cloud.auth.exception;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String msg;
	private int code = 500;

	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BusinessException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public BusinessException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public BusinessException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
