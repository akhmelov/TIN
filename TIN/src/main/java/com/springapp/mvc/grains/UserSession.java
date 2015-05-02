package com.springapp.mvc.grains;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author asmolik
 */
@Component
@Scope("session")
public class UserSession
{
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
}
