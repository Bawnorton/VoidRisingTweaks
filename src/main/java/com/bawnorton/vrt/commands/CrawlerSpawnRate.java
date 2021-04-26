package com.bawnorton.vrt.commands;

import com.bawnorton.vrt.events.PlayerEvents;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CrawlerSpawnRate extends CommandBase {
    private final List<String> alias = Lists.newArrayList("vrt_crawler_spawn_rate", "vrt_csr");

    @Override
    public @NotNull String getName() {
        return "vrt_crawler_spawn_rate";
    }

    @Override
    public @NotNull String getUsage(@NotNull ICommandSender sender) {
        return "vrt_crawler_spawn_rate <rate> (default 200)";
    }

    @Override
    public @NotNull List<String> getAliases() {
        return alias;
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String @NotNull [] args) throws CommandException {
        if (args.length < 1) return;
        else if (args.length > 1) {
            throw new CommandException(TextFormatting.RED + "Too Many Arguments");
        }
        String rate = args[0];
        try {
            if (Integer.parseInt(rate) < 0) throw new NumberFormatException();
            PlayerEvents.spawnRate = Integer.parseInt(rate);
        } catch (NumberFormatException e) {
            throw new CommandException(TextFormatting.RED + "Rate Must be a Positive, Non Decimal Number");
        }
        sender.sendMessage(new TextComponentString("Spawn Rate Set to " + rate));
    }
}
