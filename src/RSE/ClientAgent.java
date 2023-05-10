import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ClientAgent extends Agent {
    @Override
    protected void setup() {
        String message = "Hello world";
        String password = (String) getArguments()[0];
        SecretKey secretKey = new SecretKeySpec(password.getBytes(),"AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] encryptMsg = cipher.doFinal(message.getBytes());
            String encryptedMsg = Base64.getEncoder().encodeToString(encryptMsg);
            System.out.println(encryptedMsg);
            ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
            aclMessage.setContent(encryptedMsg);
            aclMessage.addReceiver(new AID("server", AID.ISLOCALNAME));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }
}
