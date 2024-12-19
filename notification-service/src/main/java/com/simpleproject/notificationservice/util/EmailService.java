package com.simpleproject.notificationservice.util;

import com.simpleproject.notificationservice.dto.OrderResponse;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(OrderResponse orderResponse) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // Set the email details
        helper.setTo(orderResponse.getUserEmail());
        helper.setSubject("Order submitted successfully placed");

        // Prepare the email body using the template
        Context context = new Context();
        context.setVariable("name", "Test");
        context.setVariable("orderItems", orderResponse.getItems());
        String htmlContent = templateEngine.process("email-template", context);

        helper.setText(htmlContent, true);

        // Send the email
        mailSender.send(mimeMessage);
    }
}
