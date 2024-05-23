package com.quarri6343.chattranslator;

import com.quarri6343.chattranslator.japanizer.Japanizer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventHandler {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private boolean isProcessing = false;

    @SubscribeEvent
    public void onServerChat(ServerChatEvent event) {
        String message = event.message;

        if (message.isEmpty() || message.startsWith("/") || message.startsWith("#") || isProcessing) {
            return;
        }

        isProcessing = true;
        executorService.submit(() -> {
            String japanizedMessage = Japanizer.japanize(message, new HashMap<>());

            if (!japanizedMessage.isEmpty()) {
                MinecraftServer.getServer().getConfigurationManager().sendChatMsg(
                    new ChatComponentText("\u00A7" + "6" + "(" + japanizedMessage + ")" + "\u00A7" + "r")
                );
            }
            isProcessing = false;
        });
    }
}
