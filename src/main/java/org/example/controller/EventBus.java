package org.example.controller;

import java.util.*;

public final class EventBus {
    private static final Map<Class<?>, List<EventListener<?>>> LISTENER = new HashMap<>();

    public static <T> void register(Class<T> type, EventListener<T> listener){
        LISTENER.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
    }

    @SuppressWarnings("unchecked")
    public static <T> void post(T event){
        var list = LISTENER.getOrDefault(event.getClass(), List.of());
        for(EventListener<?> l : list)
            ((EventListener<T>) l).onEvent(event);
    }

    @FunctionalInterface public interface EventListener<T> { void onEvent(T evt); }
}