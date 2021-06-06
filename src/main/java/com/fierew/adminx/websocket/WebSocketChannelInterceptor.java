package com.fierew.adminx.websocket;

import org.jetbrains.annotations.NotNull;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.security.Principal;
import java.util.Objects;

/**
 * @author xuyang
 */
public class WebSocketChannelInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(@NotNull Message<?> message, @NotNull MessageChannel messageChannel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        // 判断是否是首次连接请求
        assert accessor != null;
        if(StompCommand.CONNECT.equals(accessor.getCommand())){
            // 验证是否登陆
            String token = Objects.requireNonNull(accessor.getNativeHeader("authorization")).get(0);

            // 根据token获取userId

            System.out.println(token);
            Principal user = new MyPrincipal(token);
            accessor.setUser(user);
        }

        return message;
    }
}
