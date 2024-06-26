package com.mmodding.library.java.api.function.consumer;

@FunctionalInterface
public interface QuartConsumer<K, V, S, T> {

	void accept(K k, V v, S s, T t);
}
