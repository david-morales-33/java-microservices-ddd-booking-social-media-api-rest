package com.dmx.social_graph.block;

import com.dmx.social_graph.block.domain.Block;
import com.dmx.social_graph.block.domain.BlockRepository;
import com.dmx.social_graph.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class BlockUnitTestCase extends UnitTestCase {

    protected BlockRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(BlockRepository.class);
    }

    public void shouldVerifySave(Block block) {
        verify(repository).save(block);
    }

    public void shouldVerifyDelete(Block block) {
        verify(repository).delete(block);
    }

    public void shouldVerifyExistsByUsers(Block block) {
        verify(repository).existsByUsers(block.getUserId(), block.getBlockedId());
    }

    public void shouldAnswerBlockUser(Block block) {
        when(repository.existsByUsers(block.getUserId(), block.getBlockedId())).thenReturn(true);
    }

    public void shouldNotAnswerBlockUser(Block block) {
        when(repository.existsByUsers(block.getUserId(), block.getBlockedId())).thenReturn(false);
    }

    public void shouldAnswerFindByUsers(Block block) {
        when(repository.findByUsers(block.getUserId(), block.getBlockedId())).thenReturn(Optional.of(block));
    }

    public void shouldNotAnswerFindByUsers(Block block) {
        when(repository.findByUsers(block.getUserId(), block.getBlockedId())).thenReturn(Optional.empty());
    }
}
