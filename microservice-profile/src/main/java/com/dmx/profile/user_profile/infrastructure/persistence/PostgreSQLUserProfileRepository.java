package com.dmx.profile.user_profile.infrastructure.persistence;

import com.dmx.profile.shared.domain.Service;
import com.dmx.profile.shared.domain.criteria.Criteria;
import com.dmx.profile.shared.infrastructure.hibernate.HibernateRepository;
import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("")
public class PostgreSQLUserProfileRepository extends HibernateRepository<UserProfile> implements UserProfileRepository {
    public PostgreSQLUserProfileRepository(@Qualifier("") SessionFactory sessionFactory) {
        super(sessionFactory, UserProfile.class);
    }

    @Override
    public void save(UserProfile profile) {
        persist(profile);
    }

    @Override
    public Optional<UserProfile> find(UserProfileId id) {
        return byId(id);
    }

    @Override
    public List<UserProfile> match(Criteria criteria) {
        return List.of();
    }
}
