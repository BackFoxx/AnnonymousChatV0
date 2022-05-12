package toyproject.annonymouschat.web.controller.href;

import toyproject.annonymouschat.chat.model.Chat;
import toyproject.annonymouschat.chat.service.ChatService;
import toyproject.annonymouschat.config.controller.ControllerWithMap;
import toyproject.annonymouschat.config.controller.ControllerWithTwoMap;
import toyproject.annonymouschat.config.controller.ModelView;
import toyproject.annonymouschat.config.controller.ReturnType;

import java.util.Map;

public class ReplyChatFormServlet implements ControllerWithTwoMap {
    ChatService chatService = new ChatService();

    @Override
    @ReturnType(type = ReturnType.ReturnTypes.FORWARD)
    public String process(Map<String, Object> requestParameters, Map<String, Object> model) {
        Long id = Long.valueOf((String) requestParameters.get("id"));
        Chat chat = chatService.findbyChatId(id);

        model.put("chat", chat);
        return "chat/replychat/replychat-form";
    }
}
