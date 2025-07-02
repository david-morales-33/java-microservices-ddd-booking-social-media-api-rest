package com.dmx.profile.user_profile.application.find;

import com.dmx.profile.shared.domain.Service;
import com.dmx.profile.shared.domain.bus.query.QueryHandler;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;

@Service
public final class FindUserProfileQueryHandler implements QueryHandler<FindUserProfileQuery, UserProfileResponse> {

    private final UserProfileFinder finder;

    public FindUserProfileQueryHandler(UserProfileFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserProfileResponse handle(FindUserProfileQuery query) throws UserProfileNotFoundException {
        UserProfileId id = new UserProfileId(query.id());
        return this.finder.execute(id);
    }
}
