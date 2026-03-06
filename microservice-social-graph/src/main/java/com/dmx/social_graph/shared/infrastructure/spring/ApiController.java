package com.dmx.social_graph.shared.infrastructure.spring;

import com.dmx.social_graph.shared.domain.DomainException;
import com.dmx.social_graph.shared.domain.bus.command.Command;
import com.dmx.social_graph.shared.domain.bus.command.CommandBus;
import com.dmx.social_graph.shared.domain.bus.command.CommandHandlerExecutionException;
import com.dmx.social_graph.shared.domain.bus.query.Query;
import com.dmx.social_graph.shared.domain.bus.query.QueryBus;
import com.dmx.social_graph.shared.domain.bus.query.QueryHandlerExecutionException;
import org.springframework.http.HttpStatus;

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

    abstract public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping();
}
