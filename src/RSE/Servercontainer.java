import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class Servercontainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");

        AgentContainer agentContainer=runtime.createAgentContainer(profile);
        AgentController agent = agentContainer.createNewAgent("server",ServerAgent.class.getName(),new Object[]{});
        agent.start();
    }
}
