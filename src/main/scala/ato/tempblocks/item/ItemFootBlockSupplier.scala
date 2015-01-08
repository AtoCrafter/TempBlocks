package ato.tempblocks.item

import ato.tempblocks.TempBlocks
import ato.tempblocks.tileentity.TileEntityCollapse
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World

class ItemFootBlockSupplier extends Item {

  setUnlocalizedName("FootBlockSupplier")

  override def onUpdate(itemstack: ItemStack, world: World, entity: Entity, p_77663_4_ : Int, p_77663_5_ : Boolean): Unit = if (!entity.isSneaking) entity match {
    case player: EntityPlayer => {
      val px = math.floor(player.posX).toInt
      val y = (player.posY + 0.1).toInt - 2
      val pz = math.floor(player.posZ).toInt
      for (x <- px - 1 to px + 1; z <- pz - 1 to pz + 1) {
        world.getBlock(x, y, z) match {
          case Blocks.air => world.setBlock(x, y, z, TempBlocks.blockCollapse)
          case TempBlocks.blockCollapse => world.getTileEntity(x, y, z) match {
            case tile: TileEntityCollapse => tile.repair
            case _ =>
          }
          case _ =>
        }
      }
    }
    case _ =>
  }
}
