/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.APIforSMS;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author kartik
 */
public class APIforSMS {
    
    public static final String ACCOUNT_SID = "ACb58703f172a26aff558eed1e726994fe";
    public static final String AUTH_TOKEN = "96b00320fc18a6aef176ae10c71ee582";
    public static final String fromNo = "+12542782596";
    public String toNo;
    public String content;
    public APIforSMS(String toNo, String content) {
         this.toNo = toNo;
         this.content = content;
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
//                new PhoneNumber(toNo),
                new PhoneNumber("+12234567890"),
                new PhoneNumber(fromNo),
                content)
            .create();

        System.out.println(message.getSid()+" <<"+content+">>  to "+toNo);
   }
}