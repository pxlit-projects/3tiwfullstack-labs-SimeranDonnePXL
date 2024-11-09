package be.pxl.services.Service;

import be.pxl.services.Controller.Request.NotificationRequest;
import be.pxl.services.Domain.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    public void sendMessage(NotificationRequest notification){
        log.info("Receiving notification...");
        log.info("Sending... {}", notification.getMessage());
        log.info("TO {}", notification.getTo());
    }
}
