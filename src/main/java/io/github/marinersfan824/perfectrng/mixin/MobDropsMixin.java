package io.github.marinersfan824.perfectrng.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class MobDropsMixin {

    @Shadow protected int playerHitTimer;

    @Shadow protected abstract void dropLoot(boolean allowDrops, int lootingMultiplier);

    @Redirect(method = "onKilled", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;dropLoot(ZI)V"))
    protected void method_7106(LivingEntity instance, boolean bl, int i) {
        int l = 0;
        LivingEntity entity = instance.getAttacker();
        if (entity instanceof PlayerEntity) {
            l = EnchantmentHelper.method_5498(entity);
        }

        if (instance instanceof EndermanEntity) {
            int amount = 1 + l;
            instance.dropItem(Items.ENDER_PEARL, amount);
        }
        else if (instance instanceof ChickenEntity) {
            int j = 2 + l;

            for(int k = 0; k < j; ++k) {
                instance.dropItem(Items.FEATHER, 1);
            }
            if (instance.isOnFire()) {
                instance.dropItem(Items.COOKED_CHICKEN, 1);
            } else {
                instance.dropItem(Items.CHICKEN, 1);
            }
        }
        else if (instance instanceof CowEntity) {
            int j = 2 + l;

            int k;
            for(k = 0; k < j; ++k) {
                instance.dropItem(Items.LEATHER, 1);
            }

            j = 3 + l;

            for(k = 0; k < j; ++k) {
                if (instance.isOnFire()) {
                    instance.dropItem(Items.COOKED_BEEF, 1);
                } else {
                    instance.dropItem(Items.BEEF, 1);
                }
            }
        }
        else if (instance instanceof SheepEntity) {
            if (!((SheepEntity) instance).isSheared()) {
                instance.dropItem(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, ((SheepEntity) instance).getColor().getId()), 0.0F);
            }

            int j = 2 + l;

            for(int k = 0; k < j; ++k) {
                if (instance.isOnFire()) {
                    instance.dropItem(Items.COOKED_MUTTON, 1);
                } else {
                    instance.dropItem(Items.MUTTON, 1);
                }
            }
        }
        else if (instance instanceof PigEntity) {
            int j = 3 + l;

            for(int k = 0; k < j; ++k) {
                if (instance.isOnFire()) {
                    instance.dropItem(Items.COOKED_PORKCHOP, 1);
                } else {
                    instance.dropItem(Items.RAW_PORKCHOP, 1);
                }
            }

            if (((PigEntity) instance).isSaddled()) {
                instance.dropItem(Items.SADDLE, 1);
            }
        }
        else if (instance instanceof SpiderEntity) {
            int amount = 2 + l;
            instance.dropItem(Items.STRING, amount);
            if (bl) {
                instance.dropItem(Items.SPIDER_EYE, 1);
            }
        }
        else {
            this.dropLoot(this.playerHitTimer > 0, l);
        }
    }
}
