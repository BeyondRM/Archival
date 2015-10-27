package brm.platform.screenui.window.menu;
import brm.platform.screenui.window.selectable.APanelSelectable;
import java.awt.image.BufferedImage;


/**
 * A vertical menu class.
 * @author Gregory
 */
abstract public class APanelMenuVertical extends APanelMenu {
  public APanelMenuVertical(APanelSelectable[] ps, BufferedImage bi, boolean b1, int sx, int sy, int sz, int sw, int sh) {
    super(ps, bi, b1, sx, sy, sz, sw, sh);
  }

  @Override
  public void draw() {
    super.draw();
  }

  @Override
  public void update() {
    super.update();
  }
}
