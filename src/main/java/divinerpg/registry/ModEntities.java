package divinerpg.registry;

import static divinerpg.utils.SpawnEggColors.Dimension.APALACHIA;
import static divinerpg.utils.SpawnEggColors.Dimension.ARCANA;
import static divinerpg.utils.SpawnEggColors.Dimension.BOSS;
import static divinerpg.utils.SpawnEggColors.Dimension.EDEN;
import static divinerpg.utils.SpawnEggColors.Dimension.END;
import static divinerpg.utils.SpawnEggColors.Dimension.ICEIKA;
import static divinerpg.utils.SpawnEggColors.Dimension.MORTUM;
import static divinerpg.utils.SpawnEggColors.Dimension.NETHER;
import static divinerpg.utils.SpawnEggColors.Dimension.OVERWORLD;
import static divinerpg.utils.SpawnEggColors.Dimension.SKYTHERN;
import static divinerpg.utils.SpawnEggColors.Dimension.WILDWOOD;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
import divinerpg.objects.entities.assets.render.arcana.RenderCaptainMerik;
import divinerpg.objects.entities.assets.render.arcana.RenderDatticon;
import divinerpg.objects.entities.assets.render.arcana.RenderDeathHound;
import divinerpg.objects.entities.assets.render.arcana.RenderDeathcryx;
import divinerpg.objects.entities.assets.render.arcana.RenderDramix;
import divinerpg.objects.entities.assets.render.arcana.RenderDungeonConstructor;
import divinerpg.objects.entities.assets.render.arcana.RenderDungeonDemon;
import divinerpg.objects.entities.assets.render.arcana.RenderDungeonPrisoner;
import divinerpg.objects.entities.assets.render.arcana.RenderFyracryx;
import divinerpg.objects.entities.assets.render.arcana.RenderGolemOfRejuvenation;
import divinerpg.objects.entities.assets.render.arcana.RenderLeorna;
import divinerpg.objects.entities.assets.render.arcana.RenderLivingStatue;
import divinerpg.objects.entities.assets.render.arcana.RenderLordVatticus;
import divinerpg.objects.entities.assets.render.arcana.RenderParasecta;
import divinerpg.objects.entities.assets.render.arcana.RenderParatiku;
import divinerpg.objects.entities.assets.render.arcana.RenderRazorback;
import divinerpg.objects.entities.assets.render.arcana.RenderRoamer;
import divinerpg.objects.entities.assets.render.arcana.RenderSeimer;
import divinerpg.objects.entities.assets.render.arcana.RenderWarGeneral;
import divinerpg.objects.entities.assets.render.arcana.RenderWraith;
import divinerpg.objects.entities.assets.render.arcana.RenderZelus;
import divinerpg.objects.entities.assets.render.iceika.RenderAlicanto;
import divinerpg.objects.entities.assets.render.iceika.RenderFractite;
import divinerpg.objects.entities.assets.render.iceika.RenderFrostArcher;
import divinerpg.objects.entities.assets.render.iceika.RenderFrosty;
import divinerpg.objects.entities.assets.render.iceika.RenderGlacide;
import divinerpg.objects.entities.assets.render.iceika.RenderHastreus;
import divinerpg.objects.entities.assets.render.iceika.RenderRollum;
import divinerpg.objects.entities.assets.render.iceika.RenderWorkshopMerchant;
import divinerpg.objects.entities.assets.render.iceika.RenderWorkshopTinkerer;
import divinerpg.objects.entities.assets.render.twilight.RenderAdvancedCori;
import divinerpg.objects.entities.assets.render.twilight.RenderAngryBunny;
import divinerpg.objects.entities.assets.render.twilight.RenderApalachiaCadillion;
import divinerpg.objects.entities.assets.render.twilight.RenderApalachiaGolem;
import divinerpg.objects.entities.assets.render.twilight.RenderApalachiaTomo;
import divinerpg.objects.entities.assets.render.twilight.RenderBasilisk;
import divinerpg.objects.entities.assets.render.twilight.RenderBehemoth;
import divinerpg.objects.entities.assets.render.twilight.RenderBunny;
import divinerpg.objects.entities.assets.render.twilight.RenderDemonOfDarkness;
import divinerpg.objects.entities.assets.render.twilight.RenderDensos;
import divinerpg.objects.entities.assets.render.twilight.RenderEdenCadillion;
import divinerpg.objects.entities.assets.render.twilight.RenderEdenTomo;
import divinerpg.objects.entities.assets.render.twilight.RenderEnchantedArcher;
import divinerpg.objects.entities.assets.render.twilight.RenderEnchantedWarrior;
import divinerpg.objects.entities.assets.render.twilight.RenderEpiphite;
import divinerpg.objects.entities.assets.render.twilight.RenderEternalArcher;
import divinerpg.objects.entities.assets.render.twilight.RenderGreenfeet;
import divinerpg.objects.entities.assets.render.twilight.RenderKarot;
import divinerpg.objects.entities.assets.render.twilight.RenderMadivel;
import divinerpg.objects.entities.assets.render.twilight.RenderMage;
import divinerpg.objects.entities.assets.render.twilight.RenderMegalith;
import divinerpg.objects.entities.assets.render.twilight.RenderMoonWolf;
import divinerpg.objects.entities.assets.render.twilight.RenderMortumCadillion;
import divinerpg.objects.entities.assets.render.twilight.RenderMystic;
import divinerpg.objects.entities.assets.render.twilight.RenderReyvor;
import divinerpg.objects.entities.assets.render.twilight.RenderSamek;
import divinerpg.objects.entities.assets.render.twilight.RenderSkythernArcher;
import divinerpg.objects.entities.assets.render.twilight.RenderSkythernFiend;
import divinerpg.objects.entities.assets.render.twilight.RenderSkythernGolem;
import divinerpg.objects.entities.assets.render.twilight.RenderSorcerer;
import divinerpg.objects.entities.assets.render.twilight.RenderSoulFiend;
import divinerpg.objects.entities.assets.render.twilight.RenderSoulSpider;
import divinerpg.objects.entities.assets.render.twilight.RenderSoulStealer;
import divinerpg.objects.entities.assets.render.twilight.RenderSpellbinder;
import divinerpg.objects.entities.assets.render.twilight.RenderSunArcher;
import divinerpg.objects.entities.assets.render.twilight.RenderTwilightArcher;
import divinerpg.objects.entities.assets.render.twilight.RenderTwilightDemon;
import divinerpg.objects.entities.assets.render.twilight.RenderVamacheron;
import divinerpg.objects.entities.assets.render.twilight.RenderVerek;
import divinerpg.objects.entities.assets.render.twilight.RenderWeakCori;
import divinerpg.objects.entities.assets.render.twilight.RenderWildwoodCadillion;
import divinerpg.objects.entities.assets.render.twilight.RenderWildwoodGolem;
import divinerpg.objects.entities.assets.render.twilight.RenderWildwoodTomo;
import divinerpg.objects.entities.assets.render.vanilla.RenderAncientEntity;
import divinerpg.objects.entities.assets.render.vanilla.RenderAridWarrior;
import divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoBlue;
import divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoGreen;
import divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoPurple;
import divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoYellow;
import divinerpg.objects.entities.assets.render.vanilla.RenderAyerecoRed;
import divinerpg.objects.entities.assets.render.vanilla.RenderBrownGrizzle;
import divinerpg.objects.entities.assets.render.vanilla.RenderCaveCrawler;
import divinerpg.objects.entities.assets.render.vanilla.RenderCaveclops;
import divinerpg.objects.entities.assets.render.vanilla.RenderCrab;
import divinerpg.objects.entities.assets.render.vanilla.RenderCyclops;
import divinerpg.objects.entities.assets.render.vanilla.RenderDesertCrawler;
import divinerpg.objects.entities.assets.render.vanilla.RenderEhu;
import divinerpg.objects.entities.assets.render.vanilla.RenderEnderSpider;
import divinerpg.objects.entities.assets.render.vanilla.RenderEnderTriplets;
import divinerpg.objects.entities.assets.render.vanilla.RenderEnderWatcher;
import divinerpg.objects.entities.assets.render.vanilla.RenderEnthralledDramcryx;
import divinerpg.objects.entities.assets.render.vanilla.RenderFrost;
import divinerpg.objects.entities.assets.render.vanilla.RenderGlacon;
import divinerpg.objects.entities.assets.render.vanilla.RenderHellPig;
import divinerpg.objects.entities.assets.render.vanilla.RenderHellSpider;
import divinerpg.objects.entities.assets.render.vanilla.RenderHusk;
import divinerpg.objects.entities.assets.render.vanilla.RenderJackOMan;
import divinerpg.objects.entities.assets.render.vanilla.RenderJungleBat;
import divinerpg.objects.entities.assets.render.vanilla.RenderJungleDramcryx;
import divinerpg.objects.entities.assets.render.vanilla.RenderJungleSpider;
import divinerpg.objects.entities.assets.render.vanilla.RenderKingCrab;
import divinerpg.objects.entities.assets.render.vanilla.RenderKingOfScorchers;
import divinerpg.objects.entities.assets.render.vanilla.RenderKobblin;
import divinerpg.objects.entities.assets.render.vanilla.RenderLiopleurodon;
import divinerpg.objects.entities.assets.render.vanilla.RenderLivestockMerchant;
import divinerpg.objects.entities.assets.render.vanilla.RenderMiner;
import divinerpg.objects.entities.assets.render.vanilla.RenderPumpkinSpider;
import divinerpg.objects.entities.assets.render.vanilla.RenderRainbour;
import divinerpg.objects.entities.assets.render.vanilla.RenderRotatick;
import divinerpg.objects.entities.assets.render.vanilla.RenderSaguaroWorm;
import divinerpg.objects.entities.assets.render.vanilla.RenderScorcher;
import divinerpg.objects.entities.assets.render.vanilla.RenderShark;
import divinerpg.objects.entities.assets.render.vanilla.RenderSmelter;
import divinerpg.objects.entities.assets.render.vanilla.RenderSnapper;
import divinerpg.objects.entities.assets.render.vanilla.RenderStoneGolem;
import divinerpg.objects.entities.assets.render.vanilla.RenderTheEye;
import divinerpg.objects.entities.assets.render.vanilla.RenderTheGrue;
import divinerpg.objects.entities.assets.render.vanilla.RenderTheWatcher;
import divinerpg.objects.entities.assets.render.vanilla.RenderWhale;
import divinerpg.objects.entities.assets.render.vanilla.RenderWhiteGrizzle;
import divinerpg.objects.entities.assets.render.vanilla.RenderWildfire;
import divinerpg.objects.entities.entity.EntityFrostCloud;
import divinerpg.objects.entities.entity.arcana.CaptainMerik;
import divinerpg.objects.entities.entity.arcana.Datticon;
import divinerpg.objects.entities.entity.arcana.DeathHound;
import divinerpg.objects.entities.entity.arcana.Deathcryx;
import divinerpg.objects.entities.entity.arcana.Dramix;
import divinerpg.objects.entities.entity.arcana.DungeonConstructor;
import divinerpg.objects.entities.entity.arcana.DungeonDemon;
import divinerpg.objects.entities.entity.arcana.DungeonPrisoner;
import divinerpg.objects.entities.entity.arcana.Fyracryx;
import divinerpg.objects.entities.entity.arcana.GolemOfRejuvenation;
import divinerpg.objects.entities.entity.arcana.Leorna;
import divinerpg.objects.entities.entity.arcana.LivingStatue;
import divinerpg.objects.entities.entity.arcana.LordVatticus;
import divinerpg.objects.entities.entity.arcana.Parasecta;
import divinerpg.objects.entities.entity.arcana.Paratiku;
import divinerpg.objects.entities.entity.arcana.Razorback;
import divinerpg.objects.entities.entity.arcana.Roamer;
import divinerpg.objects.entities.entity.arcana.Seimer;
import divinerpg.objects.entities.entity.arcana.WarGeneral;
import divinerpg.objects.entities.entity.arcana.Wraith;
import divinerpg.objects.entities.entity.arcana.Zelus;
import divinerpg.objects.entities.entity.iceika.Alicanto;
import divinerpg.objects.entities.entity.iceika.Fractite;
import divinerpg.objects.entities.entity.iceika.FrostArcher;
import divinerpg.objects.entities.entity.iceika.Frosty;
import divinerpg.objects.entities.entity.iceika.Glacide;
import divinerpg.objects.entities.entity.iceika.Hastreus;
import divinerpg.objects.entities.entity.iceika.Rollum;
import divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.WorkshopTinkerer;
import divinerpg.objects.entities.entity.projectiles.EntityAttractor;
import divinerpg.objects.entities.entity.projectiles.EntityBouncingProjectile;
import divinerpg.objects.entities.entity.projectiles.EntityCaveRock;
import divinerpg.objects.entities.entity.projectiles.EntityColoredBullet;
import divinerpg.objects.entities.entity.projectiles.EntityCoriShot;
import divinerpg.objects.entities.entity.projectiles.EntityCorruptedBullet;
import divinerpg.objects.entities.entity.projectiles.EntityDisk;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.objects.entities.entity.projectiles.EntityEnderTripletsFireball;
import divinerpg.objects.entities.entity.projectiles.EntityEvernightProjectile;
import divinerpg.objects.entities.entity.projectiles.EntityFirefly;
import divinerpg.objects.entities.entity.projectiles.EntityFractiteShot;
import divinerpg.objects.entities.entity.projectiles.EntityFrostShot;
import divinerpg.objects.entities.entity.projectiles.EntityFyracryxFireball;
import divinerpg.objects.entities.entity.projectiles.EntityGeneralsStaff;
import divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersMeteor;
import divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersShot;
import divinerpg.objects.entities.entity.projectiles.EntityLamona;
import divinerpg.objects.entities.entity.projectiles.EntityMerikMissile;
import divinerpg.objects.entities.entity.projectiles.EntityMeteor;
import divinerpg.objects.entities.entity.projectiles.EntityParticleBullet;
import divinerpg.objects.entities.entity.projectiles.EntityReflector;
import divinerpg.objects.entities.entity.projectiles.EntitySaguaroWormShot;
import divinerpg.objects.entities.entity.projectiles.EntityScorcherShot;
import divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfDeath;
import divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfIce;
import divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import divinerpg.objects.entities.entity.projectiles.EntityShuriken;
import divinerpg.objects.entities.entity.projectiles.EntitySnowflakeShuriken;
import divinerpg.objects.entities.entity.projectiles.EntitySoulFiendShot;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import divinerpg.objects.entities.entity.projectiles.EntityStar;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightDemonShot;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightMageShot;
import divinerpg.objects.entities.entity.projectiles.EntityVileStorm;
import divinerpg.objects.entities.entity.projectiles.EntityWatcherShot;
import divinerpg.objects.entities.entity.twilight.AdvancedCori;
import divinerpg.objects.entities.entity.twilight.AngryBunny;
import divinerpg.objects.entities.entity.twilight.ApalachiaCadillion;
import divinerpg.objects.entities.entity.twilight.ApalachiaGolem;
import divinerpg.objects.entities.entity.twilight.ApalachiaTomo;
import divinerpg.objects.entities.entity.twilight.Basilisk;
import divinerpg.objects.entities.entity.twilight.Behemoth;
import divinerpg.objects.entities.entity.twilight.Bunny;
import divinerpg.objects.entities.entity.twilight.DemonOfDarkness;
import divinerpg.objects.entities.entity.twilight.Densos;
import divinerpg.objects.entities.entity.twilight.EdenCadillion;
import divinerpg.objects.entities.entity.twilight.EdenTomo;
import divinerpg.objects.entities.entity.twilight.EnchantedArcher;
import divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
import divinerpg.objects.entities.entity.twilight.Epiphite;
import divinerpg.objects.entities.entity.twilight.EternalArcher;
import divinerpg.objects.entities.entity.twilight.Greenfeet;
import divinerpg.objects.entities.entity.twilight.Karot;
import divinerpg.objects.entities.entity.twilight.Madivel;
import divinerpg.objects.entities.entity.twilight.Mage;
import divinerpg.objects.entities.entity.twilight.Megalith;
import divinerpg.objects.entities.entity.twilight.MoonWolf;
import divinerpg.objects.entities.entity.twilight.MortumCadillion;
import divinerpg.objects.entities.entity.twilight.Mystic;
import divinerpg.objects.entities.entity.twilight.Reyvor;
import divinerpg.objects.entities.entity.twilight.Samek;
import divinerpg.objects.entities.entity.twilight.SkythernArcher;
import divinerpg.objects.entities.entity.twilight.SkythernFiend;
import divinerpg.objects.entities.entity.twilight.SkythernGolem;
import divinerpg.objects.entities.entity.twilight.Sorcerer;
import divinerpg.objects.entities.entity.twilight.SoulFiend;
import divinerpg.objects.entities.entity.twilight.SoulSpider;
import divinerpg.objects.entities.entity.twilight.SoulStealer;
import divinerpg.objects.entities.entity.twilight.Spellbinder;
import divinerpg.objects.entities.entity.twilight.SunArcher;
import divinerpg.objects.entities.entity.twilight.TwilightArcher;
import divinerpg.objects.entities.entity.twilight.TwilightDemon;
import divinerpg.objects.entities.entity.twilight.Vamacheron;
import divinerpg.objects.entities.entity.twilight.Verek;
import divinerpg.objects.entities.entity.twilight.WeakCori;
import divinerpg.objects.entities.entity.twilight.WildwoodCadillion;
import divinerpg.objects.entities.entity.twilight.WildwoodGolem;
import divinerpg.objects.entities.entity.twilight.WildwoodTomo;
import divinerpg.objects.entities.entity.vanilla.AncientEntity;
import divinerpg.objects.entities.entity.vanilla.AridWarrior;
import divinerpg.objects.entities.entity.vanilla.BrownGrizzle;
import divinerpg.objects.entities.entity.vanilla.CaveCrawler;
import divinerpg.objects.entities.entity.vanilla.Caveclops;
import divinerpg.objects.entities.entity.vanilla.Crab;
import divinerpg.objects.entities.entity.vanilla.Cyclops;
import divinerpg.objects.entities.entity.vanilla.DesertCrawler;
import divinerpg.objects.entities.entity.vanilla.Ehu;
import divinerpg.objects.entities.entity.vanilla.EnderSpider;
import divinerpg.objects.entities.entity.vanilla.EnderTriplets;
import divinerpg.objects.entities.entity.vanilla.EnderWatcher;
import divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import divinerpg.objects.entities.entity.vanilla.Frost;
import divinerpg.objects.entities.entity.vanilla.Glacon;
import divinerpg.objects.entities.entity.vanilla.HellPig;
import divinerpg.objects.entities.entity.vanilla.HellSpider;
import divinerpg.objects.entities.entity.vanilla.Husk;
import divinerpg.objects.entities.entity.vanilla.JackOMan;
import divinerpg.objects.entities.entity.vanilla.JungleBat;
import divinerpg.objects.entities.entity.vanilla.JungleDramcryx;
import divinerpg.objects.entities.entity.vanilla.JungleSpider;
import divinerpg.objects.entities.entity.vanilla.KingCrab;
import divinerpg.objects.entities.entity.vanilla.KingOfScorchers;
import divinerpg.objects.entities.entity.vanilla.Kobblin;
import divinerpg.objects.entities.entity.vanilla.Liopleurodon;
import divinerpg.objects.entities.entity.vanilla.LivestockMerchant;
import divinerpg.objects.entities.entity.vanilla.Miner;
import divinerpg.objects.entities.entity.vanilla.PumpkinSpider;
import divinerpg.objects.entities.entity.vanilla.Rainbour;
import divinerpg.objects.entities.entity.vanilla.Rotatick;
import divinerpg.objects.entities.entity.vanilla.SaguaroWorm;
import divinerpg.objects.entities.entity.vanilla.Scorcher;
import divinerpg.objects.entities.entity.vanilla.Shark;
import divinerpg.objects.entities.entity.vanilla.Smelter;
import divinerpg.objects.entities.entity.vanilla.Snapper;
import divinerpg.objects.entities.entity.vanilla.StoneGolem;
import divinerpg.objects.entities.entity.vanilla.TheEye;
import divinerpg.objects.entities.entity.vanilla.TheGrue;
import divinerpg.objects.entities.entity.vanilla.TheWatcher;
import divinerpg.objects.entities.entity.vanilla.Whale;
import divinerpg.objects.entities.entity.vanilla.WhiteGrizzle;
import divinerpg.objects.entities.entity.vanilla.Wildfire;
import divinerpg.objects.entities.entity.vanilla.ayeraco.AyeracoBlue;
import divinerpg.objects.entities.entity.vanilla.ayeraco.AyeracoGreen;
import divinerpg.objects.entities.entity.vanilla.ayeraco.AyeracoPurple;
import divinerpg.objects.entities.entity.vanilla.ayeraco.AyeracoRed;
import divinerpg.objects.entities.entity.vanilla.ayeraco.AyeracoYellow;
import divinerpg.utils.SpawnEggColors;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModEntities {

    public static int projectileID = 0;
    public static int mobID = 500;

    @SubscribeEvent
    public static void registerEnities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        registry.registerAll(initProjectiles());
        registry.registerAll(initMobs());
    }

    public static EntityEntry buildEntityEntry(Class entityClass, String entityID, SpawnEggColors.Dimension dimension) {
        SpawnEggColors colors = SpawnEggColors.getColorsForDimension(dimension);

        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(Reference.MODID, entityID), mobID++).name(Reference.MODID + "." + entityID).tracker(128, 3, true)
                .egg(colors.getPrimaryColor(), colors.getSecondaryColor()).build();
    }

    public static EntityEntry buildProjectileEntry(Class entityClass, String entityID) {
        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(Reference.MODID, entityID), projectileID++).name(Reference.MODID + "." + entityID)
                .tracker(250, 5, true).build();
    }

    public static EntityEntry[] initMobs() {
        EntityEntry[] divineMobs = {
                // Overworld
                buildEntityEntry(AridWarrior.class, "arid_warrior", OVERWORLD),
                buildEntityEntry(CaveCrawler.class, "cave_crawler", OVERWORLD),
                buildEntityEntry(Caveclops.class, "caveclops", OVERWORLD),
                buildEntityEntry(Crab.class, "crab", OVERWORLD), buildEntityEntry(Cyclops.class, "cyclops", OVERWORLD),
                buildEntityEntry(DesertCrawler.class, "desert_crawler", OVERWORLD),
                buildEntityEntry(Ehu.class, "ehu", OVERWORLD),
                buildEntityEntry(EnthralledDramcryx.class, "enthralled_dramcryx", OVERWORLD),
                buildEntityEntry(Frost.class, "frost", OVERWORLD), buildEntityEntry(Glacon.class, "glacon", OVERWORLD),
                buildEntityEntry(BrownGrizzle.class, "brown_grizzle", OVERWORLD),
                buildEntityEntry(WhiteGrizzle.class, "white_grizzle", OVERWORLD),
                buildEntityEntry(Husk.class, "husk", OVERWORLD),
                buildEntityEntry(JackOMan.class, "jack_o_man", OVERWORLD),
                buildEntityEntry(JungleBat.class, "jungle_bat", OVERWORLD),
                buildEntityEntry(JungleDramcryx.class, "jungle_dramcryx", OVERWORLD),
                buildEntityEntry(JungleSpider.class, "jungle_spider", OVERWORLD),
                buildEntityEntry(KingCrab.class, "king_crab", OVERWORLD),
                buildEntityEntry(Kobblin.class, "kobblin", OVERWORLD),
                buildEntityEntry(Liopleurodon.class, "liopleurodon", OVERWORLD),
                buildEntityEntry(LivestockMerchant.class, "livestock_merchant", OVERWORLD),
                buildEntityEntry(Miner.class, "miner", OVERWORLD),
                buildEntityEntry(PumpkinSpider.class, "pumpkin_spider", OVERWORLD),
                buildEntityEntry(Rainbour.class, "rainbour", OVERWORLD),
                buildEntityEntry(Rotatick.class, "rotatick", OVERWORLD),
                buildEntityEntry(SaguaroWorm.class, "saguaro_worm", OVERWORLD),
                buildEntityEntry(Shark.class, "shark", OVERWORLD),
                buildEntityEntry(Smelter.class, "smelter", OVERWORLD),
                buildEntityEntry(Snapper.class, "snapper", OVERWORLD),
                buildEntityEntry(StoneGolem.class, "stone_golem", OVERWORLD),
                buildEntityEntry(TheEye.class, "the_eye", OVERWORLD),
                buildEntityEntry(TheGrue.class, "the_grue", OVERWORLD),
                buildEntityEntry(Whale.class, "whale", OVERWORLD),

                // Nether
                buildEntityEntry(HellPig.class, "hell_pig", NETHER),
                buildEntityEntry(HellSpider.class, "hell_spider", NETHER),
                buildEntityEntry(Scorcher.class, "scorcher", NETHER),
                buildEntityEntry(Wildfire.class, "wildfire", NETHER),

                // End
                buildEntityEntry(EnderSpider.class, "ender_spider", END),
                buildEntityEntry(EnderTriplets.class, "ender_triplets", END),
                buildEntityEntry(EnderWatcher.class, "ender_watcher", END),

                // Iceika
                buildEntityEntry(Alicanto.class, "alicanto", ICEIKA),
                buildEntityEntry(Fractite.class, "fractite", ICEIKA),
                buildEntityEntry(FrostArcher.class, "frost_archer", ICEIKA),
                buildEntityEntry(Frosty.class, "frosty", ICEIKA), buildEntityEntry(Glacide.class, "glacide", ICEIKA),
                buildEntityEntry(Hastreus.class, "hastreus", ICEIKA), buildEntityEntry(Rollum.class, "rollum", ICEIKA),
                buildEntityEntry(WorkshopMerchant.class, "workshop_merchant", ICEIKA),
                buildEntityEntry(WorkshopTinkerer.class, "workshop_tinkerer", ICEIKA),

                // Eden
                buildEntityEntry(Bunny.class, "bunny", EDEN),
                buildEntityEntry(EdenCadillion.class, "eden_cadillion", EDEN),
                buildEntityEntry(EdenTomo.class, "eden_tomo", EDEN),
                buildEntityEntry(Greenfeet.class, "greenfeet", EDEN), buildEntityEntry(Madivel.class, "madivel", EDEN),
                buildEntityEntry(SunArcher.class, "sun_archer", EDEN),
                buildEntityEntry(WeakCori.class, "weak_cori", EDEN),

                // Wildwood
                buildEntityEntry(Behemoth.class, "behemoth", WILDWOOD),
                buildEntityEntry(Epiphite.class, "epiphite", WILDWOOD), buildEntityEntry(Mage.class, "mage", WILDWOOD),
                buildEntityEntry(MoonWolf.class, "moon_wolf", WILDWOOD),
                buildEntityEntry(Verek.class, "verek", WILDWOOD),
                buildEntityEntry(WildwoodCadillion.class, "wildwood_cadillion", WILDWOOD),
                buildEntityEntry(WildwoodGolem.class, "wildwood_golem", WILDWOOD),
                buildEntityEntry(WildwoodTomo.class, "wildwood_tomo", WILDWOOD),

                // Apalachia
                buildEntityEntry(ApalachiaCadillion.class, "apalachia_cadillion", APALACHIA),
                buildEntityEntry(ApalachiaGolem.class, "apalachia_golem", APALACHIA),
                buildEntityEntry(ApalachiaTomo.class, "apalachia_tomo", APALACHIA),
                buildEntityEntry(EnchantedArcher.class, "enchanted_archer", APALACHIA),
                buildEntityEntry(EnchantedWarrior.class, "enchanted_warrior", APALACHIA),
                buildEntityEntry(Spellbinder.class, "spellbinder", APALACHIA),

                // Skythern
                buildEntityEntry(AdvancedCori.class, "advanced_cori", SKYTHERN),
                buildEntityEntry(Megalith.class, "megalith", SKYTHERN),
                buildEntityEntry(Mystic.class, "mystic", SKYTHERN), buildEntityEntry(Samek.class, "samek", SKYTHERN),
                buildEntityEntry(SkythernArcher.class, "skythern_archer", SKYTHERN),
                buildEntityEntry(SkythernFiend.class, "skythern_fiend", SKYTHERN),
                buildEntityEntry(SkythernGolem.class, "skythern_golem", SKYTHERN),

                // Mortum
                buildEntityEntry(AngryBunny.class, "angry_bunny", MORTUM),
                buildEntityEntry(Basilisk.class, "basilisk", MORTUM),
                buildEntityEntry(DemonOfDarkness.class, "demon_of_darkness", MORTUM),
                buildEntityEntry(MortumCadillion.class, "mortum_cadillion", MORTUM),
                buildEntityEntry(Sorcerer.class, "sorcerer", MORTUM),
                buildEntityEntry(SoulStealer.class, "soul_stealer", MORTUM),
                buildEntityEntry(SoulSpider.class, "soul_spider", MORTUM),
                buildEntityEntry(TwilightArcher.class, "twilight_archer", MORTUM),

                // Arcana
                buildEntityEntry(CaptainMerik.class, "captain_merik", ARCANA),
                buildEntityEntry(Datticon.class, "datticon", ARCANA),
                buildEntityEntry(Deathcryx.class, "deathcryx", ARCANA),
                buildEntityEntry(DeathHound.class, "death_hound", ARCANA),
                buildEntityEntry(DungeonConstructor.class, "dungeon_constructor", ARCANA),
                buildEntityEntry(DungeonDemon.class, "dungeon_demon", ARCANA),
                buildEntityEntry(DungeonPrisoner.class, "dungeon_prisoner", ARCANA),
                buildEntityEntry(Fyracryx.class, "fyracryx", ARCANA), buildEntityEntry(Leorna.class, "leorna", ARCANA),
                buildEntityEntry(LivingStatue.class, "living_statue", ARCANA),
                buildEntityEntry(Paratiku.class, "paratiku", ARCANA),
                buildEntityEntry(Razorback.class, "razorback", ARCANA),
                buildEntityEntry(GolemOfRejuvenation.class, "golem_of_rejuvenation", ARCANA),
                buildEntityEntry(Roamer.class, "roamer", ARCANA), buildEntityEntry(Seimer.class, "seimer", ARCANA),
                buildEntityEntry(LordVatticus.class, "lord_vatticus", ARCANA),
                buildEntityEntry(WarGeneral.class, "war_general", ARCANA),
                buildEntityEntry(Wraith.class, "wraith", ARCANA), buildEntityEntry(Zelus.class, "zelus", ARCANA),

                // Boss
                buildEntityEntry(AncientEntity.class, "ancient_entity", BOSS),
                buildEntityEntry(AyeracoBlue.class, "ayeraco_blue", BOSS),
                buildEntityEntry(AyeracoGreen.class, "ayeraco_green", BOSS),
                buildEntityEntry(AyeracoPurple.class, "ayeraco_purple", BOSS),
                buildEntityEntry(AyeracoRed.class, "ayeraco_red", BOSS),
                buildEntityEntry(AyeracoYellow.class, "ayeraco_yellow", BOSS),
                buildEntityEntry(Densos.class, "densos", BOSS), buildEntityEntry(Dramix.class, "dramix", BOSS),
                buildEntityEntry(EternalArcher.class, "eternal_archer", BOSS),
                buildEntityEntry(Karot.class, "karot", BOSS),
                buildEntityEntry(KingOfScorchers.class, "king_of_scorchers", BOSS),
                buildEntityEntry(Reyvor.class, "reyvor", BOSS), buildEntityEntry(SoulFiend.class, "soul_fiend", BOSS),
                buildEntityEntry(TheWatcher.class, "the_watcher", BOSS),
                buildEntityEntry(TwilightDemon.class, "twilight_demon", BOSS),
                buildEntityEntry(Vamacheron.class, "vamacheron", BOSS),
                buildEntityEntry(Parasecta.class, "parasecta", BOSS)

        };

        return divineMobs;
    }

    public static EntityEntry[] initProjectiles() {
        // Projectiles
        EntityEntry[] divineProjectiles = { buildProjectileEntry(EntityCaveRock.class, "cave_rock"),
                buildProjectileEntry(EntitySerenadeOfDeath.class, "serenade_of_death"),
                buildProjectileEntry(EntitySerenadeOfIce.class, "serenade_of_ice"),
                buildProjectileEntry(EntityEnderTripletsFireball.class, "ender_triplets_fireball"),
                buildProjectileEntry(EntityFractiteShot.class, "fractite_shot"),
                buildProjectileEntry(EntityFrostShot.class, "frost_shot"),
                buildProjectileEntry(EntityFrostCloud.class, "frost_cloud"),
                buildProjectileEntry(EntityKingOfScorchersMeteor.class, "king_of_scorchers_meteor"),
                buildProjectileEntry(EntityKingOfScorchersShot.class, "king_of_scorchers_shot"),
                buildProjectileEntry(EntitySaguaroWormShot.class, "saguaro_worm_shot"),
                buildProjectileEntry(EntityScorcherShot.class, "scorcher_shot"),
                buildProjectileEntry(EntityShuriken.class, "shuriken"),
                buildProjectileEntry(EntitySparkler.class, "sparkler"),
                buildProjectileEntry(EntityWatcherShot.class, "watcher_shot"),
                buildProjectileEntry(EntityVileStorm.class, "vile_storm"),
                buildProjectileEntry(EntitySnowflakeShuriken.class, "snowflake_shuriken"),
                buildProjectileEntry(EntityShooterBullet.class, "shooter_bullet"),
                buildProjectileEntry(EntityParticleBullet.class, "particle_bullet"),
                buildProjectileEntry(EntityColoredBullet.class, "colored_bullet"),
                buildProjectileEntry(EntityCorruptedBullet.class, "corrupted_bullet"),
                buildProjectileEntry(EntitySoundOfMusic.class, "sound_of_music"),
                buildProjectileEntry(EntitySoundOfCarols.class, "sound_of_carols"),
                buildProjectileEntry(EntityDivineArrow.class, "arrow_shot"),
                buildProjectileEntry(EntityCoriShot.class, "cori_shot"),
                buildProjectileEntry(EntityTwilightMageShot.class, "twilight_mage_shot"),
                buildProjectileEntry(EntitySoulFiendShot.class, "soul_fiend_shot"),
                buildProjectileEntry(EntityDisk.class, "disk"), buildProjectileEntry(EntityGrenade.class, "grenade"),
                buildProjectileEntry(EntityAttractor.class, "attractor"),
                buildProjectileEntry(EntityGeneralsStaff.class, "generals_staff"),
                buildProjectileEntry(EntityMeteor.class, "meteor"), buildProjectileEntry(EntityStar.class, "star"),
                buildProjectileEntry(EntityBouncingProjectile.class, "bouncing"),
                buildProjectileEntry(EntityEvernightProjectile.class, "evernight"),
                buildProjectileEntry(EntityLamona.class, "lamona"),
                buildProjectileEntry(EntityFirefly.class, "firefly"),
                buildProjectileEntry(EntityReflector.class, "reflector"),
                buildProjectileEntry(EntityFyracryxFireball.class, "fyracryx_fireball"),
                buildProjectileEntry(EntityTwilightDemonShot.class, "twilight_demon_shot"),
                buildProjectileEntry(EntityMerikMissile.class, "meriks_missile") };

        if (Config.debug) {
            DivineRPG.logger.info(Reference.MODID + " entities have been loaded");
        }

        return divineProjectiles;
    }

    public static void initLoot() {
        LootTableList.register(Alicanto.LOOT);
        LootTableList.register(ApalachiaGolem.LOOT);
        LootTableList.register(AridWarrior.LOOT);
        LootTableList.register(AyeracoBlue.LOOT);
        LootTableList.register(AyeracoGreen.LOOT);
        LootTableList.register(AyeracoPurple.LOOT);
        LootTableList.register(AyeracoRed.LOOT);
        LootTableList.register(AyeracoYellow.LOOT);
        LootTableList.register(Basilisk.LOOT);
        LootTableList.register(Behemoth.LOOT);
        LootTableList.register(CaveCrawler.LOOT);
        LootTableList.register(Caveclops.LOOT);
        LootTableList.register(Crab.LOOT);
        LootTableList.register(Cyclops.LOOT);
        LootTableList.register(Deathcryx.LOOT);
        LootTableList.register(DeathHound.LOOT);
        LootTableList.register(DemonOfDarkness.LOOT);
        LootTableList.register(Densos.LOOT);
        LootTableList.register(DesertCrawler.LOOT);
        LootTableList.register(Dramix.LOOT);
        LootTableList.register(DungeonConstructor.LOOT);
        LootTableList.register(DungeonDemon.LOOT);
        LootTableList.register(DungeonPrisoner.LOOT);
        LootTableList.register(EnchantedArcher.LOOT);
        LootTableList.register(EnchantedWarrior.LOOT);
        LootTableList.register(EnderSpider.LOOT);
        LootTableList.register(EnderTriplets.LOOT);
        LootTableList.register(EnderWatcher.LOOT);
        LootTableList.register(EnthralledDramcryx.LOOT);
        LootTableList.register(Epiphite.LOOT);
        LootTableList.register(EternalArcher.LOOT);
        LootTableList.register(Fractite.LOOT);
        LootTableList.register(Frost.LOOT);
        LootTableList.register(Frosty.LOOT);
        LootTableList.register(Glacide.LOOT);
        LootTableList.register(Glacon.LOOT);
        LootTableList.register(Hastreus.LOOT);
        LootTableList.register(HellSpider.LOOT);
        LootTableList.register(JungleBat.LOOT);
        LootTableList.register(JungleDramcryx.LOOT);
        LootTableList.register(JungleSpider.LOOT);
        LootTableList.register(Karot.LOOT);
        LootTableList.register(KingCrab.LOOT);
        LootTableList.register(KingOfScorchers.LOOT);
        LootTableList.register(Kobblin.LOOT);
        LootTableList.register(Liopleurodon.LOOT);
        LootTableList.register(Madivel.LOOT);
        LootTableList.register(Mage.LOOT);
        LootTableList.register(Megalith.LOOT);
        LootTableList.register(Miner.LOOT);
        LootTableList.register(Mystic.LOOT);
        LootTableList.register(Parasecta.LOOT);
        LootTableList.register(PumpkinSpider.LOOT);
        LootTableList.register(Rainbour.LOOT);
        LootTableList.register(Reyvor.LOOT);
        LootTableList.register(Rollum.LOOT);
        LootTableList.register(Rotatick.LOOT);
        LootTableList.register(Samek.LOOT);
        LootTableList.register(Scorcher.LOOT);
        LootTableList.register(Shark.LOOT);
        LootTableList.register(SkythernFiend.LOOT);
        LootTableList.register(Sorcerer.LOOT);
        LootTableList.register(SoulFiend.LOOT);
        LootTableList.register(SoulStealer.LOOT);
        LootTableList.register(Spellbinder.LOOT);
        LootTableList.register(SunArcher.LOOT);
        LootTableList.register(TheEye.LOOT);
        LootTableList.register(TheGrue.LOOT);
        LootTableList.register(TheWatcher.LOOT);
        LootTableList.register(TwilightArcher.LOOT);
        LootTableList.register(TwilightDemon.LOOT);
        LootTableList.register(Vamacheron.LOOT);
        LootTableList.register(Verek.LOOT);
        LootTableList.register(WeakCori.LOOT);
        LootTableList.register(Whale.LOOT);
        LootTableList.register(Wildfire.LOOT);

        if (Config.debug) {
            DivineRPG.logger.info(Reference.MODID + " loot has been loaded");
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Projectiles
        EntityCaveRock.renderMe();
        EntityEnderTripletsFireball.renderMe();
        EntityFractiteShot.renderMe();
        EntityFrostShot.renderMe();
        EntityFrostCloud.renderMe();
        EntityKingOfScorchersMeteor.renderMe();
        EntityKingOfScorchersShot.renderMe();
        EntitySaguaroWormShot.renderMe();
        EntityScorcherShot.renderMe();
        EntityVileStorm.renderMe();
        EntityWatcherShot.renderMe();
        EntitySnowflakeShuriken.renderMe();
        EntityShooterBullet.renderMe();
        EntityDisk.renderMe();
        EntityGrenade.renderMe();
        EntityCorruptedBullet.renderMe();
        EntitySerenadeOfDeath.renderMe();
        EntitySerenadeOfIce.renderMe();
        EntitySoundOfMusic.renderMe();
        EntitySoundOfCarols.renderMe();
        EntityDivineArrow.renderMe();
        EntityCoriShot.renderMe();
        EntityAttractor.renderMe();
        EntitySparkler.renderMe();
        EntityGeneralsStaff.renderMe();
        EntityMeteor.renderMe();
        EntityStar.renderMe();
        EntityBouncingProjectile.renderMe();
        EntityEvernightProjectile.renderMe();
        EntityLamona.renderMe();
        EntityFirefly.renderMe();
        EntityReflector.renderMe();
        EntityFyracryxFireball.renderMe();
        EntityMerikMissile.renderMe();

        // Arcana
        RenderingRegistry.registerEntityRenderingHandler(CaptainMerik.class, RenderCaptainMerik.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Datticon.class, RenderDatticon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Deathcryx.class, RenderDeathcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonDemon.class, RenderDungeonDemon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonPrisoner.class, RenderDungeonPrisoner.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Fyracryx.class, RenderFyracryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Razorback.class, RenderRazorback.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(GolemOfRejuvenation.class, RenderGolemOfRejuvenation.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Roamer.class, RenderRoamer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Seimer.class, RenderSeimer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Zelus.class, RenderZelus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Wraith.class, RenderWraith.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Leorna.class, RenderLeorna.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LivingStatue.class, RenderLivingStatue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Parasecta.class, RenderParasecta.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Paratiku.class, RenderParatiku.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LordVatticus.class, RenderLordVatticus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WarGeneral.class, RenderWarGeneral.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonConstructor.class, RenderDungeonConstructor.FACTORY);

        // Iceika
        RenderingRegistry.registerEntityRenderingHandler(Alicanto.class, RenderAlicanto.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(FrostArcher.class, RenderFrostArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Fractite.class, RenderFractite.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Frosty.class, RenderFrosty.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Glacide.class, RenderGlacide.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Hastreus.class, RenderHastreus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rollum.class, RenderRollum.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WorkshopTinkerer.class, RenderWorkshopTinkerer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WorkshopMerchant.class, RenderWorkshopMerchant.FACTORY);

        // Twilight
        RenderingRegistry.registerEntityRenderingHandler(AngryBunny.class, RenderAngryBunny.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Basilisk.class, RenderBasilisk.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Behemoth.class, RenderBehemoth.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Bunny.class, RenderBunny.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EdenCadillion.class, RenderEdenCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WeakCori.class, RenderWeakCori.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Densos.class, RenderDensos.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Epiphite.class, RenderEpiphite.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EternalArcher.class, RenderEternalArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Greenfeet.class, RenderGreenfeet.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Karot.class, RenderKarot.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Madivel.class, RenderMadivel.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Mage.class, RenderMage.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Megalith.class, RenderMegalith.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MoonWolf.class, RenderMoonWolf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Mystic.class, RenderMystic.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Samek.class, RenderSamek.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernFiend.class, RenderSkythernFiend.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Sorcerer.class, RenderSorcerer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulFiend.class, RenderSoulFiend.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulSpider.class, RenderSoulSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulStealer.class, RenderSoulStealer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Spellbinder.class, RenderSpellbinder.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SunArcher.class, RenderSunArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EdenTomo.class, RenderEdenTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TwilightArcher.class, RenderTwilightArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TwilightDemon.class, RenderTwilightDemon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaGolem.class, RenderApalachiaGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Vamacheron.class, RenderVamacheron.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnchantedArcher.class, RenderEnchantedArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernArcher.class, RenderSkythernArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaCadillion.class, RenderApalachiaCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MortumCadillion.class, RenderMortumCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodCadillion.class, RenderWildwoodCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AdvancedCori.class, RenderAdvancedCori.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DemonOfDarkness.class, RenderDemonOfDarkness.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernGolem.class, RenderSkythernGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodGolem.class, RenderWildwoodGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaTomo.class, RenderApalachiaTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodTomo.class, RenderWildwoodTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnchantedWarrior.class, RenderEnchantedWarrior.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Verek.class, RenderVerek.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Reyvor.class, RenderReyvor.FACTORY);

        // Vanilla
        RenderingRegistry.registerEntityRenderingHandler(JungleDramcryx.class, RenderJungleDramcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Shark.class, RenderShark.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Wildfire.class, RenderWildfire.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rotatick.class, RenderRotatick.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheEye.class, RenderTheEye.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderTriplets.class, RenderEnderTriplets.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheWatcher.class, RenderTheWatcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoRed.class, RenderAyerecoRed.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoBlue.class, RenderAyeracoBlue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoYellow.class, RenderAyeracoYellow.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoGreen.class, RenderAyeracoGreen.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoPurple.class, RenderAyeracoPurple.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AridWarrior.class, RenderAridWarrior.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Crab.class, RenderCrab.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(KingCrab.class, RenderKingCrab.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(KingOfScorchers.class, RenderKingOfScorchers.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnthralledDramcryx.class, RenderEnthralledDramcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Ehu.class, RenderEhu.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Frost.class, RenderFrost.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(CaveCrawler.class, RenderCaveCrawler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DesertCrawler.class, RenderDesertCrawler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Glacon.class, RenderGlacon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(BrownGrizzle.class, RenderBrownGrizzle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WhiteGrizzle.class, RenderWhiteGrizzle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheGrue.class, RenderTheGrue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(HellSpider.class, RenderHellSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Husk.class, RenderHusk.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Miner.class, RenderMiner.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JackOMan.class, RenderJackOMan.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JungleBat.class, RenderJungleBat.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JungleSpider.class, RenderJungleSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Kobblin.class, RenderKobblin.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Liopleurodon.class, RenderLiopleurodon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LivestockMerchant.class, RenderLivestockMerchant.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(PumpkinSpider.class, RenderPumpkinSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rainbour.class, RenderRainbour.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Scorcher.class, RenderScorcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Snapper.class, RenderSnapper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Smelter.class, RenderSmelter.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(StoneGolem.class, RenderStoneGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Whale.class, RenderWhale.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderWatcher.class, RenderEnderWatcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Cyclops.class, RenderCyclops.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Caveclops.class, RenderCaveclops.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderSpider.class, RenderEnderSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(HellPig.class, RenderHellPig.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SaguaroWorm.class, RenderSaguaroWorm.FACTORY);

    }

    @SuppressWarnings("deprecation")
    public static void initSpawns() {
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            if (biome.equals(ModBiomes.Iceika)) {
                EntityRegistry.addSpawn(Alicanto.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Fractite.class, 1, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Glacide.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Hastreus.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(FrostArcher.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Frosty.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Rollum.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Eden)) {
                EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WeakCori.class, 1, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WeakCori.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Greenfeet.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Madivel.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.WildWood)) {
                EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WildwoodGolem.class, 3, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Verek.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Mage.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(MoonWolf.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
            } else if (biome.equals(ModBiomes.Apalachia)) {
                EntityRegistry.addSpawn(ApalachiaCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(ApalachiaGolem.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(ApalachiaTomo.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnchantedWarrior.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnchantedArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Spellbinder.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Skythern)) {
                EntityRegistry.addSpawn(SkythernFiend.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SkythernGolem.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SkythernArcher.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Samek.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(AdvancedCori.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Mystic.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Megalith.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Mortum)) {
                EntityRegistry.addSpawn(DemonOfDarkness.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Basilisk.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SoulStealer.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(MortumCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(TwilightArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Sorcerer.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Arcana)) {
                EntityRegistry.addSpawn(Leorna.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Datticon.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Zelus.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(LordVatticus.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(CaptainMerik.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WarGeneral.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
            } else if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.END)) {
                EntityRegistry.addSpawn(EnderSpider.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnderTriplets.class, 1, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnderWatcher.class, 10, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.NETHER)) {
                // EntityRegistry.addSpawn(HellBat.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(HellPig.class, 25, 5, 50, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(HellSpider.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Scorcher.class, 7, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Wildfire.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
            } else if (!(BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.MUSHROOM))) {
                // All Overworld Biomes
                EntityRegistry.addSpawn(Miner.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(JackOMan.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(CaveCrawler.class, 70, 2, 3, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Rotatick.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnthralledDramcryx.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(TheEye.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(TheGrue.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Caveclops.class, 70, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnderSpider.class, 4, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Rainbour.class, 1, 1, 1, EnumCreatureType.AMBIENT, biome);

                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SNOWY)) {
                    EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.CREATURE, biome);
                    EntityRegistry.addSpawn(Frost.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SANDY)) {
                    EntityRegistry.addSpawn(DesertCrawler.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(AridWarrior.class, 35, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(SaguaroWorm.class, 20, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.BEACH)) {
                    EntityRegistry.addSpawn(Crab.class, 100, 4, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(KingCrab.class, 40, 4, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.JUNGLE)) {
                    EntityRegistry.addSpawn(JungleBat.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(JungleDramcryx.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(JungleSpider.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.PLAINS)) {
                    EntityRegistry.addSpawn(Kobblin.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.PLAINS)
                        || BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN)) {
                    EntityRegistry.addSpawn(Cyclops.class, 10, 2, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.FOREST)) {
                    EntityRegistry.addSpawn(PumpkinSpider.class, 20, 1, 1, EnumCreatureType.MONSTER, biome);
                }
            }
        }

        if (Config.debug) {
            DivineRPG.logger.info(Reference.MODID + " spawns have been loaded");
        }
    }
}