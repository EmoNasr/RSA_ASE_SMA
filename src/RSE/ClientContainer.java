import com.sun.security.ntlm.Client;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ClientContainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        String password = "1234567891234567";
        AgentContainer agentContainer=runtime.createAgentContainer(profile);
        AgentController clientAgent = agentContainer.createNewAgent("client", ClientAgent.class.getName(),new Object[]{password});
        clientAgent.start();

    }
}
