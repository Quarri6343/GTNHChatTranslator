package com.quarri6343.chattranslator;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class LangCommand extends CommandBase {

    public static CurrentLang currentLang = CurrentLang.EN;

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public String getCommandName() {
        return "lang";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/lang <ja or en>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0) {
            if (args[0].equals("ja")) {
                currentLang = CurrentLang.JA;
            } else if (args[0].equals("cn")) {
                currentLang = CurrentLang.CN;
            } else if (args[0].equals("en")) {
                currentLang = CurrentLang.EN;
            } else if (args[0].equals("fi")) {
                currentLang = CurrentLang.FI;
            }
        } else {
            sender.addChatMessage(new ChatComponentText("Usage: " + getCommandUsage(sender)));
        }
    }
}
