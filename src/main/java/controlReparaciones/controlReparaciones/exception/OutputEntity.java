/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlReparaciones.controlReparaciones.exception;

import static com.controlReparaciones.controlReparaciones.util.Response.INTERNALERROR;
import com.controlReparaciones.controlReparaciones.util.Response;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author gramirez25
 */

@Data
public class OutputEntity<T> {
    
    @JsonIgnore
    private HttpStatus code;
    private ArrayList<String> messages = new ArrayList<>();
    private Integer error = 0;
    private T data;

    public OutputEntity<T> success(Response response, T data) {
        this.code = mapStatus(response.getCode());
        this.messages.add(response.getKey());
        this.data = data;
        return this;
    }
    
    public OutputEntity<T> failed(Response response, T data) {
        this.error = 1;
        this.code = mapStatus(response.getCode());
        this.messages.add(response.getKey());
        this.data = data;
        return this;
    }
    
    public OutputEntity<T> failed(Response response, ArrayList<String> messages, T data) {
        this.error = 1;
        this.code = mapStatus(response.getCode());
        this.messages = messages;
        this.data = data;
        return this;
    }
    
    public OutputEntity<T> error() {
        this.error = 1;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
        this.messages.add(INTERNALERROR.getKey());
        this.data = null;
        return this;
    }
    
    
    private HttpStatus mapStatus(Integer code) {
        if (code == null) return HttpStatus.INTERNAL_SERVER_ERROR;

        switch(code) {
            case 200: return HttpStatus.OK;
            case 201: return HttpStatus.CREATED;
            case 404: return HttpStatus.NOT_FOUND;
            case 400: return HttpStatus.BAD_REQUEST;
            case 500: return HttpStatus.INTERNAL_SERVER_ERROR;
            case 409: return HttpStatus.CONFLICT;

            // Los códigos personalizados (los tratamos como BAD_REQUEST)
            case 1:
            case 3:
            case 4:
            case 5:
            case 10:
            case 11:
                return HttpStatus.BAD_REQUEST;

            case 2:
                return HttpStatus.OK;

            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    
}
