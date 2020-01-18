package com.onaple.jessietags;

import org.slf4j.Logger;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PriceSetCommand implements CommandExecutor {

    @Inject
    Logger logger;

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        int price = args.<Integer>getOne("price").get();
        ItemStack item = ((Player) src).getItemInHand(HandTypes.MAIN_HAND).get();
        item.offer(item.getOrCreate(TagDataManipulator.class).get());
        item.offer(JessieKeys.PRICE_TAG,price);
        logger.info("support = {}, itemStack = {}",item.supports(JessieKeys.PRICE_TAG),item);
        ((Player) src).setItemInHand(HandTypes.MAIN_HAND,item);
        src.sendMessage(Text.of("price", price,"set to", item));
        return CommandResult.success();
    }
}
