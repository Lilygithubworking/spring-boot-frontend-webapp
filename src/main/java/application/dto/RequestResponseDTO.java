package application.dto;

/**
 * Created by mj on 1/6/16.
 */
public class RequestResponseDTO {
    private String message;
    private Integer status;
    private Object data;
    private String nextCursor;

    public RequestResponseDTO() {
        status = 2011;
        message = "dummy Message";
    }

    @Override
    public String toString() {
        return "RequestResponseDTO{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                ", nextCursor='" + nextCursor + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }
}
