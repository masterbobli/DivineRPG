package divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import divinerpg.enums.ArmorInfo;
import divinerpg.enums.ArrowType;
import divinerpg.enums.BulletType;
import divinerpg.enums.EnumArmor;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import divinerpg.objects.items.arcana.ItemAquamarine;
import divinerpg.objects.items.arcana.ItemArcanaPotion;
import divinerpg.objects.items.arcana.ItemArcaniteBlade;
import divinerpg.objects.items.arcana.ItemArcaniteBlaster;
import divinerpg.objects.items.arcana.ItemArcaniumSaber;
import divinerpg.objects.items.arcana.ItemAttractor;
import divinerpg.objects.items.arcana.ItemCaptainsSparkler;
import divinerpg.objects.items.arcana.ItemChargedCollector;
import divinerpg.objects.items.arcana.ItemDivineAccumulator;
import divinerpg.objects.items.arcana.ItemEnderScepter;
import divinerpg.objects.items.arcana.ItemFirefly;
import divinerpg.objects.items.arcana.ItemGeneralsStaff;
import divinerpg.objects.items.arcana.ItemGhostbane;
import divinerpg.objects.items.arcana.ItemGrenade;
import divinerpg.objects.items.arcana.ItemKey;
import divinerpg.objects.items.arcana.ItemLaVekor;
import divinerpg.objects.items.arcana.ItemLamona;
import divinerpg.objects.items.arcana.ItemMeriksMissile;
import divinerpg.objects.items.arcana.ItemMeteorMash;
import divinerpg.objects.items.arcana.ItemOrbOfLight;
import divinerpg.objects.items.arcana.ItemReflector;
import divinerpg.objects.items.arcana.ItemShadowSaber;
import divinerpg.objects.items.arcana.ItemStaffEnrichment;
import divinerpg.objects.items.arcana.ItemStaffStarlight;
import divinerpg.objects.items.arcana.ItemStormSword;
import divinerpg.objects.items.arcana.ItemWizardsBook;
import divinerpg.objects.items.arcana.ItemZelusSpawnEgg;
import divinerpg.objects.items.base.*;
import divinerpg.objects.items.iceika.ItemEggNog;
import divinerpg.objects.items.iceika.ItemMusicShooter;
import divinerpg.objects.items.iceika.ItemSerenadeOfIce;
import divinerpg.objects.items.iceika.ItemSnowGlobe;
import divinerpg.objects.items.twilight.ItemSkyFlower;
import divinerpg.objects.items.twilight.ItemTwilightBlitz;
import divinerpg.objects.items.twilight.ItemTwilightClock;
import divinerpg.objects.items.twilight.ItemTwilightSpawner;
import divinerpg.objects.items.vanilla.*;
import divinerpg.utils.ChatFormats;
import divinerpg.utils.GenerateJSON;
import divinerpg.utils.ToolMaterialMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Vanilla Weapons
    public static Item slimeSword = new ItemModSword(ToolMaterialMod.Slime, "slime_sword");
    public static Item oceanKnife = new ItemModSword(ToolMaterialMod.OceanKnife, "ocean_knife");
    public static Item aquaticMaul = new ItemModSword(ToolMaterialMod.AquaMaul, "aqua_maul");
    public static Item arlemiteStabber = new ItemModSword(ToolMaterialMod.Arlemite, "arlemite_stabber");
    public static Item bedrockSword = new ItemModSword(ToolMaterialMod.Bedrock, "bedrock_sword");
    public static Item realmiteSword = new ItemModSword(ToolMaterialMod.Realmite, "realmite_sword");
    public static Item rupeeSword = new ItemModSword(ToolMaterialMod.Rupee, "rupee_rapier");
    public static Item sandslash = new ItemModSword(ToolMaterialMod.Sandslash, "sandslash");
    public static Item divineSword = new ItemModSword(ToolMaterialMod.Divine, "divine_sword");
    public static Item blueDivineSword = new ItemModSword(ToolMaterialMod.Divine, "blue_divine_sword");
    public static Item yellowDivineSword = new ItemModSword(ToolMaterialMod.Divine, "yellow_divine_sword");
    public static Item grayDivineSword = new ItemModSword(ToolMaterialMod.Divine, "gray_divine_sword");
    public static Item redDivineSword = new ItemModSword(ToolMaterialMod.Divine, "red_divine_sword");
    public static Item greenDivineSword = new ItemModSword(ToolMaterialMod.Divine, "green_divine_sword");
    public static Item bedrockMaul = new ItemModSword(ToolMaterialMod.BedrockMaul, "bedrock_maul");
    public static Item jungleKnife = new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungle_knife", 2.5f);
    public static Item jungleRapier = new ItemPoisonousSword(ToolMaterialMod.JungleRapier, "jungle_rapier", 4f);
    public static Item aquaticTrident = new ItemModSword(ToolMaterialMod.AquaTrident, "aquatic_trident");
    public static Item aquaticDagger = new ItemModSword(ToolMaterialMod.AquaDagger, "aquatic_dagger");
    public static Item aquaton = new ItemModSword(ToolMaterialMod.Aquaton, "aquaton");
    public static Item sharkSword = new ItemModSword(ToolMaterialMod.Shark, "shark_sword");
    public static Item deathBringer = new ItemModSword(ToolMaterialMod.DeathBringer, "death_bringer");
    public static Item crabclawMaul = new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclaw_maul");
    public static Item poisonSaber = new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poison_saber", 5);
    public static Item furyMaul = new ItemModSword(ToolMaterialMod.FuryMaul, "fury_maul");
    public static Item corruptedMaul = new ItemModSword(ToolMaterialMod.CorruptedMaul, "corrupted_maul");
    public static Item frostSword = new ItemSlowingSword(ToolMaterialMod.Frost, "frost_sword");
    public static Item infernoSword = new ItemBurningSword(ToolMaterialMod.Inferno, "inferno_sword", 12);
    public static Item bloodgemSword = new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgem_sword");
    public static Item moltenSword = new ItemBurningSword(ToolMaterialMod.Molten, "molten_sword", 5);
    public static Item scorchingSword = new ItemModSword(ToolMaterialMod.Scorching, "scorching_sword");
    public static Item bluefireSword = new ItemModSword(ToolMaterialMod.Bluefire, "bluefire_sword");
    public static Item enderSword = new ItemModSword(ToolMaterialMod.Ender, "ender_sword");
    public static Item blueEnderSword = new ItemModSword(ToolMaterialMod.Ender, "blue_ender_sword");
    public static Item grayEnderSword = new ItemModSword(ToolMaterialMod.Ender, "black_ender_sword");
    public static Item greenEnderSword = new ItemModSword(ToolMaterialMod.Ender, "green_ender_sword");
    public static Item redEnderSword = new ItemModSword(ToolMaterialMod.Ender, "red_ender_sword");
    public static Item yellowEnderSword = new ItemModSword(ToolMaterialMod.Ender, "yellow_ender_sword");
    public static Item cyclopsianSword = new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsian_sword");
    public static Item flamingFury = new ItemBurningSword(ToolMaterialMod.FlamingFury, "flaming_fury", 15);
    public static Item dualClaw = new ItemModSword(ToolMaterialMod.DualClaw, "dual_claw");
    public static Item terranDagger = new ItemModSword(ToolMaterialMod.TerranDagger, "terran_dagger");
    public static Item terranKnife = new ItemModSword(ToolMaterialMod.TerranKnife, "terran_knife");
    public static Item terranMaul = new ItemModSword(ToolMaterialMod.TerranMaul, "terran_maul");
    public static Item aquatoothSword = new ItemModSword(ToolMaterialMod.AquatoothSword, "aquatooth_sword");
    public static Item aquatoothMaul = new ItemModSword(ToolMaterialMod.AquatoothMaul, "aquatooth_maul");

    public static Item hunterBow = new ItemModBow("hunter_bow", ArrowType.HUNTER_ARROW, 2500, Items.ARROW);
    public static Item shadowBow = new ItemModBow("shadow_bow", ArrowType.SHADOW_ARROW, 10000, 36000, Items.ARROW);
    public static Item enderBow = new ItemModBow("ender_bow", ArrowType.ENDER_ARROW, -1);
    public static Item bluefireBow = new ItemModBow("bluefire_bow", ArrowType.BLUEFIRE_ARROW, -1);
    public static Item infernoBow = new ItemModBow("inferno_bow", ArrowType.INFERNO_ARROW, 10000);

    public static Item shuriken = new ItemThrowable("shuriken", BulletType.SHURIKEN_SHOT);
    public static Item vileStorm = new ItemVileStorm("vile_storm");
    public static Item scythe = new ItemScythe("scythe");

    public static Item frostCannon = new RangedWeaponBase("frost_cannon", BulletType.FROST_CANNON_SHOT,
            ModSounds.FROST_CANNON, Items.SNOWBALL, 15000, 0);
    public static Item cyclopsianStaff = new RangedWeaponBase("cyclopsian_staff", BulletType.CYCLOPSIAN_STAFF_SHOT,
            ModSounds.STAFF, 600, 0);
    public static Item maelstrom = new RangedWeaponBase("maelstrom", BulletType.MAELSTROM_SHOT, ModSounds.GHAST_CANNON,
            100, 0);

    public static Item crabAnchor = new ItemAnchor("crab_anchor", BulletType.CRAB_ANCHOR_SHOT);
    public static Item sharkAnchor = new ItemAnchor("shark_anchor", BulletType.SHARK_ANCHOR_SHOT);
    public static Item bowheadAnchor = new ItemAnchor("bowhead_anchor", BulletType.BOWHEAD_ANCHOR_SHOT);
    public static Item liopleurodonAnchor = new ItemAnchor("liopleurodon_anchor", BulletType.LIOPLEURODON_ANCHOR_SHOT);
    public static Item goldenFury = new RangedWeaponBase("golden_fury", BulletType.GOLDEN_FURY_SHOT, ModSounds.BLITZ,
            Items.GOLD_NUGGET, -1, 0);
    // Bullets is using at cannon below, need to declare here
    public static Item corruptedBullet = new ItemMod("corrupted_bullet");
    public static Item corruptedCannon = new ItemCorruptedCannon("corrupted_cannon");
    public static Item ghastCannon = new RangedWeaponBase("ghast_cannon", BulletType.GHAST_CANNON_SHOT,
            ModSounds.GHAST_CANNON, 100, 20);
    public static Item crabclawCannon = new RangedWeaponBase("crabclaw_cannon", BulletType.CRABCLAW_CANNON_SHOT,
            ModSounds.GHAST_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 1000, 12);
    public static Item bowheadCannon = new RangedWeaponBase("bowhead_cannon", BulletType.BOWHEAD_CANNON_SHOT,
            ModSounds.GHAST_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 1000, 12);

    public static Item serenadeOfHealth = new ItemSerenadeOfHealth("serenade_of_health");
    public static Item serenadeStriker = new ItemSerenadeStriker("serenade_striker");
    public static Item serenadeOfDeath = new ItemSerenadeOfDeath("serenade_of_death");
    public static Item serenadeOfInfusion = new ItemSerenadeOfInfusion("serenade_of_infusion");

    public static Item palavence = new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5F);
    public static Item massivence = new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1F);

    // Vanilla Armor
    private static Object[] angelicInfo = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY };
    public static Item angelicHelmet = new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD, angelicInfo);
    public static Item angelicBody = new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST, angelicInfo);
    public static Item angelicLegs = new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS, angelicInfo);
    public static Item angelicBoots = new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, angelicInfo);

    private static Object[] divineInfo = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT,
            ArmorInfo.NO_FALL };
    public static Item divineHelmet = new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.HEAD, divineInfo);
    public static Item divineBody = new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.CHEST, divineInfo);
    public static Item divineLegs = new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.LEGS, divineInfo);
    public static Item divineBoots = new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.FEET, divineInfo);

    private static Object[] bedrockInfo = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
    public static Item bedrockHelmet = new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.HEAD, bedrockInfo);
    public static Item bedrockBody = new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.CHEST, bedrockInfo);
    public static Item bedrockLegs = new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.LEGS, bedrockInfo);
    public static Item bedrockBoots = new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.FEET, bedrockInfo);

    public static Item realmiteHelmet = new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.HEAD);
    public static Item realmiteBody = new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.CHEST);
    public static Item realmiteLegs = new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.LEGS);
    public static Item realmiteBoots = new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.FEET);

    private static Object[] eliteRealmiteInfo = new Object[] { ArmorInfo.NO_FALL };
    public static Item eliteRealmiteHelmet = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.HEAD,
            eliteRealmiteInfo);
    public static Item eliteRealmiteBody = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.CHEST,
            eliteRealmiteInfo);
    public static Item eliteRealmiteLegs = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.LEGS,
            eliteRealmiteInfo);
    public static Item eliteRealmiteBoots = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.FEET,
            eliteRealmiteInfo);

    private static Object[] arlemiteInfo = new Object[] { 85, ArmorInfo.RANGED_PROTECTION };
    public static Item arlemiteHelmet = new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.HEAD, arlemiteInfo);
    public static Item arlemiteBody = new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.CHEST, arlemiteInfo);
    public static Item arlemiteLegs = new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.LEGS, arlemiteInfo);
    public static Item arlemiteBoots = new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.FEET, arlemiteInfo);

    private static Object[] rupeeInfo = new Object[] { 85, ArmorInfo.MELEE_PROTECTION };
    public static Item rupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.HEAD, rupeeInfo);
    public static Item rupeeBody = new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.CHEST, rupeeInfo);
    public static Item rupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.LEGS, rupeeInfo);
    public static Item rupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.FEET, rupeeInfo);
    public static Item yellowRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.HEAD,
            rupeeInfo);
    public static Item yellowRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.CHEST,
            rupeeInfo);
    public static Item yellowRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.LEGS,
            rupeeInfo);
    public static Item yellowRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.FEET,
            rupeeInfo);
    public static Item redRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.HEAD, rupeeInfo);
    public static Item redRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.CHEST, rupeeInfo);
    public static Item redRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.LEGS, rupeeInfo);
    public static Item redRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.FEET, rupeeInfo);
    public static Item greenRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.HEAD,
            rupeeInfo);
    public static Item greenRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.CHEST,
            rupeeInfo);
    public static Item greenRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.LEGS, rupeeInfo);
    public static Item greenRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.FEET,
            rupeeInfo);
    public static Item blueRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.HEAD, rupeeInfo);
    public static Item blueRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.CHEST, rupeeInfo);
    public static Item blueRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.LEGS, rupeeInfo);
    public static Item blueRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.FEET, rupeeInfo);
    public static Item grayRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.HEAD, rupeeInfo);
    public static Item grayRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.CHEST, rupeeInfo);
    public static Item grayRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.LEGS, rupeeInfo);
    public static Item grayRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.FEET, rupeeInfo);

    private static Object[] krakenInfo = new Object[] { ArmorInfo.UNDERWATER };
    public static Item krakenHelmet = new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.HEAD, krakenInfo);
    public static Item krakenBody = new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.CHEST, krakenInfo);
    public static Item krakenLegs = new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.LEGS, krakenInfo);
    public static Item krakenBoots = new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.FEET, krakenInfo);

    private static Object[] jackomanInfo = new Object[] { 3, ArmorInfo.SCYTHE_DAMAGE };
    public static Item jackOManHelmet = new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.HEAD, jackomanInfo);
    public static Item jackOManBody = new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.CHEST, jackomanInfo);
    public static Item jackOManLegs = new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.LEGS, jackomanInfo);
    public static Item jackOManBoots = new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.FEET, jackomanInfo);

    private static Object[] infernoInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static Item infernoHelmet = new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.HEAD, infernoInfo);
    public static Item infernoBody = new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.CHEST, infernoInfo);
    public static Item infernoLegs = new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.LEGS, infernoInfo);
    public static Item infernoBoots = new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.FEET, infernoInfo);

    private static Object[] aquastriveInfo = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
    public static Item aquastriveHelmet = new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.HEAD,
            aquastriveInfo);
    public static Item aquastriveBody = new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.CHEST,
            aquastriveInfo);
    public static Item aquastriveLegs = new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.LEGS,
            aquastriveInfo);
    public static Item aquastriveBoots = new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.FEET,
            aquastriveInfo);

    private static Object[] shadowInfo = new Object[] { 3, ArmorInfo.SPEED };
    public static Item shadowHelmet = new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.HEAD, shadowInfo);
    public static Item shadowBody = new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.CHEST, shadowInfo);
    public static Item shadowLegs = new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.LEGS, shadowInfo);
    public static Item shadowBoots = new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.FEET, shadowInfo);

    private static Object[] netheriteInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static Item netheriteHelmet = new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.HEAD,
            netheriteInfo);
    public static Item netheriteBody = new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.CHEST,
            netheriteInfo);
    public static Item netheriteLegs = new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.LEGS,
            netheriteInfo);
    public static Item netheriteBoots = new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.FEET,
            netheriteInfo);

    private static Object[] skelemanInfo = new Object[] { ArmorInfo.HUNGER };
    public static Item skelemanHelmet = new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.HEAD, skelemanInfo);
    public static Item skelemanBody = new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.CHEST, skelemanInfo);
    public static Item skelemanLegs = new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.LEGS, skelemanInfo);
    public static Item skelemanBoots = new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.FEET, skelemanInfo);

    private static Object[] witherReaperInfo = new Object[] { ArmorInfo.WITHER_PROTECTION };
    public static Item witherReaperHelmet = new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.HEAD,
            witherReaperInfo);
    public static Item witherReaperBody = new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.CHEST,
            witherReaperInfo);
    public static Item witherReaperLegs = new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.LEGS,
            witherReaperInfo);
    public static Item witherReaperBoots = new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.FEET,
            witherReaperInfo);

    private static Object[] enderInfo = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
    public static Item enderHelmet = new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.HEAD, enderInfo);
    public static Item enderBody = new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.CHEST, enderInfo);
    public static Item enderLegs = new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.LEGS, enderInfo);
    public static Item enderBoots = new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.FEET, enderInfo);
    public static Item yellowEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.HEAD,
            enderInfo);
    public static Item yellowEnderBody = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.CHEST,
            enderInfo);
    public static Item yellowEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.LEGS,
            enderInfo);
    public static Item yellowEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.FEET,
            enderInfo);
    public static Item redEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.HEAD, enderInfo);
    public static Item redEnderBody = new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.CHEST, enderInfo);
    public static Item redEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.LEGS, enderInfo);
    public static Item redEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.FEET, enderInfo);
    public static Item greenEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.HEAD,
            enderInfo);
    public static Item greenEnderBody = new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.CHEST,
            enderInfo);
    public static Item greenEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.LEGS, enderInfo);
    public static Item greenEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.FEET,
            enderInfo);
    public static Item blueEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.HEAD, enderInfo);
    public static Item blueEnderBody = new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.CHEST, enderInfo);
    public static Item blueEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.LEGS, enderInfo);
    public static Item blueEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.FEET, enderInfo);
    public static Item grayEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.HEAD, enderInfo);
    public static Item grayEnderBody = new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.CHEST, enderInfo);
    public static Item grayEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.LEGS, enderInfo);
    public static Item grayEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.FEET, enderInfo);

    private static Object[] jungleInfo = new Object[] { ArmorInfo.POISON_PROTECTION };
    public static Item jungleHelmet = new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.HEAD, jungleInfo);
    public static Item jungleBody = new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.CHEST, jungleInfo);
    public static Item jungleLegs = new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.LEGS, jungleInfo);
    public static Item jungleBoots = new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.FEET, jungleInfo);

    private static Object[] frozenInfo = new Object[] { ArmorInfo.FREEZE };
    public static Item frozenHelmet = new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.HEAD, frozenInfo);
    public static Item frozenBody = new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.CHEST, frozenInfo);
    public static Item frozenLegs = new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.LEGS, frozenInfo);
    public static Item frozenBoots = new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.FEET, frozenInfo);

    private static Object[] corruptedInfo = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
    public static Item corruptedHelmet = new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.HEAD,
            corruptedInfo);
    public static Item corruptedBody = new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.CHEST,
            corruptedInfo);
    public static Item corruptedLegs = new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.LEGS,
            corruptedInfo);
    public static Item corruptedBoots = new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.FEET,
            corruptedInfo);

    private static Object[] terranInfo = new Object[] { 20, ArmorInfo.HASTE };
    public static Item terranHelmet = new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.HEAD, terranInfo);
    public static Item terranBody = new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.CHEST, terranInfo);
    public static Item terranLegs = new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.LEGS, terranInfo);
    public static Item terranBoots = new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.FEET, terranInfo);

    public static Item diamondHelmet = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.HEAD);
    public static Item diamondBody = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.CHEST);
    public static Item diamondLegs = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.LEGS);
    public static Item diamondBoots = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.FEET);

    public static Item ironHelmet = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.HEAD);
    public static Item ironBody = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.CHEST);
    public static Item ironLegs = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.LEGS);
    public static Item ironBoots = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.FEET);

    public static Item goldHelmet = new ItemDivineArmor("golden_helmet", EnumArmor.GOLD, EntityEquipmentSlot.HEAD);
    public static Item goldBody = new ItemDivineArmor("golden_chestplate", EnumArmor.GOLD, EntityEquipmentSlot.CHEST);
    public static Item goldLegs = new ItemDivineArmor("golden_leggings", EnumArmor.GOLD, EntityEquipmentSlot.LEGS);
    public static Item goldBoots = new ItemDivineArmor("golden_boots", EnumArmor.GOLD, EntityEquipmentSlot.FEET);

    // Vanilla Tools
    public static Item rupeeShickaxe = new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupee_shickaxe");
    public static Item rupeePickaxe = new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupee_pickaxe");
    public static Item rupeeAxe = new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupee_axe");
    public static Item rupeeShovel = new ItemModShovel(ToolMaterialMod.RupeeShovel, "rupee_shovel");
    public static Item rupeeHoe = new ItemModHoe(ToolMaterialMod.RupeePick, "rupee_hoe");

    public static Item arlemiteShickaxe = new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemite_shickaxe");
    public static Item arlemitePickaxe = new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemite_pickaxe");
    public static Item arlemiteAxe = new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemite_axe");
    public static Item arlemiteShovel = new ItemModShovel(ToolMaterialMod.ArlemiteShovel, "arlemite_shovel");
    public static Item arlemiteHoe = new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemite_hoe");

    public static Item realmitePickaxe = new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmite_pickaxe");
    public static Item realmiteAxe = new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmite_axe");
    public static Item realmiteShovel = new ItemModShovel(ToolMaterialMod.RealmiteShovel, "realmite_shovel");
    public static Item realmiteHoe = new ItemModHoe(ToolMaterialMod.RealmitePick, "realmite_hoe");

    public static Item bedrockPickaxe = new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrock_pickaxe");
    public static Item bedrockAxe = new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrock_axe");
    public static Item bedrockShovel = new ItemModShovel(ToolMaterialMod.BedrockShovel, "bedrock_shovel");

    public static Item corruptedPickaxe = new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corrupted_pickaxe");
    public static Item corruptedAxe = new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corrupted_axe");
    public static Item corruptedShovel = new ItemModShovel(ToolMaterialMod.CorruptedShovel, "corrupted_shovel");

    public static Item divineShickaxe = new ItemShickaxe(ToolMaterialMod.DivineShick, "divine_shickaxe");
    public static Item divinePickaxe = new ItemModPickaxe(ToolMaterialMod.DivinePick, "divine_pickaxe");
    public static Item divineAxe = new ItemModAxe(ToolMaterialMod.DivineAxe, "divine_axe");
    public static Item divineShovel = new ItemModShovel(ToolMaterialMod.DivineShovel, "divine_shovel");

    // Vanilla Other
    public static Item rupeeIngot = new ItemMod("rupee_ingot");
    public static Item arlemiteIngot = new ItemMod("arlemite_ingot");
    public static Item realmiteIngot = new ItemMod("realmite_ingot");
    public static Item shadowBar = new ItemMod("shadow_bar");
    public static Item hellstoneIngot = new ItemMod("hellstone_ingot");
    public static Item netheriteIngot = new ItemMod("netherite_ingot");
    public static Item bloodgem = new ItemMod("bloodgem");

    public static Item jungleShards = new ItemMod("jungle_shards");
    public static Item divineShards = new ItemMod("divine_shards");
    public static Item corruptedShards = new ItemMod("corrupted_shards");
    public static Item moltenShards = new ItemMod("molten_shards");
    public static Item enderShards = new ItemMod("ender_shards");
    public static Item terranShards = new ItemMod("terran_shards");
    public static Item cyclopsEyeShards = new ItemMod("cyclops_eye_shards");

    public static Item jungleStone = new ItemMod("jungle_stone");
    public static Item divineStone = new ItemMod("divine_stone");
    public static Item corruptedStone = new ItemMod("corrupted_stone");
    public static Item moltenStone = new ItemMod("molten_stone");
    public static Item enderStone = new ItemMod("ender_stone");
    public static Item terranStone = new ItemMod("terran_stone");
    public static Item shadowStone = new ItemMod("shadow_stone");

    public static Item healingStone = new ItemHealingStone("healing_stone", 20);

    public static Item aquaticIngot = new ItemMod("aquatic_ingot");
    public static Item aquaticPellets = new ItemMod("aquatic_pellets");
    public static Item pureAquaticPellets = new ItemMod("pure_aquatic_pellets");
    public static Item cyclopsEye = new ItemMod("cyclops_eye");
    public static Item crabClaw = new ItemMod("crab_claw");
    public static Item legendaryEnderEye = new ItemMod("legendary_ender_eye");
    public static Item sharkFin = new ItemMod("shark_fin");
    public static Item whaleFin = new ItemMod("whale_fin");
    public static Item liopleurodonSkull = new ItemMod("liopleurodon_skull");
    public static Item liopleurodonTeeth = new ItemMod("liopleurodon_teeth");
    public static Item netheriteChunk = new ItemMod("netherite_chunk");
    public static Item bluefireStone = new ItemMod("bluefire_stone");
    public static Item purpleBlaze = new ItemMod("purple_blaze");
    public static Item furyFire = new ItemMod("fury_fire");
    public static Item aquaBall = new ItemMod("aqua_ball");
    public static Item aquaticBlazeRod = new ItemMod("aquatic_blaze_rod");
    public static Item shadowCoins = new ItemMod("shadow_coins");

    public static Item ehuSpawner = new ItemLivestockSpawnEgg("ehu_egg");
    public static Item huskSpawner = new ItemLivestockSpawnEgg("husk_egg");
    public static Item stoneGolemSpawner = new ItemLivestockSpawnEgg("stone_golem_egg");
    public static Item smelterSpawner = new ItemLivestockSpawnEgg("smelter_egg");
    public static Item snapperSpawner = new ItemLivestockSpawnEgg("snapper_egg");
    public static Item whiteGrizzleSpawner = new ItemLivestockSpawnEgg("white_grizzle_egg");
    public static Item brownGrizzleSpawner = new ItemLivestockSpawnEgg("brown_grizzle_egg");

    public static Item greenDiamondChunk = new ItemMod("green_diamond_chunk");
    public static Item grayDiamondChunk = new ItemMod("gray_diamond_chunk");
    public static Item blueDiamondChunk = new ItemMod("blue_diamond_chunk");
    public static Item redDiamondChunk = new ItemMod("red_diamond_chunk");
    public static Item yellowDiamondChunk = new ItemMod("yellow_diamond_chunk");

    public static Item mysteriousClock = new ItemMysteriousClock("mysterious_clock");
    public static Item watchingEye = new ItemMod("watching_eye");
    public static Item callOfTheWatcher = new ItemCallOfTheWatcher("call_of_the_watcher");
    public static Item infernalFlame = new ItemInfernalFlame("infernal_flame");
    public static Item hordeHorn = new ItemHordeHorn("horde_horn");

    public static Item krakenSkin = new ItemMod("kraken_skin");
    public static Item krakenScale = new ItemMod("kraken_scale");

    public static Item teleportationCrystal = new ItemTeleportationCrystal("teleportation_crystal");

    // Iceika
    public static Item snowflake = new ItemMod("snowflake");
    public static Item iceShards = new ItemMod("ice_shards");
    public static Item iceStone = new ItemMod("ice_stone");

    public static Item icicleBane = new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicle_bane");
    public static Item icineSword = new ItemSlowingSword(ToolMaterialMod.Icine, "icine_sword");
    public static Item enderice = new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice");
    public static Item snowSlash = new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash");
    public static Item glacierSword = new ItemSlowingSword(ToolMaterialMod.Glacier, "glacier_sword");
    public static Item frostkingSword = new ItemSlowingSword(ToolMaterialMod.Frostking, "frostking_sword");
    public static Item frozenMaul = new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozen_maul");
    public static Item frossivence = new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1F);
    public static Item soundOfCarols = new ItemMusicShooter("sound_of_carols", ModSounds.SOUND_OF_CAROLS,
            EntitySoundOfCarols.class);
    public static Item soundOfMusic = new ItemMusicShooter("sound_of_music", ModSounds.SOUND_OF_MUSIC,
            EntitySoundOfMusic.class);

    public static Item frostclawCannon = new RangedWeaponBase("frostclaw_cannon", BulletType.FROSTCLAW_CANNON_SHOT,
            ModSounds.FROSTCLAW_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 10000, 0);
    public static Item fractiteCannon = new RangedWeaponBase("fractite_cannon", BulletType.FRACTITE_CANNON_SHOT,
            ModSounds.FRACTITE_CANNON, iceShards, 10000, 0);
    public static Item snowflakeShuriken = new ItemThrowable("snowflake_shuriken", BulletType.SNOWFLAKE_SHURIKEN_SHOT);

    public static Item serenadeOfIce = new ItemSerenadeOfIce("serenade_of_ice");

    public static Item eggNog = new ItemEggNog("egg_nog");
    public static Item peppermints = new ItemModFood(1, 0.3F, false, "peppermints");
    public static Item chocolateLog = new ItemModFood(4, 1.0F, false, "chocolate_log");
    public static Item snowCones = new ItemModFood(2, 0.3F, false, "snow_cones");
    public static Item fruitCake = new ItemModFood(16, 2.0F, false, "fruit_cake");
    public static Item winterberry = new ItemModFood(4, 1.0F, false, "winterberry");

    public static Item icicleBow = new ItemModBow("icicle_bow", ArrowType.ICICLE_ARROW, 10000, 24000, Items.ARROW);
    public static Item snowstormBow = new ItemModBow("snowstorm_bow", ArrowType.SNOWSTORM_ARROW, -1);

    private static Object[] santaInfo = new Object[] { ChatFormats.ICEIKA, "Massive Buff", 2, ArmorInfo.SPEED, 6,
            ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
    public static Item santaCap = new ItemDivineArmor("santa_cap", EnumArmor.SANTA, EntityEquipmentSlot.HEAD,
            santaInfo);
    public static Item santaTunic = new ItemDivineArmor("santa_tunic", EnumArmor.SANTA, EntityEquipmentSlot.CHEST,
            santaInfo);
    public static Item santaPants = new ItemDivineArmor("santa_pants", EnumArmor.SANTA, EntityEquipmentSlot.LEGS,
            santaInfo);
    public static Item santaBoots = new ItemDivineArmor("santa_boots", EnumArmor.SANTA, EntityEquipmentSlot.FEET,
            santaInfo);

    public static Item snowGlobe = new ItemSnowGlobe("snow_globe");

    // Foods
    public static Item bacon = new ItemModFood(2, 3.0F, true, "bacon");
    public static Item hotPumpkinPie = new ItemModFood(5, 7.0F, true, "hot_pumpkin_pie");
    public static Item boiledEgg = new ItemModFood(4, 0.5F, false, "boiled_egg");
    public static Item cheese = new ItemModFood(2, 0.2F, false, "cheese");
    public static Item whiteMushroom = new ItemModFood(1, 0.1F, false, "white_mushroom");
    public static Item advMushroomStew = new ItemModFood(10, 10.0F, false, "advanced_mushroom_stew");
    public static Item chickenDinner = new ItemModFood(20, 20.0F, false, "chicken_dinner");
    public static Item tomato = new ItemModFood(4, 0.3F, false, "tomato");
    public static Item donut = new ItemModFood(16, 0.3F, false, "donut");
    public static Item rawEmpoweredMeat = new ItemModFood(5, 2.0F, true, "raw_empowered_meat");
    public static Item empoweredMeat = new ItemModFood(10, 4.0F, true, "empowered_meat");
    public static Item magicMeat = new ItemFastFood(5, 1.0F, true, "magic_meat");
    public static Item enrichedMagicMeat = new ItemFastFood(7, 2.5F, true, "enriched_magic_meat");

    // Twilight Items
    public static Item edenSoul = new ItemMod("eden_soul");
    public static Item wildwoodSoul = new ItemMod("wildwood_soul");
    public static Item apalachiaSoul = new ItemMod("apalachia_soul");
    public static Item skythernSoul = new ItemMod("skythern_soul");
    public static Item mortumSoul = new ItemMod("mortum_soul");

    public static Item edenFragments = new ItemMod("eden_fragments");
    public static Item wildwoodFragments = new ItemMod("wildwood_fragments");
    public static Item apalachiaFragments = new ItemMod("apalachia_fragments");
    public static Item skythernFragments = new ItemMod("skythern_fragments");
    public static Item mortumFragments = new ItemMod("mortum_fragments");

    public static Item edenGem = new ItemMod("eden_gem");
    public static Item wildwoodGem = new ItemMod("wildwood_gem");
    public static Item apalachiaGem = new ItemMod("apalachia_gem");
    public static Item skythernGem = new ItemMod("skythern_gem");
    public static Item mortumGem = new ItemMod("mortum_gem");

    public static Item edenChunk = new ItemMod("eden_chunk");
    public static Item wildwoodChunk = new ItemMod("wildwood_chunk");
    public static Item apalachiaChunk = new ItemMod("apalachia_chunk");
    public static Item skythernChunk = new ItemMod("skythern_chunk");
    public static Item mortumChunk = new ItemMod("mortum_chunk");

    public static Item edenDust = new ItemMod("eden_dust");
    public static Item wildwoodDust = new ItemMod("wildwood_dust");
    public static Item apalachiaDust = new ItemMod("apalachia_dust");
    public static Item skythernDust = new ItemMod("skythern_dust");
    public static Item mortumDust = new ItemMod("mortum_dust");

    public static Item twilightClock = new ItemTwilightClock("twilight_clock");

    public static Item edenSparkles = new ItemMod("eden_sparkles");

    public static Item baseSpawnCrystal = new ItemMod("base_spawn_crystal");

    public static Item densosCrystal = new ItemTwilightSpawner("densos_crystal");
    public static Item karotCrystal = new ItemTwilightSpawner("karot_crystal");
    public static Item reyvorCrystal = new ItemTwilightSpawner("reyvor_crystal");
    public static Item soulFiendCrystal = new ItemTwilightSpawner("soul_fiend_crystal");
    public static Item twilightDemonCrystal = new ItemTwilightSpawner("twilight_demon_crystal");
    public static Item vamacheronCrystal = new ItemTwilightSpawner("vamacheron_crystal");
    public static Item eternalArcherCrystal = new ItemTwilightSpawner("eternal_archer_crystal");

    // Twilight Weapons
    public static Item edenBlade = new ItemModSword(ToolMaterialMod.Eden, "eden_blade");
    public static Item wildwoodBlade = new ItemModSword(ToolMaterialMod.Wildwood, "wildwood_blade");
    public static Item apalachiaBlade = new ItemModSword(ToolMaterialMod.Apalachia, "apalachia_blade");
    public static Item skythernBlade = new ItemModSword(ToolMaterialMod.Skythern, "skythern_blade");
    public static Item mortumBlade = new ItemModSword(ToolMaterialMod.Mortum, "mortum_blade");
    public static Item haliteBlade = new ItemModSword(ToolMaterialMod.Halite, "halite_blade");

    public static Item edenSlicer = new ItemThrowable("eden_slicer", BulletType.EDEN_SLICER_SHOT);
    public static Item wildwoodSlicer = new ItemThrowable("wildwood_slicer", BulletType.WILDWOOD_SLICER_SHOT);
    public static Item apalachiaSlicer = new ItemThrowable("apalachia_slicer", BulletType.APALACHIA_SLICER_SHOT);
    public static Item skythernSlicer = new ItemThrowable("skythern_slicer", BulletType.SKYTHERN_SLICER_SHOT);
    public static Item mortumSlicer = new ItemThrowable("mortum_slicer", BulletType.MORTUM_SLICER_SHOT);
    public static Item haliteSlicer = new ItemThrowable("halite_slicer", BulletType.HALITE_SLICER_SHOT);

    public static Item edenBlitz = new ItemTwilightBlitz("eden_blitz", BulletType.EDEN_BLITZ_SHOT, edenDust);
    public static Item wildwoodBlitz = new ItemTwilightBlitz("wildwood_blitz", BulletType.WILDWOOD_BLITZ_SHOT,
            wildwoodDust);
    public static Item apalachiaBlitz = new ItemTwilightBlitz("apalachia_blitz", BulletType.APALACHIA_BLITZ_SHOT,
            apalachiaDust);
    public static Item skythernBlitz = new ItemTwilightBlitz("skythern_blitz", BulletType.SKYTHERN_BLITZ_SHOT,
            skythernDust);
    public static Item mortumBlitz = new ItemTwilightBlitz("mortum_blitz", BulletType.MORTUM_BLITZ_SHOT, mortumDust);
    public static Item haliteBlitz = new ItemTwilightBlitz("halite_blitz", BulletType.HALITE_BLITZ_SHOT, mortumDust);

    public static Item edenPhaser = new RangedWeaponBase("eden_phaser", BulletType.EDEN_PHASER_SHOT, ModSounds.PHASER,
            3000, 12);
    public static Item wildwoodPhaser = new RangedWeaponBase("wildwood_phaser", BulletType.WILDWOOD_PHASER_SHOT,
            ModSounds.PHASER, 3000, 12);
    public static Item apalachiaPhaser = new RangedWeaponBase("apalachia_phaser", BulletType.APALACHIA_PHASER_SHOT,
            ModSounds.PHASER, 3000, 12);
    public static Item skythernPhaser = new RangedWeaponBase("skythern_phaser", BulletType.SKYTHERN_PHASER_SHOT,
            ModSounds.PHASER, 3000, 12);
    public static Item mortumPhaser = new RangedWeaponBase("mortum_phaser", BulletType.MORTUM_PHASER_SHOT,
            ModSounds.PHASER, 3000, 12);
    public static Item halitePhaser = new RangedWeaponBase("halite_phaser", BulletType.HALITE_PHASER_SHOT,
            ModSounds.PHASER, 3000, 12);

    public static Item edenArrow = new ItemMod("eden_arrow").setCreativeTab(DivineRPGTabs.ranged);
    public static Item wildwoodArrow = new ItemMod("wildwood_arrow").setCreativeTab(DivineRPGTabs.ranged);
    public static Item furyArrow = new ItemMod("fury_arrow").setCreativeTab(DivineRPGTabs.ranged);

    public static Item edenBow = new ItemModBow("eden_bow", ArrowType.EDEN_ARROW, -1, edenArrow);
    public static Item wildwoodBow = new ItemModBow("wildwood_bow", ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000,
            wildwoodArrow);
    public static Item apalachiaBow = new ItemModBow("apalachia_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1,
            wildwoodArrow);
    public static Item skythernBow = new ItemModBow("skythern_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000,
            wildwoodArrow);
    public static Item mortumBow = new ItemModBow("mortum_bow", ArrowType.FURY_ARROW, -1, furyArrow);
    public static Item haliteBow = new ItemModBow("halite_bow", ArrowType.FURY_ARROW, -1, 36000, furyArrow);
    public static Item twilightBow = new ItemModBow("twilight_bow", ArrowType.FURY_ARROW, -1, 14400, furyArrow)
            .setCreativeTab(null);

    // Twilight Tools
    public static Item edenPickaxe = new ItemModPickaxe(ToolMaterialMod.EdenPick, "eden_pickaxe");
    public static Item wildwoodPickaxe = new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwood_pickaxe");
    public static Item apalachiaPickaxe = new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachia_pickaxe");
    public static Item skythernPickaxe = new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythern_pickaxe");
    public static Item mortumPickaxe = new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortum_pickaxe");

    public static Item edenAxe = new ItemModAxe(ToolMaterialMod.EdenAxe, "eden_axe");
    public static Item wildwoodAxe = new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwood_axe");
    public static Item apalachiaAxe = new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachia_axe");
    public static Item skythernAxe = new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythern_axe");
    public static Item mortumAxe = new ItemModAxe(ToolMaterialMod.MortumAxe, "mortum_axe");

    public static Item edenShovel = new ItemModShovel(ToolMaterialMod.EdenShovel, "eden_shovel");
    public static Item wildwoodShovel = new ItemModShovel(ToolMaterialMod.WildwoodShovel, "wildwood_shovel");
    public static Item apalachiaShovel = new ItemModShovel(ToolMaterialMod.ApalachiaShovel, "apalachia_shovel");
    public static Item skythernShovel = new ItemModShovel(ToolMaterialMod.SkythernShovel, "skythern_shovel");
    public static Item mortumShovel = new ItemModShovel(ToolMaterialMod.MortumShovel, "mortum_shovel");

    // Twilight Armor
    private static Object[] edenInfo = new Object[] { 3, ArmorInfo.ORE_DROPS };
    public static Item edenHelmet = new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.HEAD, edenInfo);
    public static Item edenChestplate = new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.CHEST, edenInfo);
    public static Item edenLeggings = new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.LEGS, edenInfo);
    public static Item edenBoots = new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.FEET, edenInfo);

    private static Object[] wildInfo = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
    public static Item wildwoodHelmet = new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.HEAD, wildInfo);
    public static Item wildwoodChestplate = new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.CHEST, wildInfo);
    public static Item wildwoodLeggings = new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.LEGS, wildInfo);
    public static Item wildwoodBoots = new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.FEET, wildInfo);

    private static Object[] apInfo = new Object[] { ArmorInfo.BLOCK_PROTECTION };
    public static Item apalachiaHelmet = new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.HEAD, apInfo);
    public static Item apalachiaChestplate = new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.CHEST,
            apInfo);
    public static Item apalachiaLeggings = new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.LEGS, apInfo);
    public static Item apalachiaBoots = new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.FEET, apInfo);

    private static Object[] skyInfo = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    public static Item skythernHelmet = new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.HEAD, skyInfo);
    public static Item skythernChestplate = new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.CHEST, skyInfo);
    public static Item skythernLeggings = new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.LEGS, skyInfo);
    public static Item skythernBoots = new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.FEET, skyInfo);

    private static Object[] mortInfo = new Object[] { ArmorInfo.NIGHT_VISION };
    public static Item mortumHelmet = new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.HEAD, mortInfo);
    public static Item mortumChestplate = new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.CHEST, mortInfo);
    public static Item mortumLeggings = new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.LEGS, mortInfo);
    public static Item mortumBoots = new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.FEET, mortInfo);

    private static Object[] halInfo = new Object[] { 16, ArmorInfo.MELEE_DAMAGE };
    public static Item haliteHelmet = new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.HEAD, halInfo);
    public static Item haliteChestplate = new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.CHEST, halInfo);
    public static Item haliteLeggings = new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.LEGS, halInfo);
    public static Item haliteBoots = new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.FEET, halInfo);

    // Twilight Crops
    public static Item moonbulb = new ItemFastFood(1, 5, false, "moonbulb");
    public static Item purpleGlowbone = new ItemFastFood(3, 5, false, "purple_glowbone");
    public static Item pinkGlowbone = new ItemFastFood(3, 5, false, "pink_glowbone");
    public static Item skyFlower = new ItemSkyFlower("sky_flower");

    // Arcana
    public static Item dungeonTokens = new ItemMod("dungeon_tokens");
    public static Item arcanium = new ItemMod("arcanium");
    public static Item staffStarlight = new ItemStaffStarlight("staff_of_starlight", 25);
    public static Item starlight = new ItemStaffStarlight("starlight", 5);
    public static Item stormSword = new ItemStormSword("storm_sword", ToolMaterialMod.Storm);

    public static Item captainsSparkler = new ItemCaptainsSparkler("captains_sparkler");
    public static Item strongArcanaPotion = new ItemArcanaPotion("strong_arcana_potion", 200);
    public static Item weakArcanaPotion = new ItemArcanaPotion("weak_arcana_potion", 100);
    public static Item collector = new ItemMod("collector");
    public static Item chargedCollector = new ItemChargedCollector("charged_collector");
    public static Item wizardBook = new ItemWizardsBook("wizards_book");
    public static Item staffOfEnrichment = new ItemStaffEnrichment("staff_of_enrichment");
    public static Item orbOfLight = new ItemOrbOfLight();
    public static Item meriksMissile = new ItemMeriksMissile("meriks_missile");
    public static Item grenade = new ItemGrenade("grenade");
    public static Item firefly = new ItemFirefly();
    public static Item laVekor = new ItemLaVekor();
    public static Item enderScepter = new ItemEnderScepter("ender_scepter");
    public static Item arcaniumSaber = new ItemArcaniumSaber("arcanium_saber", ToolMaterialMod.Saber);
    public static Item ghostbane = new ItemGhostbane();
    public static Item arcaniumReflector = new ItemReflector();
    public static Item shadowSword = new ItemShadowSaber("shadow_saber", ToolMaterialMod.ShadowSaber);
    public static Item liviciaSword = new ItemModSword(ToolMaterialMod.LiviciaSword, "livicia_sword");
    public static Item meteorMash = new ItemMeteorMash();
    public static Item divineAccumulator = new ItemDivineAccumulator();
    public static Item arcaniteBlaster = new ItemArcaniteBlaster();
    public static Item arcaniteBlade = new ItemArcaniteBlade();
    public static Item generalsStaff = new ItemGeneralsStaff();
    public static Item arcaniumAttractor = new ItemAttractor();

    public static Item sludgeKey = new ItemKey("sludge_key");
    public static Item ancientKey = new ItemKey("ancient_key");
    public static Item soulKey = new ItemKey("soul_key");
    public static Item degradedKey = new ItemKey("degraded_key");

    public static Item golemOfRejuvenationSpawner = new ItemZelusSpawnEgg("golem_of_rejuvenation_egg");
    public static Item seimerSpawner = new ItemZelusSpawnEgg("seimer_egg");
    public static Item paratikuSpawner = new ItemZelusSpawnEgg("paratiku_egg");
    public static Item fyracryxSpawner = new ItemZelusSpawnEgg("fyracryx_egg");

    public static Item hitchak = new ItemModFood(2, 3, false, "hitchak");
    public static Item veilo = new ItemMod("veilo");
    public static Item marsine = new ItemMod("marsine");
    public static Item lamona = new ItemLamona();
    public static Item firestock = new ItemMod("firestock");
    public static Item pinfly = new ItemModFood(2, 0.3F, false, "pinfly")
            .setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2), 1.0F);
    public static Item aquamarine = new ItemAquamarine("aquamarine");

    private static Object[] kormInfo = new Object[] { ArmorInfo.ARCANA_REGEN };
    public static Item kormaHelmet = new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.HEAD, kormInfo);
    public static Item kormaBody = new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.CHEST, kormInfo);
    public static Item kormaLegs = new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.LEGS, kormInfo);
    public static Item kormaBoots = new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.FEET, kormInfo);

    private static Object[] vemInfo = new Object[] { ArmorInfo.HEALTH_REGEN };
    public static Item vemosHelmet = new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.HEAD, vemInfo);
    public static Item vemosBody = new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.CHEST, vemInfo);
    public static Item vemosLegs = new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.LEGS, vemInfo);
    public static Item vemosBoots = new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.FEET, vemInfo);

    //New additions
    public static Item ayeracoFragmentB = new ItemMod("ayeraco_fragment_blue");
    public static Item ayeracoFragmentG = new ItemMod("ayeraco_fragment_green");
    public static Item ayeracoFragmentP = new ItemMod("ayeraco_fragment_purple");
    public static Item ayeracoFragmentR = new ItemMod("ayeraco_fragment_red");
    public static Item ayeracoFragmentY = new ItemMod("ayeraco_fragment_yellow");
    public static Item bedrockChunk = new ItemMod("bedrock_chunk");

    public static void init() {
    }

    public static void CreateJSONs() {
        GenerateJSON.generateItemModelJSONs();
    }



}