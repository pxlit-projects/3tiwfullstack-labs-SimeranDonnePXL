package be.pxl.services.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String from;
    private String to;
    private String subject;
    private String message;
}