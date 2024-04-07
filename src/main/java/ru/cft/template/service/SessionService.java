package ru.cft.template.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.cft.template.dto.SessionDto;

import java.util.List;

public interface SessionService {
    List<SessionDto> getSessions(String userId);

    SessionDto getCurrent(@PathVariable String userId);

    void addSession(SessionDto session);

    void deleteSession(String id);
}
