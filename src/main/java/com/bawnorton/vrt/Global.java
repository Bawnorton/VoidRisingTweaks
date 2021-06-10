package com.bawnorton.vrt;

import com.bawnorton.vrt.addons.blocks.BlockInfo;
import com.bawnorton.vrt.addons.blocks.BlockInfoMap;
import net.minecraft.util.math.BlockPos;
import thaumcraft.common.entities.EntityFluxRift;

import java.util.ArrayList;
import java.util.List;

public class Global {

    public static final String MOD_ID = "vrt";
    public static final String MOD_NAME = "Void Rising Tweaks";
    public static final String VERSION = "1.0.0";

    public static final String VRT_PROXY_CLIENT_PROXY = "com.bawnorton.vrt.proxy.ClientProxy";
    public static final String VRT_PROXY_COMMON_PROXY = "com.bawnorton.vrt.proxy.CommonProxy";

    public static BlockInfoMap<BlockPos, BlockInfo> blocks = new BlockInfoMap<>();
    public static List<EntityFluxRift> rifts = new ArrayList<>();

    public static final int ENTITY_CRAWLER = 401;
    public static final int ENTITY_BOSS = 501;
}
