    package com.shiroyasha.bot;

    import com.shiroyasha.bot.listner.MessageListner;
    import com.shiroyasha.bot.service.CommandService;
    import net.dv8tion.jda.api.JDA;
    import org.springframework.context.event.ContextRefreshedEvent;
    import org.springframework.context.event.EventListener;
    import org.springframework.stereotype.Component;

    @Component
    public class Bot {

        private final JDA jda;
        private final CommandService commandService;
        private final MessageListner messageListner;

        public Bot(JDA jda , CommandService commandService , MessageListner messageListner){
            this.jda = jda;
            this.commandService = commandService;
            this.messageListner = messageListner;
        }

        @EventListener(ContextRefreshedEvent.class)
        public void start(){
            System.out.println("Discord bot started!");
            System.out.println("JDA Status:" + jda.getStatus());

            jda.addEventListener(messageListner);
        }

    }
