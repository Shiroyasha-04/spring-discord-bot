package com.shiroyasha.bot.repository;

import com.shiroyasha.bot.entity.CommandUsage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class CommandUsageRepository {

    private final SessionFactory sessionFactory;

    private static final Logger logger =
            LoggerFactory.getLogger(CommandUsageRepository.class);

    public CommandUsageRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void recordUsage(String commandName){
        try(Session session = sessionFactory.openSession()){

            Transaction transaction = session.beginTransaction();

            try {
                CommandUsage usage = session.createQuery("FROM CommandUsage WHERE commandName = :commandName" ,
                                CommandUsage.class)
                        .setParameter("commandName" , commandName)
                        .uniqueResult();

                if(usage == null){
                    usage = new CommandUsage(commandName, 1);
                    session.persist(usage);
                }
                else {
                    usage.setUsageCount(usage.getUsageCount() + 1);
                }

                transaction.commit();
            }
            catch (Exception e) {
                transaction.rollback();
                logger.error("Failed to record command usage", e);
            }
        }
    }

    public List<CommandUsage> getAllUsage(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery(
                    "FROM CommandUsage ORDER BY usageCount DESC" ,
                    CommandUsage.class
            ).getResultList();
        }
    }
}
