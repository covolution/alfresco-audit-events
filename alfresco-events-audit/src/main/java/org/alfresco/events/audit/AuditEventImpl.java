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
    private Map<String, Serializable> values;

    public AuditEventImpl()
    {
    }

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

    public void setValues(Map<String, Serializable> values)
    {
        this.values = values;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AuditEventImpl{");

        sb.append("id=").append(this.id).append(", type=")
                .append(this.type).append(", username=").append(this.username)
                .append(", client=").append(this.client)
                .append(", timestamp=").append(this.timestamp).append(", txnId=")
                .append(this.txnId).append(", networkId=").append(this.networkId);
        sb.append(", values=").append(values);
        sb.append(", dataAsJson='").append(getDataAsJson()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
