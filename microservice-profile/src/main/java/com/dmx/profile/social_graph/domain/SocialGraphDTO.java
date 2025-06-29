package com.dmx.profile.social_graph.domain;

public record SocialGraphDTO(
        String id,
        Double follows,
        Double followers,
        Double matches,
        Float rating,
        Double bloquedUsers,
        Double mutedUsers,
        Double favoriteUsers
) {
}
