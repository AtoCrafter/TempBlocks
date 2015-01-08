package ato.tempblocks

import ato.tempblocks.block.{BlockChain, BlockCollapse, BlockFrame}
import ato.tempblocks.item.ItemFootBlockSupplier
import ato.tempblocks.proxy.ProxyCommon
import ato.tempblocks.tileentity.TileEntityCollapse
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "TempBlocks", modLanguage = "scala")
object TempBlocks {

  @SidedProxy(
    clientSide = "ato.tempblocks.proxy.ProxyClient",
    serverSide = "ato.tempblocks.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val itemSupplier = new ItemFootBlockSupplier()

  val blockFrame = new BlockFrame()
  val blockCollapse = new BlockCollapse()
  val blockChain = new BlockChain()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerItem(itemSupplier, "FootBlockSupplier")

    GameRegistry.registerBlock(blockFrame, "FrameBlock")
    GameRegistry.registerBlock(blockCollapse, "CollapseBlock")
    GameRegistry.registerBlock(blockChain, "ChainBlock")

    GameRegistry.registerTileEntity(classOf[TileEntityCollapse], "CollapseBlock")
  }
}
