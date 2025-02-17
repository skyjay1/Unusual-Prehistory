package com.peeko32213.unusualprehistory.client.model;


import com.peeko32213.unusualprehistory.UnusualPrehistory;
import com.peeko32213.unusualprehistory.common.entity.EntityDunkleosteus;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DunkleosteusModel extends AnimatedGeoModel<EntityDunkleosteus>
{
    @Override
    public ResourceLocation getModelLocation(EntityDunkleosteus object)
    {
        return new ResourceLocation(UnusualPrehistory.MODID, "geo/dunkleosteus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDunkleosteus object)
    {
        return new ResourceLocation(UnusualPrehistory.MODID, "textures/entity/dunk.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityDunkleosteus object)
    {
        return new ResourceLocation(UnusualPrehistory.MODID, "animations/dunk.animation.json");
    }

    @Override
    public void setLivingAnimations(EntityDunkleosteus entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("Body");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        if (!entity.isInWater()) {
            body.setRotationZ(1.5708f);
        }
        else {
            body.setRotationX(extraData.headPitch * (float)Math.PI / 320F);
            body.setRotationY(extraData.netHeadYaw * (float)Math.PI / 320F);
        }
    }

}

