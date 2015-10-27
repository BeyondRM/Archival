package brm.platform.screenui.window.container;
import brm.platform.screenui.window.AControl;
import java.awt.image.BufferedImage;


/**
 * <h2>ContainerRadial</h2>
 * A radial container. This class handles the implementation of displaying contained objects in a radial manner.
 * <p/>
 * This provides a radial arrangement of its contents, such as classic games ("Secret of Mana" and others), where the
 * item menu is displayed as items shown arranged in a circular arrangement around the target.
 * @author Gregory
 */
public class ContainerRadial extends AControlContainer {
  public ContainerRadial(AControl[] a, BufferedImage b, int x, int y, int z, int w, int h) {
    super(a, b, x, y, z, w, h);
  }
}
