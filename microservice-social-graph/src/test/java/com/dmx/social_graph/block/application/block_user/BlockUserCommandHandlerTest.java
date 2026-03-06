package com.dmx.social_graph.block.application.block_user;

import com.dmx.social_graph.block.BlockUnitTestCase;
import com.dmx.social_graph.block.domain.Block;
import com.dmx.social_graph.block.domain.BlockTest;
import com.dmx.social_graph.block.domain.UserBlockNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public final class BlockUserCommandHandlerTest extends BlockUnitTestCase {

    private BlockUserCommandHandler handler;

    @BeforeEach
    void ssetup(){
        super.setUp();
        handler = new BlockUserCommandHandler(new UserBlocker(repository));
    }

    @Test
    void it_should_block_a_user() {
        // GIVEN
        Block block = BlockTest.random();
        BlockUserCommand command = BlockUserCommandMother.create(block.getUserId().value(), block.getBlockedId().value());

        // WHEN
        shouldNotAnswerBlockUser(block);
        handler.handle(command);

        // THEN
        shouldVerifyExistsByUsers(block);
        shouldVerifySave(block);
    }

    @Test
    void it_should_not_block_a_user_if_already_blocked() {
        // GIVEN
        Block block = BlockTest.random();
        BlockUserCommand command = BlockUserCommandMother.create(block.getUserId().value(), block.getBlockedId().value());

        // WHEN
        shouldAnswerBlockUser(block);

        // THEN
        assertThrows(UserBlockNotAllowedException.class, () -> handler.handle(command));
    }
}
