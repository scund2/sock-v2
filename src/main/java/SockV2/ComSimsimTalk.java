package SockV2;

import org.json.JSONObject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class ComSimsimTalk {

    // 심심이
    // http://developer.simsimi.com/api

    private static String resp = "";

    public static void Talk(MessageReceivedEvent event, String msg) throws Exception {

        // Ex) http://api.simsimi.com/request.p?key=your_paid_key&lc=en&ft=1.0&text=hi
        String url = "http://api.simsimi.com/request.p";
        String fullUrl = url + "?key=" + System.getenv("SIMSIM_TOKEN") + "&text=" + Util.encodeURL(msg) + "&lc=ko&ft=0.0";
        resp = Util.getRequest(fullUrl);

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

        event.getChannel().sendMessage(resp).queue();

        JSONObject jsonObject = new JSONObject(resp);

        event.getChannel().sendMessage((String)jsonObject.get("result")).queue();

        if((String)jsonObject.get("result") == "100")
            event.getChannel().sendMessage(jsonObject.get("response").toString()).queue();
        else
            event.getChannel().sendMessage("심심이: 직무유기").queue();

    }
}