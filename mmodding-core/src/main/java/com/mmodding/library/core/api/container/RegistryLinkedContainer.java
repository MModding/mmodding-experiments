package com.mmodding.library.core.api.container;

import com.mmodding.library.core.api.registry.pushable.RegistryPushable;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface RegistryLinkedContainer<I> {

	Registry<I> getRegistry();

	AdvancedContainer getContainer();

	default RegistryPushable<I> createId(String path) {

		return new RegistryPushable<>() {

			@Override
			public Registry<I> getRegistry() {
				return RegistryLinkedContainer.this.getRegistry();
			}

			@Override
			public Identifier getIdentifier() {
				return RegistryLinkedContainer.this.getContainer().createId(path);
			}
		};
	}
}
