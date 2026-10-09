package com.shiroyasha.bot.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelloCommand implements Command{

    @Override
    public String getName() {
        return "!hello";
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Hello!").queue();
    }
}
