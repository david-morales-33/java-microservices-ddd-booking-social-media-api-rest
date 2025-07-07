package com.dmx.profile.shared.infrastructure.spring;

import org.springframework.http.HttpStatus;
import com.dmx.profile.shared.domain.DomainError;
import com.dmx.profile.shared.domain.bus.command.Command;
import com.dmx.profile.shared.domain.bus.command.CommandBus;
import com.dmx.profile.shared.domain.bus.command.CommandHandlerExecutionException;
import com.dmx.profile.shared.domain.bus.query.Query;
import com.dmx.profile.shared.domain.bus.query.QueryBus;
import com.dmx.profile.shared.domain.bus.query.QueryHandlerExecutionException;

import java.util.HashMap;

public abstract class ApiController {
    private final QueryBus   queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionException {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionException {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
