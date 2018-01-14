package org.talend.esb.eventlogging.sender.rest;

import java.util.Date;
import java.util.Map;

public interface LogEvent {

    /** The default pseudo category value. */
    public static final String DEFAULT_PSEUDO_CATEGORY = "default";
    /** The audit pseudo category value. */
    public static final String AUDIT_PSEUDO_CATEGORY = "audit";
    /** The ping pseudo category value. */
    public static final String PING_PSEUDO_CATEGORY = "ping";
    
    /** Identifier for hostname within log source attribute */
    public static final String LS_HOSTNAME = "host.name";
    /** Identifier for processId within log source attribute */
    public static final String LS_PROCESS_ID = "process.id";
    
    /** Metadata Type for custom info (needed primarily for DB) */
    public static final String CUSTOM_INFO_METADATA_TYPE = "custominfo";
    /** Metadata Type for log source information (needed primarily for DB) */
    public static final String LOG_SOURCE_METADATA_TYPE = "logsource";

    /**
     * Gets the id.
     *
     * @return the id
     */
    Long getId();

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    void setId(Long id);

    String getEventUUID();

    void setEventUUID(String eventUUID);

    /**
     * Gets the category.
     *
     * @return the category
     */
    String getCategory();

    /**
     * Sets the category.
     *
     * @param category
     *            the new category
     */
    void setCategory(String category);

    /**
     * Check if the category is unset or set to the "default" pseudo category.
     *
     * @return result of check for unset or "default" category value.
     */
    boolean isEmptyOrDefaultCategory();

    /**
     * Check if the present event is a "ping" pseudo event.
     *
     * @return result of check for "ping" event.
     */
    boolean isPing();

    /**
     * Gets the event type.
     *
     * @return the event type
     */
    String getEventType();

    /**
     * Sets the event type.
     *
     * @param eventType
     *            the new event type
     */
    void setEventType(String eventType);

    /**
     * Gets the log message.
     *
     * @return the log message
     */
    String getLogMessage();

    /**
     * Sets the log message.
     *
     * @param logMessage
     *            the new log message
     */
    void setLogMessage(String logMessage);

    /**
     * Gets the severity.
     *
     * @return the severity
     */
    String getSeverity();

    /**
     * Sets the severity.
     *
     * @param severity
     *            the new severity
     */
    void setSeverity(String severity);

    /**
     * Gets the log source.
     *
     * @return the log source
     */
    Map<String, String> getLogSource();

    /**
     * Sets the log source.
     *
     * @param logSource
     *            the new log source
     */
    void setLogSource(String logSourceName, String value);
    
    /**
     * Add a map with log source keys and values.
     *
     * @param logSource
     *            the map with keys and values to be added.
     */
    void addLogSource(Map<String, String> logSource);

    /**
     * Gets the agent timestamp in standard XML format.
     *
     * @return the agent timestamp
     */
    Date getAgentTimestamp();

    /**
     * Sets the agent timestamp in standard XML format.
     *
     * @param agentTimestamp
     *            the new agent timestamp
     */
    void setAgentTimestamp(Date agentTimestamp);

    /**
     * Gets the server timestamp in standard XML format.
     *
     * @return the server timestamp
     */
    Date getServerTimestamp();

    /**
     * Sets the server timestamp in standard XML format.
     *
     * @param serverTimestamp
     *            the new server timestamp
     */
    void setServerTimestamp(Date serverTimestamp);

    /**
     * Gets the log timestamp in standard XML format.
     *
     * @return the log timestamp
     */
    Date getLogTimestamp();

    /**
     * Sets the log timestamp in standard XML format.
     *
     * @param logTimestamp
     *            the new log timestamp
     */
    void setLogTimestamp(Date logTimestamp);

    /**
     * Gets the audit event flag.
     *
     * @return the audit event flag
     */
    Boolean getAudit();

    /**
     * Gets the evaluated audit event flag.
     *
     * @return the evaluated audit event flag
     */
    boolean isAudit();

    /**
     * Sets the audit flag.
     *
     * @param audit
     *            the new audit flag
     */
    void setAudit(Boolean audit);

    /**
     * Gets the agent id.
     *
     * @return the agent id
     */
    String getAgentId();

    /**
     * Sets the agent id.
     *
     * @param agentId
     *            the new agent id
     */
    void setAgentId(String agentId);

    /**
     * Gets the audit sequence number.
     *
     * @return the audit sequence number
     */
    Long getAuditSequenceNo();

    /**
     * Sets the audit sequence number.
     *
     * @param auditSequenceNo
     *            the new audit sequence number
     */
    void setAuditSequenceNo(Long auditSequenceNo);

    /**
     * Gets the signed log message.
     *
     * @return the signed log message
     */
    String getSignedLogMessage();

    /**
     * Sets the signed log message.
     *
     * @param signedLogMessage
     *            the new signed log message
     */
    void setSignedLogMessage(String signedLogMessage);

    /**
     * Gets the correlation id.
     *
     * @return the correlation id
     */
    String getCorrelationId();

    /**
     * Sets the correlation id.
     *
     * @param correlationID
     *            the new correlation id
     */
    void setCorrelationId(String correlationId);

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    String getSubject();

    /**
     * Sets the subject.
     *
     * @param subject
     *            the new subject
     */
    void setSubject(String subject);

    /**
     * Gets the custom info value for a given key.
     *
     * @param customInfoName
     *            the custom info lookup key
     * @return the custom info value
     */
    String getCustomInfo(String customInfoName);

    /**
     * Sets the custom info value for a given key.
     *
     * @param customInfoName
     *            the custom info key
     * @param value
     *            the new custom info value
     */
    void setCustomInfo(String customInfoName, String value);

    /**
     * Get the custom info as unmodifiable map.
     *
     * @return an unmodifiable view of the custom info map.
     */
    Map<String, String> getCustomInfo();

    /**
     * Add a map with custom info keys and values.
     *
     * @param customInfo
     *            the map with keys and values to be added.
     */
    void addCustomInfo(Map<String, String> customInfo);

}
