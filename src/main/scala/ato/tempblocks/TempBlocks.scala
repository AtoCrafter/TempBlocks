package ato.tempblocks

import ato.tempblocks.proxy.ProxyCommon
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "TempBlocks", modLanguage = "scala")
object TempBlocks {

  @SidedProxy(
    clientSide = "ato.tempblocks.proxy.ProxyClient",
    serverSide = "ato.tempblocks.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
  }
}
