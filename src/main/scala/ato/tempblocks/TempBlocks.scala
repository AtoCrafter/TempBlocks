package ato.tempblocks

import ato.tempblocks.block.{BlockChain, BlockCollapse, BlockFrame}
import ato.tempblocks.proxy.ProxyCommon
import ato.tempblocks.tileentity.TileEntityCollapse
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.ItemStack

@Mod(modid = "TempBlocks", modLanguage = "scala")
object TempBlocks {

  @SidedProxy(
    clientSide = "ato.tempblocks.proxy.ProxyClient",
    serverSide = "ato.tempblocks.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val blockFrame = new BlockFrame()
  val blockCollapse = new BlockCollapse()
  val blockChain = new BlockChain()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerBlock(blockFrame, "FrameBlock")
    GameRegistry.registerBlock(blockCollapse, "CollapseBlock")
    GameRegistry.registerBlock(blockChain, "ChainBlock")

    GameRegistry.registerTileEntity(classOf[TileEntityCollapse], "CollapseBlock")

    GameRegistry.addRecipe(new ItemStack(blockFrame, 64),
      "SSS",
      "W W",
      "SSS",
      Character.valueOf('S'), Items.stick,
      Character.valueOf('W'), Blocks.planks)
    GameRegistry.addRecipe(new ItemStack(blockCollapse, 64),
      "GGG",
      "GFG",
      "GGG",
      Character.valueOf('G'), Blocks.glass,
      Character.valueOf('F'), Items.flint)
    GameRegistry.addRecipe(new ItemStack(blockChain, 64),
      "FFF",
      "S S",
      "FFF",
      Character.valueOf('F'), Blocks.iron_bars,
      Character.valueOf('S'), Items.string)
  }
}
