package com.mmodding.library.core.api.management.content;

import com.mmodding.library.core.impl.management.content.ForBeingPredicatedImpl;
import com.mmodding.library.core.impl.management.content.ForBeingVacantImpl;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ForBeing<T> {

	static <T> ForBeing.Vacant<T> vacant() {
		return new ForBeingVacantImpl<>();
	}

	static <T> ForBeing.Predicated<T> predicated(Supplier<T> initializer) {
		return new ForBeingPredicatedImpl<>(initializer);
	}

	boolean isInitialized();

	T get();

	T orElse(T t);

	void execute(Consumer<T> t);

	interface Vacant<T> extends ForBeing<T> {

		void initialize(Supplier<T> initializer);
	}

	interface Predicated<T> extends ForBeing<T> {

		void initialize();
	}
}
