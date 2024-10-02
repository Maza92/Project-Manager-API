package api.proyect.manager.model;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorResponse {
  private String message;
  private int status;
  private long timestamp;
}
