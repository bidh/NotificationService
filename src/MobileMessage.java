import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/MobileMessage")
public class MobileMessage {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() throws Exception{
        NexmoClient client = new NexmoClient.Builder().apiKey("f268c8ea").apiSecret("5luMxJibbPU7uPX7").build();
        String msg="You have a delivery to complete.";
        TextMessage message = new TextMessage("LMS ApS", "4542211932", msg);
        SmsSubmissionResponse response=null;

        response = client.getSmsClient().submitMessage(message);

        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            System.out.println(responseMessage);
        }
        return "Message sent successfully";
    }
}
