package com.onaple.jessietags;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class PriceGetCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        ItemStack item = ((Player) src).getItemInHand(HandTypes.MAIN_HAND).get();

        Optional<Integer> price = item.get(JessieKeys.PRICE_TAG);
        if(price.isPresent()){
          src.sendMessage(Text.builder("item price is "+ price.get()).toText());
        } else  {
            src.sendMessage(Text.builder("no item price found").toText());
        }
        return CommandResult.success();
    }
}
