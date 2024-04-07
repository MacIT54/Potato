package ru.cft.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.template.dto.SessionDto;
import ru.cft.template.repository.SessionRepository;
import ru.cft.template.service.SessionService;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    @Autowired
    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SessionDto> getSessions(String userId) {
        return repository.getSessionsRep(userId);
    }

    @Override
    public SessionDto getCurrent(String userId) {
        return repository.getCurrentSessionFromRep(userId);
    }

    @Override
    public void addSession(SessionDto session) {
        repository.addSessionToRep(session);
    }

    @Override
    public void deleteSession(String id) {
        repository.deleteSessionFromRep(id);
    }
}
