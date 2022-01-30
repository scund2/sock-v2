package SockV2;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static JDA jda;
    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault("OTM3MjE4NDM4NDUwMDAzOTc4.YfYisA.LXsSOBfi9pcDaLJ8a_YkSRPeWXA").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        //jda.getPresence().setActivity(Activity.playing("말살"));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equals("!안녕")){
            event.getChannel().sendMessage("안녕하신가.").queue();
        }
    }
}
