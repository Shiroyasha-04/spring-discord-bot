package com.shiroyasha.bot.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shiroyasha.bot.service.CommandService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MessageListner extends ListenerAdapter {

    private final CommandService commandService;

    private static final Logger logger =
            LoggerFactory.getLogger(MessageListner.class);

    public MessageListner(CommandService commandService){
        this.commandService = commandService;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        logger.info("Message received: {}", event.getMessage().getContentRaw());

        commandService.handleCommand(event);
    }

}
