package ato.tempblocks.block

import ato.tempblocks.TempBlocks
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.world.World

class BlockChain extends BlockTemp(Material.glass) {
  setBlockName("ChainBlock")
  setBlockTextureName("mob_spawner")

  override def breakBlock(world: World, x: Int, y: Int, z: Int, block: Block, meta: Int): Unit = {
    val neighbors = List(
      (x - 1, y, z),
      (x + 1, y, z),
      (x, y - 1, z),
      (x, y + 1, z),
      (x, y, z - 1),
      (x, y, z + 1)
    ).filter((n) => world.getBlock(n._1, n._2, n._3) == TempBlocks.blockChain)
    for (n <- neighbors) {
      world.setBlockToAir(n._1, n._2, n._3)
    }

    super.breakBlock(world, x, y, z, block, meta)
  }
}
