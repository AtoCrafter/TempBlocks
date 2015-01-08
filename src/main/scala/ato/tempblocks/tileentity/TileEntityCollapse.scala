package ato.tempblocks.tileentity

import net.minecraft.tileentity.TileEntity

class TileEntityCollapse extends TileEntity {

  var life = 0

  repair

  override def updateEntity() {
    life -= 1
    if (life <= 0) {
      getWorldObj.playSoundEffect(xCoord + 0.5f, yCoord + 0.5f, zCoord + 0.5f, "dig.glass", 0.3f, 0.6f)
      getWorldObj.setBlockToAir(xCoord, yCoord, zCoord)
    }
  }

  def repair = life = TileEntityCollapse.MaxLife
}

object TileEntityCollapse {
  val MaxLife = 20 * 3
}
