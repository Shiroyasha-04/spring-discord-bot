package com.shiroyasha.bot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "command_usage")
public class CommandUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "command_name" , nullable = false)
    private String commandName;

    @Column(name = "usage_count" , nullable = false)
    private Integer usageCount;

    public CommandUsage() {

    }

    public CommandUsage(String commandName , Integer usageCount){
        this.commandName = commandName;
        this.usageCount = usageCount;
    }

    public Integer getId() {
        return id;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

}
