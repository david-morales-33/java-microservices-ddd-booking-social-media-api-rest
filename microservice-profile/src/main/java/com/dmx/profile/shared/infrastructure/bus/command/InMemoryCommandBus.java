package com.dmx.profile.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import com.dmx.profile.shared.domain.Service;
import com.dmx.profile.shared.domain.bus.command.Command;
import com.dmx.profile.shared.domain.bus.command.CommandBus;
import com.dmx.profile.shared.domain.bus.command.CommandHandler;
import com.dmx.profile.shared.domain.bus.command.CommandHandlerExecutionException;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionException {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionException(error);
        }
    }
}
