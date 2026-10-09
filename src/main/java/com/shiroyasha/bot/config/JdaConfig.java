package com.shiroyasha.bot.config;

import com.shiroyasha.bot.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {

    @Value("${discord.bot.token}")
    private String botToken;


    @Bean(destroyMethod = "shutdown")
    public JDA jda(){

        return JDABuilder.createDefault(botToken,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT).build();
    }
}
