package org.talend.esb.eventlogging.sender.rest;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * A message that represents a logging event.
 */
public class LogEventImpl extends DefaultMessage implements Serializable, LogEventMessage {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7749515383167723404L;

    // /** The Constant ATTR_PREFIX_BODY. */
    // public static final String ATTR_PREFIX_BODY = "org.talend.esb.event.body.";

    // /** The Constant ATTR_LOG_MESSAGE. */
    // public static final String ATTR_LOG_MESSAGE = ATTR_PREFIX_BODY + "logmessage";

    public LogEventImpl() {
        // setCamelContext(camelContext);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getId()
     */
    @Override
    public Long getId() {
        return getHeader(ATTR_ID, Long.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setId(java.lang.Long)
     */
    @Override
    public void setId(Long id) {
        setHeader(ATTR_ID, id);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getEventUUID()
     */
    @Override
    public String getEventUUID() {
        return getHeader(ATTR_EVENT_UUID, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setEventUUID(java.lang.String)
     */
    @Override
    public void setEventUUID(String eventUUID) {
        setHeader(ATTR_EVENT_UUID, eventUUID);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getCategory()
     */
    @Override
    public String getCategory() {
        return getHeader(ATTR_CATEGORY, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setCategory(java.lang.String)
     */
    @Override
    public void setCategory(String category) {
        setHeader(ATTR_CATEGORY, validCategory(category));
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#isEmptyOrDefaultCategory()
     */
    @Override
    public boolean isEmptyOrDefaultCategory() {
        final String category = getHeader(ATTR_CATEGORY, String.class);
        return category == null || category.length() == 0
                || DEFAULT_PSEUDO_CATEGORY.equalsIgnoreCase(category);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#isPing()
     */
    @Override
    public boolean isPing() {
        return PING_PSEUDO_CATEGORY.equals(getHeader(ATTR_CATEGORY));
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getEventType()
     */
    @Override
    public String getEventType() {
        return getHeader(ATTR_EVENT_TYPE, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setEventType(java.lang.String)
     */
    @Override
    public void setEventType(String eventType) {
        setHeader(ATTR_EVENT_TYPE, eventType);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getLogMessage()
     */
    @Override
    public String getLogMessage() {
        return getBody(String.class);
        // return getHeader(ATTR_LOG_MESSAGE, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setLogMessage(java.lang.String)
     */
    @Override
    public void setLogMessage(String logMessage) {
        setBody(logMessage);
        // setHeader(ATTR_LOG_MESSAGE, logMessage);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getSeverity()
     */
    @Override
    public String getSeverity() {
        return getHeader(ATTR_SEVERITY, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setSeverity(java.lang.String)
     */
    @Override
    public void setSeverity(String severity) {
        setHeader(ATTR_SEVERITY, severity);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getLogSource()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> getLogSource() {
        Map<String, String> logSourceMap = (Map<String, String>) getHeader(ATTR_LOG_SOURCE, Map.class);
        if (logSourceMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(logSourceMap);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setLogSource(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setLogSource(String logSourceName, String value) {
        Map<String, String> logSourceMap = (Map<String, String>) getHeader(ATTR_LOG_SOURCE, Map.class);
        if (logSourceMap == null) {
            if (value == null) {
                return;
            }
            logSourceMap = Collections.checkedMap(new HashMap<String, String>(), String.class, String.class);
            setHeader(ATTR_LOG_SOURCE, logSourceMap);
        } else {
            if (value == null) {
                logSourceMap.remove(logSourceName);
                if (logSourceMap.isEmpty()) {
                    removeHeader(ATTR_LOG_SOURCE);
                }
                return;
            }
        }
        logSourceMap.put(logSourceName, value);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void addLogSource(Map<String, String> logSource) {
        if (logSource == null || logSource.isEmpty()) {
            return;
        }
        Map<String, String> logSourceMap = (Map<String, String>) getHeader(ATTR_LOG_SOURCE, Map.class);
        if (logSourceMap == null) {
            logSourceMap = Collections.checkedMap(new HashMap<String, String>(), String.class, String.class);
            setHeader(ATTR_LOG_SOURCE, logSourceMap);
        }
        logSourceMap.putAll(logSource);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getAgentTimestamp()
     */
    @Override
    public Date getAgentTimestamp() {
        return asTimestamp(ATTR_AGENT_TIMESTAMP);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setAgentTimestamp(java.util.Date)
     */
    @Override
    public void setAgentTimestamp(Date agentTimestamp) {
        setHeader(ATTR_AGENT_TIMESTAMP, agentTimestamp);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getServerTimestamp()
     */
    @Override
    public Date getServerTimestamp() {
        return asTimestamp(ATTR_SERVER_TIMESTAMP);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setServerTimestamp(java.util.Date)
     */
    @Override
    public void setServerTimestamp(Date serverTimestamp) {
        setHeader(ATTR_SERVER_TIMESTAMP, serverTimestamp);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getLogTimestamp()
     */
    @Override
    public Date getLogTimestamp() {
        return asTimestamp(ATTR_LOG_TIMESTAMP);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setLogTimestamp(java.util.Date)
     */
    @Override
    public void setLogTimestamp(Date logTimestamp) {
        setHeader(ATTR_LOG_TIMESTAMP, logTimestamp);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getAudit()
     */
    @Override
    public Boolean getAudit() {
        return getHeader(ATTR_AUDIT, Boolean.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#isAudit()
     */
    @Override
    public boolean isAudit() {
        final Boolean audit = getHeader(ATTR_AUDIT, Boolean.class);
        return audit != null && audit.booleanValue();
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setAudit(java.lang.Boolean)
     */
    @Override
    public void setAudit(Boolean audit) {
        setHeader(ATTR_AUDIT, audit);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getAgentId()
     */
    @Override
    public String getAgentId() {
        return getHeader(ATTR_AGENT_ID, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setAgentId(java.lang.String)
     */
    @Override
    public void setAgentId(String agentId) {
        setHeader(ATTR_AGENT_ID, agentId);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getAuditSequenceNo()
     */
    @Override
    public Long getAuditSequenceNo() {
        return getHeader(ATTR_AUDIT_SEQUENCE_NO, Long.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setAuditSequenceNo(java.lang.Long)
     */
    @Override
    public void setAuditSequenceNo(Long auditSequenceNo) {
        setHeader(ATTR_AUDIT_SEQUENCE_NO, auditSequenceNo);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getSignedLogMessage()
     */
    @Override
    public String getSignedLogMessage() {
        return getHeader(ATTR_SIGNED_LOG_MESSAGE, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setSignedLogMessage(java.lang.String)
     */
    @Override
    public void setSignedLogMessage(String signedLogMessage) {
        setHeader(ATTR_SIGNED_LOG_MESSAGE, signedLogMessage);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getCorrelationId()
     */
    @Override
    public String getCorrelationId() {
        return getHeader(ATTR_CORRELATION_ID, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setCorrelationId(java.lang.String)
     */
    @Override
    public void setCorrelationId(String correlationId) {
        setHeader(ATTR_CORRELATION_ID, correlationId);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getSubject()
     */
    @Override
    public String getSubject() {
        return getHeader(ATTR_SUBJECT, String.class);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setSubject(java.lang.String)
     */
    @Override
    public void setSubject(String subject) {
        setHeader(ATTR_SUBJECT, subject);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getCustomInfo(java.lang.String)
     */
    @Override
    public String getCustomInfo(String customInfoName) {
        Map<?, ?> customInfoMap = getHeader(ATTR_CUSTOM_INFO, Map.class);
        return customInfoMap == null ? null : (String) customInfoMap.get(customInfoName);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#setCustomInfo(java.lang.String, java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void setCustomInfo(String customInfoName, String value) {
        Map<String, String> customInfoMap = (Map<String, String>) getHeader(ATTR_CUSTOM_INFO, Map.class);
        if (customInfoMap == null) {
            if (value == null) {
                return;
            }
            customInfoMap = Collections.checkedMap(new HashMap<String, String>(), String.class, String.class);
            setHeader(ATTR_CUSTOM_INFO, customInfoMap);
        } else {
            if (value == null) {
                customInfoMap.remove(customInfoName);
                if (customInfoMap.isEmpty()) {
                    removeHeader(ATTR_CUSTOM_INFO);
                }
                return;
            }
        }
        customInfoMap.put(customInfoName, value);
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#getCustomInfo()
     */
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, String> getCustomInfo() {
        Map<String, String> customInfoMap = (Map<String, String>) getHeader(ATTR_CUSTOM_INFO, Map.class);
        if (customInfoMap == null) {
            customInfoMap = Collections.checkedMap(new HashMap<String, String>(), String.class, String.class);
            setHeader(ATTR_CUSTOM_INFO, customInfoMap);
        }
        return customInfoMap;
    }

    /* (non-Javadoc)
     * @see org.talend.esb.eventlogging.LogEvent#addCustomInfo(java.util.Map)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void addCustomInfo(Map<String, String> customInfo) {
        if (customInfo == null || customInfo.isEmpty()) {
            return;
        }
        Map<String, String> customInfoMap = (Map<String, String>) getHeader(ATTR_CUSTOM_INFO, Map.class);
        if (customInfoMap == null) {
            customInfoMap = Collections.checkedMap(new HashMap<String, String>(), String.class, String.class);
            setHeader(ATTR_CUSTOM_INFO, customInfoMap);
        }
        customInfoMap.putAll(customInfo);
    }
    
    public Message copy() {
        Message result = new LogEventImpl();
        result.copyFrom(this);
        return result;
    }

    @Override
    public String toString() {

        StringBuffer logEventInfo = new StringBuffer("\n");

        logEventInfo.append("id:[").append(getId()).append("]\n");
        logEventInfo.append("eventUUID:[").append(getEventUUID()).append("]\n");
        logEventInfo.append("correlationId:[").append(getCorrelationId()).append("]\n");

        logEventInfo.append("category:[").append(getCategory()).append("]\n");
        logEventInfo.append("eventType:[").append(getEventType()).append("]\n");
        logEventInfo.append("severity:[").append(getSeverity()).append("]\n");


        logEventInfo.append("logSource:[").append(getLogSource()).append("]\n");
        logEventInfo.append("logMessage:[").append(getLogMessage()).append("]\n");
        logEventInfo.append("signedLogMessage:[").append(getSignedLogMessage()).append("]\n");
        logEventInfo.append("logTimestamp:[").append(getLogTimestamp()).append("]\n");


        logEventInfo.append("agentId:[").append(getAgentId()).append("]\n");
        logEventInfo.append("agentTimestamp:[").append(getAgentTimestamp()).append("]\n");

        logEventInfo.append("serverTimestamp:[").append(getServerTimestamp()).append("]\n");

        logEventInfo.append("audit:[").append(getAudit()).append("]\n");
        logEventInfo.append("auditSequenceNo:[").append(getAuditSequenceNo()).append("]\n");

        logEventInfo.append("subject:[").append(getSubject()).append("]\n");

        logEventInfo.append("customInfo:[");
        printCustomInfo(logEventInfo);
        logEventInfo.append("]\n");

        return logEventInfo.toString();
    }

    @SuppressWarnings("unchecked")
    private void printCustomInfo(StringBuffer buffer) {
        final Map<String, String> customInfo = (Map<String, String>) getHeader(ATTR_CUSTOM_INFO);
        if (null != customInfo && !customInfo.isEmpty()) {
            buffer.append('\n');
            for (Map.Entry<String, String> e : customInfo.entrySet()) {
                buffer.append("  ").append(e.getKey()).append(":[").append(e.getValue()).append("]\n");
            }
        }
    }

    private String validCategory(final String rawCategory) {
        if (rawCategory == null || rawCategory.length() == 0
                || DEFAULT_PSEUDO_CATEGORY.equalsIgnoreCase(rawCategory)) {
            return DEFAULT_PSEUDO_CATEGORY;
        }
        if (AUDIT_PSEUDO_CATEGORY.equalsIgnoreCase(rawCategory)) {
            // reserved name, handled by the audit flag
            setAudit(Boolean.TRUE);
            return DEFAULT_PSEUDO_CATEGORY;
        }
        if (PING_PSEUDO_CATEGORY.equalsIgnoreCase(rawCategory)) {
            return PING_PSEUDO_CATEGORY;
        }
        return rawCategory;
    }

    private Date asTimestamp(final String headerName) {
        if (null != headerName) {
            final Object timestamp = getHeader(headerName);
            if (null != timestamp) {
                if (timestamp instanceof Date) {
                    return (Date) timestamp;
                }
            }
        }
        return null;
    }

}
