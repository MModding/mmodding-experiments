package com.mmodding.library.worldgen.test;

import com.mmodding.library.block.api.util.RandomStateContainer;
import com.mmodding.library.core.api.container.AdvancedContainer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.library.core.api.management.initializer.ExtendedModInitializer;
import com.mmodding.library.worldgen.api.vein.VeinType;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class VeinTypeTests implements ExtendedModInitializer {

	public static final VeinType FIRST_TYPE = new VeinType.Builder(
		-32, 32,
		RandomStateContainer.create(Blocks.AIR),
		RandomStateContainer.create(Blocks.AIR),
		RandomStateContainer.create(Blocks.AIR)
	).build();

	public static final VeinType SECOND_TYPE = new VeinType.Builder(
		-16, 16,
		RandomStateContainer.create(Blocks.BEDROCK),
		RandomStateContainer.create(Blocks.BEDROCK),
		RandomStateContainer.create(Blocks.BEDROCK)
	).build();

	@Override
	public void setupManager(ElementsManager.Builder manager) {
		manager.content(VeinTypeTests::register);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {}

	public static void register(AdvancedContainer mod) {
		mod.withRegistry(VeinType.REGISTRY.getOrCreateCompanion(ChunkGeneratorSettings.OVERWORLD)).execute(init -> {
			VeinTypeTests.FIRST_TYPE.register(init.createId("hi"));
			VeinTypeTests.SECOND_TYPE.register(init.createId("ih"));
		});
	}
}
