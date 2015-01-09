package ato.tempblocks.tileentity

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity

class TileEntityCollapse extends TileEntity {

  var life = 20 * 3

  override def updateEntity() {
    life -= 1
    if (life <= 0) {
      getWorldObj.playSoundEffect(xCoord + 0.5f, yCoord + 0.5f, zCoord + 0.5f, "dig.glass", 0.3f, 0.6f)
      getWorldObj.setBlockToAir(xCoord, yCoord, zCoord)
    }
  }

  override def writeToNBT(nbttag: NBTTagCompound): Unit = {
    super.writeToNBT(nbttag)
    nbttag.setByte("CollapseLife", life.toByte)
  }

  override def readFromNBT(nbttag: NBTTagCompound): Unit = {
    super.readFromNBT(nbttag)
    life = nbttag.getByte("CollapseLife")
  }
}
