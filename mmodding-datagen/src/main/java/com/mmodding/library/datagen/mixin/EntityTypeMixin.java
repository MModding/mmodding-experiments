package com.mmodding.library.datagen.mixin;

import com.mmodding.library.datagen.api.lang.LangContainer;
import com.mmodding.library.datagen.api.lang.LangProcessor;
import com.mmodding.library.datagen.impl.access.LangProcessorAccess;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EntityType.class)
@SuppressWarnings("AddedMixinMembersNamePattern")
public class EntityTypeMixin<E extends Entity> implements LangContainer, LangProcessorAccess<EntityType<E>> {

	@Unique
	public LangProcessor<EntityType<E>> langProcessor = LangProcessor.standard();

	@Override
	@SuppressWarnings("unchecked")
	public <T> T lang(LangProcessor<T> processor) {
		this.langProcessor = (LangProcessor<EntityType<E>>) processor;
		return (T) this;
	}

	@Override
	public Type type() {
		return Type.ITEM;
	}

	@Override
	public LangProcessor<EntityType<E>> processor() {
		return this.langProcessor;
	}
}
