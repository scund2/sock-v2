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
        // DISCORD_TOKEN
        jda = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN")).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("강화"));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equals("!안녕")){

            int rand = (int)(Math.random()*100) + 1;

            if(rand < 20)
                event.getChannel().sendMessage("안녕하신가").queue();
            else if(rand < 40)
                event.getChannel().sendMessage("여어").queue();
            else if(rand < 60)
                event.getChannel().sendMessage("거기안녕").queue();
            else if(rand < 99)
                event.getChannel().sendMessage("반갑다 좆간").queue();
            else if(rand == 100)
                event.getChannel().sendMessage("안녕하십쌉싸리와용").queue();
        }
    }
}
