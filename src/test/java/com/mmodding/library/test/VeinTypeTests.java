package com.mmodding.library.test;

import com.mmodding.library.block.api.util.RandomStateContainer;
import com.mmodding.library.container.api.AdvancedContainer;
import com.mmodding.library.core.api.MModdingRegistries;
import com.mmodding.library.registry.api.content.DefaultContentHolder;
import com.mmodding.library.worldgen.vein.api.VeinType;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class VeinTypeTests implements DefaultContentHolder {

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
	public void register(AdvancedContainer mod) {
		mod.withRegistry(MModdingRegistries.VEIN_TYPE.getOrCreateCompanion(ChunkGeneratorSettings.OVERWORLD)).execute(init -> {
			VeinTypeTests.FIRST_TYPE.register(init.createId("hi"));
			VeinTypeTests.SECOND_TYPE.register(init.createId("ih"));
		});
	}
}
