package com.mineria.mod.util.compat.jei.infuser;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.mineria.mod.blocks.infuser.InfuserRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

public class InfuserRecipeMaker
{
    public static List<InfuserRecipe> getRecipes(IJeiHelpers helpers)
    {
        IStackHelper stackHelper = helpers.getStackHelper();
        InfuserRecipes instance = InfuserRecipes.getInstance();
        Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualInfuseList();
        List<InfuserRecipe> jeiRecipes = Lists.newArrayList();

        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.rowMap().entrySet())
        {
            for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
            {
                ItemStack input1 = entry.getKey();
                ItemStack input2 = ent.getKey();
                ItemStack output = ent.getValue();
                List<ItemStack> inputs = Lists.newArrayList(input1, input2, new ItemStack(Items.COAL));
                InfuserRecipe recipe = new InfuserRecipe(inputs, output);
                jeiRecipes.add(recipe);
            }
        }
        return jeiRecipes;
    }
}
