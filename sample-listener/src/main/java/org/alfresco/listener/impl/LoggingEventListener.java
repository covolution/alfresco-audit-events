package org.alfresco.listener.impl;

/**
 * Listens to audit messages
 */

import org.alfresco.events.types.Event;
import org.alfresco.listener.message.EventMessageListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Listens to audit messages
 *
 * @author Someone
 *
 */
@Component
public class LoggingEventListener implements EventMessageListener {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void onEvent(Event event) {
		logger.info("Received event "+event);
	}

}
