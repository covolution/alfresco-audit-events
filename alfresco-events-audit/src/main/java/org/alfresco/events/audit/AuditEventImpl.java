package org.alfresco.events.audit;

import org.alfresco.events.types.DataItem;
import org.alfresco.events.types.RepositoryEventImpl;
import org.alfresco.repo.events.JsonUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * An Event produced by the Auditing component
 *
 * @author Gethin James
 */
public class AuditEventImpl extends RepositoryEventImpl implements DataItem
{

    private final Map<String, Serializable> values;

    public AuditEventImpl(String applicationId, String txnId, String networkId, long timestamp, String username, Map<String, Serializable> values)
    {
        super(1l, applicationId, txnId, networkId, timestamp, username, null);
        this.values = values;
    }

    @Override
    public String getDataAsJson()
    {
        return JsonUtil.writeData(values);
    }
}
