package com.shiroyasha.bot.command;

import com.shiroyasha.bot.entity.CommandUsage;
import com.shiroyasha.bot.repository.CommandUsageRepository;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatsCommand implements Command {

    private final CommandUsageRepository commandUsageRepository;

    public StatsCommand(CommandUsageRepository commandUsageRepository) {
        this.commandUsageRepository = commandUsageRepository;
    }

    @Override
    public String getName(){
        return "!stats";
    }

    @Override
    public void execute(MessageReceivedEvent event){

        List<CommandUsage> usageList =
                commandUsageRepository.getAllUsage();

        if(usageList.isEmpty()){
            event.getChannel().sendMessage("No command usage recorded yet!").queue();
            return;
        }

        StringBuilder message = new StringBuilder("Command Usage:\n");

        for (CommandUsage usage : usageList){
            message.append(usage.getCommandName())
                    .append(" → ")
                    .append(usage.getUsageCount())
                    .append("\n");
        }

        event.getChannel().sendMessage(message.toString()).queue();
    }
}
