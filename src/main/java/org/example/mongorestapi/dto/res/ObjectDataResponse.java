package org.example.mongorestapi.dto.res;

public class ObjectDataResponse {

    private int status;
    public String message;
    private Boolean success;
    private Object data;

    // constructors
    public ObjectDataResponse() {};

    public ObjectDataResponse(int status, String message, Boolean success, Object data) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.data = data;
    };

    // getters and setters
    public int getStatus() {
        return status;
    };

    public void setStatus(int status) {
        this.status = status;
    };

    public String getMessage() {
        return message;
    };

    public void setMessage(String message) {
        this.message = message;
    };

    public Boolean getSuccess() {
        return success;
    };

    public void setSuccess(Boolean success) {
        this.success = success;
    };

    public Object getData() {
        return data;
    };

    public void setData(Object data) {
        this.data = data;
    };

}
