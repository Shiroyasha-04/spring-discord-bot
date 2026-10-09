package com.shiroyasha.bot.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class PingCommand implements Command {

    @Override
    public String getName() {
        return "!ping";
    }

    @Override
    public void execute(MessageReceivedEvent event){
        event.getChannel().sendMessage("!pong").queue();
    }
}
