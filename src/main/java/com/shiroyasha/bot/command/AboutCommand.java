package com.shiroyasha.bot.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class AboutCommand implements Command{
    @Override
    public String getName() {
        return "!about";
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("I am a sample prototype for a sprigboot based bot built customly for the needs of Strat gamer channels").queue();
    }
}
