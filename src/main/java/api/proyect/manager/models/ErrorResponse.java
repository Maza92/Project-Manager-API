package api.proyect.manager.models;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorResponse {
  private String message;
  private int status;
  private long timestamp;
}
