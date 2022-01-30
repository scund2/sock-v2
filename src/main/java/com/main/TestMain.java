package com.main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class TestMain {

    public static void main(String[] args) throws LoginException {
        // 기본 jda를 만들고
        JDA jda = JDABuilder.createDefault("OTM3MjE4NDM4NDUwMDAzOTc4.YfYisA.LXsSOBfi9pcDaLJ8a_YkSRPeWXA").build();
        jda.setAutoReconnect(true);

        // jda에 이벤트를 감지하는 리스너를 넣는다.
        //jda.addEventListener(new SockInput());
    }

    //@Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // 받은 메세지 내용이 !ping이라면
        if (event.getMessage().getContentRaw().equals("!ping")) {
            // pong라는 내용을 보낸다.
            //event.getChannel().sendMessage("pong!").queue();
        }
    }
}
