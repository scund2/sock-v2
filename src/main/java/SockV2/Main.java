package SockV2;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main extends ListenerAdapter {
    public static JDA jda;

    // 접두사
    public static char prefixText;
    public static String buildToken;
    //public static String[] defaultChannels = {"663436024218779652", "547033439417794560"};
    public static String[] defaultChannels = {"663436024218779652"};

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
    public void onReady(ReadyEvent event){

        byte[] arr = new byte[8];
        StringBuilder sb = new StringBuilder();
        new Random().nextBytes(arr);
        for (byte temp : arr) {
            sb.append(String.format("%02x", temp));
        }

        buildToken = sb.toString();
        for (String list: defaultChannels) {
            jda.getTextChannelById(list).sendMessage("build token: " + buildToken).queue();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        // 접두사 일치
        if(event.getMessage().getContentRaw().charAt(0) == prefixText) {
            if(event.getMessage().getContentRaw().charAt(1) == prefixText || event.getMessage().getContentRaw().charAt(1) == ' ' || event.getAuthor().isBot())
                return;

            // 명령어 및 옵션 감지
            ArrayList<String> splitMsg = new ArrayList<String>(Arrays.asList(event.getMessage().getContentRaw().substring(1).split(" ")));

            switch (splitMsg.get(0)) {
                case "안녕" : // 안녕
                    ComSayHello.Hello(event);
                    break;
                case "대화" : // 대화
                    splitMsg.remove(0);
                    try {
                        ComSimsimTalk.Talk(event, combineText(splitMsg));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    String combineText(ArrayList<String> arr) {
        String result = "";
        for (String list: arr) {
            result += list + " ";
        }

        result = result.substring(0, result.length()-1);



        return result;
    }
}
