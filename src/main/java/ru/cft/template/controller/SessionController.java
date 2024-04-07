package ru.cft.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.template.dto.SessionDto;
import ru.cft.template.service.SessionService;

import java.util.List;

@RestController
@RequestMapping("users")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{userId}/sessions")
    public ResponseEntity<List<SessionDto>> getSessionsForUser(@PathVariable String userId) {
        List<SessionDto> sessions = sessionService.getSessions(userId);
        if (sessions != null) {
            return ResponseEntity.ok(sessions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}/sessions/current")
    public ResponseEntity<SessionDto> getCurrentSessionForUser(@PathVariable String userId) {
        SessionDto session = sessionService.getCurrent(userId);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("sessions")
    public ResponseEntity<Void> addSession(@RequestBody SessionDto session) {
        sessionService.addSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("sessions/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
