package brm.platform.screenui.window.container;
import brm.platform.screenui.window.AControl;
import java.awt.image.BufferedImage;


/**
 * <h2>AControlContainer</h2>
 * A container panel definition. This is the abstract parent class for defining objects that may contain other objects.
 * <p/>
 * A container may layout its child components in either a horizontal or vertical placement strategy.
 * @author Gregory
 */
public class AControlContainer extends AControl {
  public final AControl[] controls; // the sub-screen components of this container instance.

  public AControlContainer(AControl[] a, BufferedImage b, int x, int y, int z, int w, int h) {
    super(false, x, y, z, w, h);
    controls = a; // this does absolutely no checking on position or overlap; for a possible next step?
  }

  protected void validate() {
    //TODO: Implement a strategy to validate width and height of the screen components in 'controls'...
  }
}
