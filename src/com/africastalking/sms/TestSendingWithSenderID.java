package com.africastalking.sms;

import com.africastalking.SmsService;
import com.africastalking.AfricasTalking;

import java.util.List;
import java.io.IOException;

public class TestSendingWithSenderID
{
    public static void main(String[] args)
    {
        /* Set your app credentials */
        String USERNAME = "eriq";
        String API_KEY = "2a3726643e6f226ba32aedb607145a042f1c8f254a101d58f679a6fe2f7df6b1";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the SMS service */
        SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

        /* Set the numbers you want to send to in international format */
        String[] recipients = new String[] {
                "+254702080051"
        };

        /* Set your message */
        String message = "We are lumberjacks. We sleep all day and code all night";

        /* Set your shortCode or senderId */
        String from = null; // or "ABCDE"

        /* That’s it, hit send and we’ll take care of the rest */
        try {
            List<Recipient> response = sms.send(message, from, recipients, true);
            for (Recipient recipient : response) {
                System.out.print(recipient.number);
                System.out.print(" : ");
                System.out.println(recipient.status);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
