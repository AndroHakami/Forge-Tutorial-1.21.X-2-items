package net.seep.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.seep.tutorialmod.TutorialMod;
import net.seep.tutorialmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        BlockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        BlockWithItem(ModBlocks.MAGIC_BLOCK);
        BlockWithItem(ModBlocks.DAMAGE_BLOCK);


    }
    private void BlockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
}