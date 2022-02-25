package org.shahi.ticketmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseDTO {

    private String message;
    private Object detail;

    public ResponseEntity<?> successModel(Object o) {
        RestResponseDTO r = new RestResponseDTO();
        r.setDetail(o);
        r.setMessage("SUCCESS");
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

}
