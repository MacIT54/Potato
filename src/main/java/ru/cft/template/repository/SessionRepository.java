package ru.cft.template.repository;

import org.springframework.stereotype.Repository;
import ru.cft.template.dto.SessionDto;

import java.util.List;

@Repository
public interface SessionRepository {

    List<SessionDto> getSessionsRep(String userId);

    SessionDto getCurrentSessionFromRep(String userId);

    void addSessionToRep(SessionDto session);

    void deleteSessionFromRep(String id);
}
