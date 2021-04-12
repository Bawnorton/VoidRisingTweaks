package com.bawnorton.vrt.commands;

import com.bawnorton.vrt.Global;
import com.bawnorton.vrt.events.ChunkEvents;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class TaintTickRate extends CommandBase {
    private final List<String> alias = Lists.newArrayList(Global.MOD_ID, "vrt_taint_tick_rate", "vrt_ttr");

    @Override
    public String getName() {
        return "vrt_taint_tick_rate";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "vrt_taint_tick_rate <rate>";
    }

    @Override
    public List<String> getAliases() {
        return alias;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 1) return;
        else if (args.length > 1) {
            throw new CommandException(TextFormatting.RED + "Too Many Arguments");
        }
        String rate = args[0];
        try {
            if (Integer.parseInt(rate) < 0) throw new NumberFormatException();
            ChunkEvents.tickSpeed = Integer.parseInt(rate);
        } catch (NumberFormatException e) {
            throw new CommandException(TextFormatting.RED + "Rate Must be a Positive, Non Decimal Number");
        }
        sender.sendMessage(new TextComponentString("Tick Rate Set to " + rate));
    }
}
