    package com.shiroyasha.bot;

    import com.shiroyasha.bot.config.AppConfig;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class Main {
         static void main(String[] args){
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         }
    }