package com.mmodding.library.initializer;

import com.mmodding.library.container.api.AdvancedContainer;
import com.mmodding.library.core.api.MModdingLibrary;
import com.mmodding.library.core.impl.MModdingInitializer;
import com.mmodding.library.registry.api.ElementsManager;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public interface ExtendedModInitializer extends ModInitializer {

	static ElementsManager getManager(String modId) {
		return MModdingInitializer.MANAGERS.get(modId);
	}

	void setupManager(ElementsManager.Builder manager);

	@Override
	default void onInitialize(ModContainer mod) {
		ElementsManager.Builder builder = ElementsManager.Builder.common();
		this.setupManager(builder);
		ElementsManager manager = builder.build();
		MModdingLibrary.getAllManagers().put(mod.metadata().id(), manager);
		AdvancedContainer advanced = AdvancedContainer.of(mod);
		manager.initDefaultContent(advanced);
		this.onInitialize(advanced);
	}

	void onInitialize(AdvancedContainer mod);
}
