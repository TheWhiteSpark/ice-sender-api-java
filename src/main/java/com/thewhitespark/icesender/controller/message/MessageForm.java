package com.thewhitespark.icesender.controller.message;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageForm {

    @Min(0)
    private int offset;

    @Max(100)
    @Min(0)
    private int limit;

    @Enumerated(EnumType.STRING)
    private MessageType type;

    @Enumerated(EnumType.STRING)
    private MessageOrder order;

    public MessageForm(){}

    public MessageForm(int offset, int limit, MessageType type, MessageOrder order) {
        this.offset = offset;
        this.limit = limit;
        this.type = type;
        this.order = order;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public MessageOrder getOrder() {
        return order;
    }

    public void setOrder(MessageOrder order) {
        this.order = order;
    }
}

