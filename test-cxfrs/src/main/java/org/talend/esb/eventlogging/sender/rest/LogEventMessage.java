package org.talend.esb.eventlogging.sender.rest;

import org.apache.camel.Message;

public interface LogEventMessage extends LogEvent, Message {

    /** The Constant ATTR_PREFIX. */
    public static final String ATTR_PREFIX = "tesbEventLogging.";
    /** The Constant ATTR_ID. */
    public static final String ATTR_ID = ATTR_PREFIX + "id";
    /** The Constant ATTR_EVENT_UUID. */
    public static final String ATTR_EVENT_UUID = ATTR_PREFIX + "eventuuid";
    /** The Constant ATTR_CATEGORY. */
    public static final String ATTR_CATEGORY = ATTR_PREFIX + "category";
    /** The Constant ATTR_EVENT_TYPE. */
    public static final String ATTR_EVENT_TYPE = ATTR_PREFIX + "eventtype";
    /** The Constant ATTR_SEVERITY. */
    public static final String ATTR_SEVERITY = ATTR_PREFIX + "severity";
    /** The Constant ATTR_LOG_SOURCE. */
    public static final String ATTR_LOG_SOURCE = ATTR_PREFIX + "source";
    /** The Constant ATTR_AGENT_TIMESTAMP. */
    public static final String ATTR_AGENT_TIMESTAMP = ATTR_PREFIX + "agenttimestamp";
    /** The Constant ATTR_SERVER_TIMESTAMP. */
    public static final String ATTR_SERVER_TIMESTAMP = ATTR_PREFIX + "servertimestamp";
    /** The Constant ATTR_LOG_TIMESTAMP. */
    public static final String ATTR_LOG_TIMESTAMP = ATTR_PREFIX + "logtimestamp";
    /** The Constant ATTR_AUDIT. */
    public static final String ATTR_AUDIT = ATTR_PREFIX + "audit";
    /** The Constant ATTR_AGENT_ID. */
    public static final String ATTR_AGENT_ID = ATTR_PREFIX + "agentid";
    /** The Constant ATTR_AUDIT_SEQUENCE_NO. */
    public static final String ATTR_AUDIT_SEQUENCE_NO = ATTR_PREFIX + "auditsequenceno";
    /** The Constant ATTR_SIGNED_LOG_MESSAGE. */
    public static final String ATTR_SIGNED_LOG_MESSAGE = ATTR_PREFIX + "signedlogmessage";
    /** The Constant ATTR_CORRELATION_ID. */
    public static final String ATTR_CORRELATION_ID = ATTR_PREFIX + "correlationid";
    /** The Constant ATTR_SUBJECT. */
    public static final String ATTR_SUBJECT = ATTR_PREFIX + "subject";
    /** The Constant ATTR_CUSTOM_INFO. */
    public static final String ATTR_CUSTOM_INFO = ATTR_PREFIX + "custominfo";
}
