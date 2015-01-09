package ato.tempblocks.block

import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemBlock
import net.minecraft.world.World

class BlockFrame extends BlockTemp(Material.wood) {
  setBlockName("FrameBlock")
  setBlockTextureName("planks_oak")

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, f1: Float, f2: Float, f3: Float): Boolean = {
    Option(player.getHeldItem) match {
      case Some(item) => item.getItem match {
        case block: ItemBlock =>
          if (block.placeBlockAt(item, player, world, x, y, z, side, f1, f2, f3, block.getMetadata(item.getItemDamage))) {
            item.stackSize -= 1
            true
          } else {
            false
          }
        case _ => false
      }
      case None => false
    }
  }
}
