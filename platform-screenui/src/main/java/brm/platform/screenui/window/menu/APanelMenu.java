package brm.platform.screenui.window.menu;
import brm.platform.screenui.window.AControl;
import brm.platform.screenui.window.selectable.APanelSelectable;
import java.awt.image.BufferedImage;


/**
 * <h2>APanelMenu</h2>
 * A menu panel definition.
 * @author Gregory
 */
public class APanelMenu extends AControl {
  /**
   * The menu items.
   */
  protected final APanelSelectable[] menuitems;

  /**
   * A public constructor.
   * @param ps An {@link APanelSelectable} array, representing the {@link #menuitems menuitems}.
   * @param bi A {@link BufferedImage} object, representing the {@link #skin skin} object.
   * @param b1 A {@link Boolean} condition, representing whether it is {@link #resizable resizable}.
   * @param sx An {@link Integer} value, representing the {@link #sourcePosX sourcePosX} value.
   * @param sy An {@link Integer} value, representing the {@link #sourcePosY sourcePosY} value.
   * @param sz An {@link Integer} value, representing the {@link #sourcePosZ sourcePosZ} value.
   * @param sw An {@link Integer} value, representing the {@link #sourceSizeX sourceSizeX} value.
   * @param sh An {@link Integer} value, representing the {@link #sourceSizeY sourceSizeY} value.
   */
  public APanelMenu(APanelSelectable[] ps, BufferedImage bi, boolean b1, int sx, int sy, int sz, int sw, int sh) {
    super(b1, sx, sy, sz, sw, sh);
    menuitems = ps;
  }

  @Override
  public void draw() {
  }

  @Override
  public void update() {
  }
}
