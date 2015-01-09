package ato.tempblocks.block

import java.util.Random

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

abstract class BlockTemp(material: Material) extends Block(material) {
  setHardness(0)
  setCreativeTab(CreativeTabs.tabBlock)

  override def quantityDropped(random: Random): Int = 0

  override def canSilkHarvest: Boolean = true

  override def isOpaqueCube: Boolean = false
}
