package SockV2;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ComSayHello {

    public static void Hello(MessageReceivedEvent event) {
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
