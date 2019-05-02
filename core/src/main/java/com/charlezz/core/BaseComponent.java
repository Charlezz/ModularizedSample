package com.charlezz.core;

public interface BaseComponent<T> {
    void inject(T target);
}
