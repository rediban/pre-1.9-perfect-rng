package io.github.marinersfan824.perfectrng.mixin;

import io.github.marinersfan824.perfectrng.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.passive.AgeableEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TraderOfferList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;


@Mixin(VillagerEntity.class)
public abstract class TradingMixin extends AgeableEntity {
    @Shadow
    @Final
    @Mutable
    private static final VillagerEntity.TradeProvider[][][][] TRADES;

    public TradingMixin(World world) {
        super(world);
    }

    @Shadow public abstract int profession();

    @Shadow private int career;

    @Shadow protected abstract String getAmbientSound();

    @Shadow public int riches;

    @Shadow public int field_3956;

    @Shadow public boolean field_3948;

    @Shadow public boolean willingToMate;

    @Shadow public PlayerEntity customer;

    @Shadow public String field_5395;

    @Shadow private TraderOfferList offers;

    @Shadow private int careerLevel;

    static {
        TRADES = new VillagerEntity.TradeProvider[][][][]{{{{
            new VillagerEntity.ItemTradeEntry(Items.WHEAT, new VillagerEntity.Cost(18, 22)),
                new VillagerEntity.ItemTradeEntry(Items.POTATO, new VillagerEntity.Cost(15, 15)),
                new VillagerEntity.ItemTradeEntry(Items.CARROT, new VillagerEntity.Cost(15, 15)),
                new VillagerEntity.ItemStackTradeEntry(Items.BREAD, new VillagerEntity.Cost(-4, -2))},
                {new VillagerEntity.ItemTradeEntry(Item.fromBlock(Blocks.PUMPKIN), new VillagerEntity.Cost(8, 13)),
                        new VillagerEntity.ItemStackTradeEntry(Items.PUMPKIN_PIE, new VillagerEntity.Cost(-3, -2))},
                {new VillagerEntity.ItemTradeEntry(Item.fromBlock(Blocks.MELON_BLOCK), new VillagerEntity.Cost(7, 12)),
                        new VillagerEntity.ItemStackTradeEntry(Items.APPLE, new VillagerEntity.Cost(-5, -7))},
                {new VillagerEntity.ItemTradeEntry(Items.COOKIE, new VillagerEntity.Cost(-6, -10)),
                        new VillagerEntity.ItemStackTradeEntry(Items.CAKE, new VillagerEntity.Cost(1, 1))}},
                {{new VillagerEntity.ItemTradeEntry(Items.STRING, new VillagerEntity.Cost(15, 20)),
                        new VillagerEntity.ItemTradeEntry(Items.COAL, new VillagerEntity.Cost(16, 24)),
                        new VillagerEntity.EmeraldToItem(Items.RAW_FISH, new VillagerEntity.Cost(6, 6), Items.COOKED_FISH, new VillagerEntity.Cost(6, 6))},
                        {new VillagerEntity.EnchantedItemStackTradeEntry(Items.FISHING_ROD, new VillagerEntity.Cost(7, 8))}},
                {{new VillagerEntity.ItemTradeEntry(Item.fromBlock(Blocks.WOOL), new VillagerEntity.Cost(16, 22)),
                        new VillagerEntity.ItemStackTradeEntry(Items.SHEARS, new VillagerEntity.Cost(3, 4))},
                        {new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 0), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 1), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 2), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 3), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 4), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 5), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 6), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 7), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 8), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 9), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 10), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 11), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 12), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 13), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 14), new VillagerEntity.Cost(1, 2)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Item.fromBlock(Blocks.WOOL), 1, 15), new VillagerEntity.Cost(1, 2))}},
                {{new VillagerEntity.ItemTradeEntry(Items.STRING, new VillagerEntity.Cost(15, 20)),
                        new VillagerEntity.ItemStackTradeEntry(Items.ARROW, new VillagerEntity.Cost(-12, -12))},
                        {new VillagerEntity.ItemStackTradeEntry(Items.BOW, new VillagerEntity.Cost(2, 2)),
                                new VillagerEntity.EmeraldToItem(Item.fromBlock(Blocks.GRAVEL), new VillagerEntity.Cost(10, 10), Items.FLINT, new VillagerEntity.Cost(6, 10))}}},
                {{{new VillagerEntity.ItemTradeEntry(Items.PAPER, new VillagerEntity.Cost(24, 24)), new VillagerEntity.EnchantedBook()},
                        {new VillagerEntity.ItemTradeEntry(Items.BOOK, new VillagerEntity.Cost(8, 8)),
                                new VillagerEntity.ItemStackTradeEntry(Items.COMPASS, new VillagerEntity.Cost(10, 12)),
                                new VillagerEntity.ItemStackTradeEntry(Item.fromBlock(Blocks.BOOKSHELD), new VillagerEntity.Cost(3, 4))},
                        {new VillagerEntity.ItemTradeEntry(Items.WRITTEN_BOOK, new VillagerEntity.Cost(2, 2)),
                                new VillagerEntity.ItemStackTradeEntry(Items.CLOCK, new VillagerEntity.Cost(10, 12)),
                                new VillagerEntity.ItemStackTradeEntry(Item.fromBlock(Blocks.GLASS), new VillagerEntity.Cost(-5, -3))},
                        {new VillagerEntity.EnchantedBook()}, {new VillagerEntity.EnchantedBook()},
                        {new VillagerEntity.ItemStackTradeEntry(Items.NAME_TAG, new VillagerEntity.Cost(20, 22))}}},
                {{{new VillagerEntity.ItemTradeEntry(Items.ROTTEN_FLESH, new VillagerEntity.Cost(36, 36)),
                        new VillagerEntity.ItemTradeEntry(Items.GOLD_INGOT, new VillagerEntity.Cost(8, 8))},
                        {new VillagerEntity.ItemStackTradeEntry(Items.REDSTONE, new VillagerEntity.Cost(-4, -1)),
                                new VillagerEntity.ItemStackTradeEntry(new ItemStack(Items.DYE, 1, DyeColor.BLUE.getSwappedId()), new VillagerEntity.Cost(-2, -1))},
                        {new VillagerEntity.ItemStackTradeEntry(Items.EYE_OF_ENDER, new VillagerEntity.Cost(7, 7)),
                                new VillagerEntity.ItemStackTradeEntry(Item.fromBlock(Blocks.GLOWSTONE), new VillagerEntity.Cost(-3, -1))},
                        {new VillagerEntity.ItemStackTradeEntry(Items.EXPERIENCE_BOTTLE, new VillagerEntity.Cost(3, 11))}}},
                {{{new VillagerEntity.ItemTradeEntry(Items.COAL, new VillagerEntity.Cost(16, 24)),
                        new VillagerEntity.ItemStackTradeEntry(Items.IRON_HELMET, new VillagerEntity.Cost(4, 6))},
                        {new VillagerEntity.ItemTradeEntry(Items.IRON_INGOT, new VillagerEntity.Cost(7, 9)),
                                new VillagerEntity.ItemStackTradeEntry(Items.IRON_CHESTPLATE, new VillagerEntity.Cost(10, 14))},
                        {new VillagerEntity.ItemTradeEntry(Items.DIAMOND, new VillagerEntity.Cost(3, 4)),
                                new VillagerEntity.EnchantedItemStackTradeEntry(Items.DIAMOND_CHESTPLATE, new VillagerEntity.Cost(16, 19))},
                        {new VillagerEntity.ItemStackTradeEntry(Items.CHAINMAIL_BOOTS, new VillagerEntity.Cost(5, 7)),
                                new VillagerEntity.ItemStackTradeEntry(Items.CHAINMAIL_LEGGINGS, new VillagerEntity.Cost(9, 11)),
                                new VillagerEntity.ItemStackTradeEntry(Items.CHAINMAIL_HELMET, new VillagerEntity.Cost(5, 7)),
                                new VillagerEntity.ItemStackTradeEntry(Items.CHAINMAIL_CHESTPLATE, new VillagerEntity.Cost(11, 15))}},
                        {{new VillagerEntity.ItemTradeEntry(Items.COAL, new VillagerEntity.Cost(16, 24)),
                                new VillagerEntity.ItemStackTradeEntry(Items.IRON_AXE, new VillagerEntity.Cost(6, 8))},
                                {new VillagerEntity.ItemTradeEntry(Items.IRON_INGOT, new VillagerEntity.Cost(7, 9)),
                                        new VillagerEntity.EnchantedItemStackTradeEntry(Items.IRON_SWORD, new VillagerEntity.Cost(9, 10))},
                                {new VillagerEntity.ItemTradeEntry(Items.DIAMOND, new VillagerEntity.Cost(3, 4)),
                                        new VillagerEntity.EnchantedItemStackTradeEntry(Items.DIAMOND_SWORD, new VillagerEntity.Cost(12, 15)),
                                        new VillagerEntity.EnchantedItemStackTradeEntry(Items.DIAMOND_AXE, new VillagerEntity.Cost(9, 12))}},
                        {{new VillagerEntity.ItemTradeEntry(Items.COAL, new VillagerEntity.Cost(16, 24)),
                                new VillagerEntity.EnchantedItemStackTradeEntry(Items.IRON_SHOVEL, new VillagerEntity.Cost(5, 7))},
                                {new VillagerEntity.ItemTradeEntry(Items.IRON_INGOT, new VillagerEntity.Cost(7, 9)),
                                        new VillagerEntity.EnchantedItemStackTradeEntry(Items.IRON_PICKAXE, new VillagerEntity.Cost(9, 11))},
                                {new VillagerEntity.ItemTradeEntry(Items.DIAMOND, new VillagerEntity.Cost(3, 4)),
                                        new VillagerEntity.EnchantedItemStackTradeEntry(Items.DIAMOND_PICKAXE, new VillagerEntity.Cost(12, 15))}}},
                {{{new VillagerEntity.ItemTradeEntry(Items.RAW_PORKCHOP, new VillagerEntity.Cost(14, 18)),
                        new VillagerEntity.ItemTradeEntry(Items.CHICKEN, new VillagerEntity.Cost(14, 18))},
                        {new VillagerEntity.ItemTradeEntry(Items.COAL, new VillagerEntity.Cost(16, 24)),
                                new VillagerEntity.ItemStackTradeEntry(Items.COOKED_PORKCHOP, new VillagerEntity.Cost(-7, -5)),
                                new VillagerEntity.ItemStackTradeEntry(Items.COOKED_CHICKEN, new VillagerEntity.Cost(-8, -6))}},
                        {{new VillagerEntity.ItemTradeEntry(Items.LEATHER, new VillagerEntity.Cost(9, 12)),
                                new VillagerEntity.ItemStackTradeEntry(Items.LEATHER_LEGGINGS, new VillagerEntity.Cost(2, 4))},
                                {new VillagerEntity.EnchantedItemStackTradeEntry(Items.LEATHER_CHESTPLATE, new VillagerEntity.Cost(7, 12))},
                                {new VillagerEntity.ItemStackTradeEntry(Items.SADDLE, new VillagerEntity.Cost(8, 10))}}}};
    }
    /**
     * @author marinersfan824
     * @reason this was the only way i could get working to change villager careers
     */
    @Overwrite
    private void getOffers() {
        VillagerEntity.TradeProvider[][][] tradeProviders = TRADES[this.profession()];
        if (this.career != 0 && this.careerLevel != 0) {
            ++this.careerLevel;
        } else {
            if (this.profession() == 0 && Main.numConverted <= 1) {
                if (Main.numConverted == 0) {
                    this.career = 1;
                    Main.numConverted++;
                } else if (Main.numConverted == 1){
                    this.career = 4;
                    Main.numConverted++;
                }
            } else {
                this.career = this.random.nextInt(tradeProviders.length) + 1;
            }
            this.careerLevel = 1;
        }

        if (this.offers == null) {
            this.offers = new TraderOfferList();
        }

        int i = this.career - 1;
        int j = this.careerLevel - 1;
        VillagerEntity.TradeProvider[][] tradeProviders2 = tradeProviders[i];
        if (j >= 0 && j < tradeProviders2.length) {
            VillagerEntity.TradeProvider[] tradeProviders3 = tradeProviders2[j];
            VillagerEntity.TradeProvider[] tradeProviders4 = tradeProviders3;
            int k = tradeProviders3.length;

            for(int l = 0; l < k; ++l) {
                VillagerEntity.TradeProvider tradeProvider = tradeProviders4[l];
                tradeProvider.convert(this.offers, this.random);
            }
        }
    }
    /**
     * @author marinersfan824
     * @reason remove trading hardlocks
     */
    @Overwrite
    public void trade(TradeOffer offer) {
        offer.use();
        this.ambientSoundChance = -this.getMinAmbientSoundDelay();
        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
        int i = 3 + this.random.nextInt(4);
        if (true) {
            this.field_3956 = 40;
            this.field_3948 = true;
            this.willingToMate = true;
            if (this.customer != null) {
                this.field_5395 = this.customer.getTranslationKey();
            } else {
                this.field_5395 = null;
            }

            i += 5;
        }

        if (offer.getFirstStack().getItem() == Items.EMERALD) {
            this.riches += offer.getFirstStack().count;
        }

        if (offer.shouldRewardPlayerExperience()) {
            this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.x, this.y + 0.5D, this.z, i));
        }
    }
}