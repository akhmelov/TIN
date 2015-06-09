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
    public enum Who {Promoter, Admin, None};

    private Who who = Who.None;
    private long id;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Who getWho()
    {
        return who;
    }

    public void setWho(Who who)
    {
        this.who = who;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
