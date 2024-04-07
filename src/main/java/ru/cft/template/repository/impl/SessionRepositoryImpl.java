package ru.cft.template.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.cft.template.dto.SessionDto;
import ru.cft.template.repository.SessionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class SessionRepositoryImpl implements SessionRepository {

    private final Map<String, SessionDto> sessionMap = new HashMap<>();

    private static int counter = 0;

    @Override
    public List<SessionDto> getSessionsRep(String userId) {
        return new ArrayList<>(sessionMap.values());
    }

    @Override
    public SessionDto getCurrentSessionFromRep(String userId) {
        return sessionMap.get(userId);
    }

    @Override
    public void addSessionToRep(SessionDto session) {
        counter += 1;
        String walletId = String.valueOf(counter);
        session.setId(walletId);
        sessionMap.put(walletId, session);
    }

    @Override
    public void deleteSessionFromRep(String id) {
        sessionMap.remove(id);
    }
}
