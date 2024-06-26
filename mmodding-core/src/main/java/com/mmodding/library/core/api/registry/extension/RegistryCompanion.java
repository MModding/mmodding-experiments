package com.mmodding.library.core.api.registry.extension;

import com.mmodding.library.core.api.registry.LiteRegistry;
import com.mmodding.library.core.impl.registry.companion.RegistryCompanionImpl;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public interface RegistryCompanion<T, E> {

	static <T, E> RegistryCompanion<T, E> create(BiFunction<DynamicRegistryManager, T, RegistryKey<T>> retriever) {
		return new RegistryCompanionImpl<>(retriever);
	}

	LiteRegistry<E> getOrCreateCompanion(T object);

	LiteRegistry<E> getOrCreateCompanion(@Nullable DynamicRegistryManager manager, T object);

	LiteRegistry<E> getOrCreateCompanion(RegistryKey<T> key);

	LiteRegistry<E> getCompanion(T object);

	LiteRegistry<E> getCompanion(@Nullable DynamicRegistryManager manager, T object);

	LiteRegistry<E> getCompanion(RegistryKey<T> key);
}
