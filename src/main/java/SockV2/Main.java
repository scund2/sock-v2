package SockV2;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static JDA jda;

    // 접두사
    public static char prefixText;
    public static String[] defaultChannels = {"663436024218779652", "547033439417794560"};

    public static void main(String[] args) throws LoginException {
        // DISCORD_TOKEN
        jda = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN")).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE); // 대기 상태
        jda.getPresence().setActivity(Activity.playing("강화")); // 상테 msg

        jda.addEventListener(new Main());

        // Init
        prefixText = '!';

        // Init end

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        // 접두사 일치
        if(event.getMessage().getContentRaw().charAt(0) == prefixText) {
            if(event.getMessage().getContentRaw().charAt(1) == prefixText || event.getMessage().getContentRaw().charAt(1) == ' ' || event.getAuthor().isBot())
                return;

            // 명령어 및 옵션 감지
            String[] splitMsg = event.getMessage().getContentRaw().substring(1).split(" ");

        }

        if(event.getMessage().getContentRaw().equals("!빌드")){
            for (String list: defaultChannels) {
                jda.getTextChannelById(list).sendMessage("현재 빌드: 000A00010").queue();
            }
        }

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
