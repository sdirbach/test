package org.talend.esb.eventlogging.sender.rest;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.talend.esb.eventlogging.sender.rest.LogEvent;
import org.talend.esb.eventlogging.sender.rest.LogEventImpl;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eventUUID", "correlationId",
        "eventType", "category", "agentId", "severity",
        "logMessage", "logSource", "signedLogMessage", "logTimestamp",
        "agentTimestamp", "serverTimestamp",
        "audit", "auditSequenceNo",
        "subject",
        "customInfo"
})
@XmlRootElement(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = 5746132029914660077L;

    @XmlTransient
//    @XmlElement(name = "id")
    private Long id;

//    @XmlElement(name = "eventUUID")
    private String eventUUID;

//    @XmlElement(name = "correlationId")
    private String correlationId;


//    @XmlElement(name = "category")
    private String category;

//    @XmlElement(name = "eventType")
    private String eventType;

//    @XmlElement(name = "severity")
    private String severity;

//    @XmlElement(name = "logMessage")
    private String logMessage;

//    @XmlElement(name = "logSource")
    private Map<String, String> logSource;

//    @XmlElement(name = "signedLogMessage")
    private String signedLogMessage;

//    @XmlElement(name = "logTimestamp")
    private Date logTimestamp;


    //    @XmlElement(name = "agentId")
    private String agentId;

//    @XmlElement(name = "agentTimestamp")
    private Date agentTimestamp;

//    @XmlElement(name = "serverTimestamp")
    private Date serverTimestamp;


//    @XmlElement(name = "audit")
    private Boolean audit;

//    @XmlElement(name = "auditSequenceNo")
    private Long auditSequenceNo;


//    @XmlElement(name = "subject")
    private String subject;

//    @XmlElement(name = "customInfo")
    private Map<String, String> customInfo;


    public Event() {
        super();
    }

    public Event(final Message msg) {
        if (msg == null) {
            return;
        }
        final LogEventImpl evt;
        if (msg instanceof LogEventImpl) {
            evt = (LogEventImpl) msg;
        } else {
            evt = new LogEventImpl();
            evt.copyFrom(msg);
        }

        id = evt.getId();
        eventUUID = evt.getEventUUID();
        correlationId = evt.getCorrelationId();

        category = evt.getCategory();
        eventType = evt.getEventType();
        severity = evt.getSeverity();

        logMessage = evt.getLogMessage();
        logSource = evt.getLogSource();
        signedLogMessage = evt.getSignedLogMessage();
        logTimestamp = evt.getLogTimestamp();

        agentId = evt.getAgentId();
        agentTimestamp = evt.getAgentTimestamp();
        serverTimestamp = evt.getServerTimestamp();

        audit = evt.getAudit();
        auditSequenceNo = evt.getAuditSequenceNo();

        subject = evt.getSubject();
        customInfo = new LinkedHashMap<String, String>(evt.getCustomInfo());
    }
    
    public String getAgentId() {
        return agentId;
    }

    public Date getAgentTimestamp() {
        return agentTimestamp;
    }

    public Boolean getAudit() {
        return audit;
    }

    public Long getAuditSequenceNo() {
        return auditSequenceNo;
    }

    public String getCategory() {
        return category;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public Map<String, String> getCustomInfo() {
        return customInfo;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventUUID() {
        return eventUUID;
    }

    public Long getId() {
        return id;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public Map<String, String> getLogSource() {
        return logSource;
    }

    public Date getLogTimestamp() {
        return logTimestamp;
    }

    public Date getServerTimestamp() {
        return serverTimestamp;
    }

    public String getSeverity() {
        return severity;
    }

    public String getSignedLogMessage() {
        return signedLogMessage;
    }

    public String getSubject() {
        return subject;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public void setAgentTimestamp(Date agentTimestamp) {
        this.agentTimestamp = agentTimestamp;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public void setAuditSequenceNo(Long auditSequenceNo) {
        this.auditSequenceNo = auditSequenceNo;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setCustomInfo(Map<String, String> customInfo) {
        this.customInfo = customInfo;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventUUID(String eventUUID) {
        this.eventUUID = eventUUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public void setLogSource(Map<String, String> logSource) {
        this.logSource = logSource;
    }

    public void setLogTimestamp(Date logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    public void setServerTimestamp(Date serverTimestamp) {
        this.serverTimestamp = serverTimestamp;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setSignedLogMessage(String signedLogMessage) {
        this.signedLogMessage = signedLogMessage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
