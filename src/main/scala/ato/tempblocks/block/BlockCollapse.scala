package ato.tempblocks.block

import ato.tempblocks.tileentity.TileEntityCollapse
import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockCollapse extends BlockTemp(Material.glass) with ITileEntityProvider {

  setBlockName("CollapseBlock")

  override def createNewTileEntity(world: World, meta: Int): TileEntity =
    new TileEntityCollapse()
}
