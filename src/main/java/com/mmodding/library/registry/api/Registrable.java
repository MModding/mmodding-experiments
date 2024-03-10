package com.mmodding.library.registry.api;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface Registrable<T> {

	default void register(Registry<T> registry, Identifier identifier) {
		Registry.register(registry, identifier, this.as());
	}

	default void register(RegistryPushable<T> pushable) {
		this.register(pushable.getRegistry(), pushable.getIdentifier());
	}

	default RegistrationStatus getRegistrationStatus() {
		throw new AssertionError();
	}

	default T as() {
		throw new IllegalStateException();
	}
}
