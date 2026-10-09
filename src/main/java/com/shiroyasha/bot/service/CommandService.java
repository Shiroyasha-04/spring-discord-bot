package com.shiroyasha.bot.service;

import com.shiroyasha.bot.command.Command;
import com.shiroyasha.bot.repository.CommandUsageRepository;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    @Value("${discord.bot.prefix}")
    private String prefix;

    private final List<Command> commands;
    private final CommandUsageRepository commandUsageRepository;

    public CommandService(List<Command> commands , CommandUsageRepository commandUsageRepository) {
        this.commands = commands;
        this.commandUsageRepository = commandUsageRepository;
    }

    public void handleCommand(MessageReceivedEvent event){

        String message = event.getMessage().getContentRaw();

        for(Command command : commands){
            if (command.getName().equalsIgnoreCase(message)){
                commandUsageRepository.recordUsage(command.getName());
                command.execute(event);
                return;
            }
        }

    }

}
