package org.alfresco.repo.domain.audit.events;

import org.alfresco.events.audit.AuditEventImpl;
import org.alfresco.events.types.Event;
import org.alfresco.events.types.RepositoryEventImpl;
import org.alfresco.repo.domain.audit.ibatis.AuditDAOImpl;
import org.alfresco.repo.events.EventPreparator;
import org.alfresco.repo.events.EventPublisher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Overrides audit dao sending events on to a topic
 */
public class AuditDaoUsingEventsImpl extends AuditDAOImpl
{
    private static Log logger = LogFactory.getLog(AuditDaoUsingEventsImpl.class);
    private EventPublisher eventPublisher;

    @Override
    public Long createAuditEntry(final Long applicationId, final long time, final String username, final Map<String, Serializable> values)
    {
        eventPublisher.publishEvent(new EventPreparator(){
            @Override
            public Event prepareEvent(String user, String networkId, String transactionId)
            {
                return new AuditEventImpl(String.valueOf(applicationId), transactionId, networkId, time, username, values);
            }
        });
        return -1l;  //Not used.
    }

    public void setEventPublisher(EventPublisher eventPublisher)
    {
        this.eventPublisher = eventPublisher;
    }


}
