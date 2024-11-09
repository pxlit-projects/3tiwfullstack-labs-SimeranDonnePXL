package be.pxl.services.Controller;

import be.pxl.services.Controller.Request.NotificationRequest;
import be.pxl.services.Service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody NotificationRequest notification){
        notificationService.sendMessage(notification);
    }
}
