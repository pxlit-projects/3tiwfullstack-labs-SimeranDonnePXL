package be.pxl.services.Client;

import be.pxl.services.Model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.Notification;

@FeignClient(name = "notification-service") // -> naam van de service
public interface NotificationClient {
    @PostMapping("/notifiaction/")
    void notificationSendMessage(@RequestBody NotificationRequest notificationRequest);
}
