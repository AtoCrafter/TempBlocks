package ato.tempblocks

import ato.tempblocks.block.{BlockCollapse, BlockFrame}
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

  val blockFrame = new BlockFrame()
  val blockCollapse = new BlockCollapse()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerBlock(blockFrame, "FrameBlock")
    GameRegistry.registerBlock(blockCollapse, "CollapseBlock")

    GameRegistry.registerTileEntity(classOf[TileEntityCollapse], "CollapseBlock")
  }
}
