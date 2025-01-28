package com.teeles.tol.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private Map<String, List<EventListener>> listenersMap = new HashMap<>();

    public void subscribe(String eventType, EventListener listener) {
        listenersMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> listeners = listenersMap.get(eventType);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    public void publish(Event event) {
        List<EventListener> listeners = listenersMap.get(event.getEventType());
        if (listeners != null) {
            for (EventListener listener : listeners) {
                System.out.println("The list is not empty");
                listener.onEvent(event);
            }
        }
    }
}
