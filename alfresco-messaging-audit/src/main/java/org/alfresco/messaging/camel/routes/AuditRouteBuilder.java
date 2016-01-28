package org.alfresco.messaging.camel.routes;

import org.apache.camel.spring.SpringRouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Route builder for Audit events
 *
 * @author Gethin James
 */
@Component
public class AuditRouteBuilder extends SpringRouteBuilder
{
    private static Log logger = LogFactory.getLog(AuditRouteBuilder.class);

    public String sourceQueue = "direct-vm:alfresco.audit.raw";

    @Value("${audit.events.target.endpoint}")
    public String targetTopic = "direct-vm:alfresco.audit.notset"; //defaults to an invalid topic

    @Override
    public void configure() throws Exception
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("Audit events routes config: ");
            logger.debug("targetTopic is "+targetTopic);
        }

        from(sourceQueue).routeId("audit.events -> topic:alfresco.audit.events")
                .marshal("defaultDataFormat").to(targetTopic)
                .end();
    }
}
