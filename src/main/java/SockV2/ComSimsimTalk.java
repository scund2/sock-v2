package SockV2;

import org.json.JSONObject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class ComSimsimTalk {

    // 심심이
    // http://developer.simsimi.com/api

    private static String resp = "";

    public static void Talk(MessageReceivedEvent event, String msg) throws Exception {

        String url = "https://httpbin.org/post";

        resp = Util.getRequest(url + "?key=" + System.getenv("SIMSIM_TOKEN") + "&text=" + msg + "&lc=ko&ft=0.0");

        /*
        Response elements : JSON
        result      Integer	100-OK.
                            400-Bad Request.
                            401-Unauthorized.
                            404-Not found.
                            500-Server Error.
        id	        Integer	Response id. (you can get only if returning result is 100)
        response	String	Response message(you can get only if returning result is 100)
        msg	        String	Result msg(Description of result code)
        */

        event.getChannel().sendMessage("테스트: " + msg).queue();
        event.getChannel().sendMessage(resp).queue();
        event.getChannel().sendMessage("테스트: 완료").queue();

        JSONObject jsonObject = new JSONObject(resp);

        if(jsonObject.get("result") == "100") {
            event.getChannel().sendMessage(jsonObject.get("msg").toString()).queue();
        }
        else
            event.getChannel().sendMessage("심심이: 직무유기").queue();

    }
}