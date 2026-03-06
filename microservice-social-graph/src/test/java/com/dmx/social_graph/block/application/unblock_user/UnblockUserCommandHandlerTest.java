package com.dmx.social_graph.block.application.unblock_user;

import com.dmx.social_graph.block.BlockUnitTestCase;
import com.dmx.social_graph.block.domain.Block;
import com.dmx.social_graph.block.domain.BlockTest;
import com.dmx.social_graph.block.domain.UserBlockNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class UnblockUserCommandHandlerTest extends BlockUnitTestCase {

    private UnblockUserCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new UnblockUserCommandHandler(new UserUnblocker(repository));
    }

    @Test
    void it_should_unblock_a_user() {
        // GIVEN
        Block block = BlockTest.random();
        UnblockUserCommand command = UnblockUserCommandMother.create(block.getUserId().value(), block.getBlockedId().value());

        // WHEN
        shouldAnswerBlockUser(block);
        shouldAnswerFindByUsers(block);
        handler.handle(command);

        // THEN
        shouldVerifyDelete(block);
    }

    @Test
    void it_should_not_unblock_a_user_if_not_blocked() {
        // GIVEN
        Block block = BlockTest.random();
        UnblockUserCommand command = UnblockUserCommandMother.create(block.getUserId().value(), block.getBlockedId().value());

        // WHEN
        shouldNotAnswerBlockUser(block);

        // THEN
        assertThrows(UserBlockNotAllowedException.class, () -> handler.handle(command));
    }
}
