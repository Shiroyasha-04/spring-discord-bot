package com.shiroyasha.bot.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command{

    @Override
    public String getName() {
        return "!help";
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("""
                    Available commands:
                    !ping
                    !hello
                    !about
                    !stats
                    !help""").queue();
    }
}
