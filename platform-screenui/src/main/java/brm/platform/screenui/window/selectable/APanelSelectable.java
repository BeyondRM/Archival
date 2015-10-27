package brm.platform.screenui.window.selectable;
import brm.platform.screenui.ScreenStatic;
import brm.platform.screenui.window.AControl;
import java.awt.image.BufferedImage;


/**
 * <h2>APanelSelectable</h2>
 * A selectable panel definition. This abstract class contains fields and methods specific to the selection of content,
 * and the selection state of objects.
 * @author Gregory
 */
abstract public class APanelSelectable extends AControl {
  /**
   * Whether the panel is selectable.
   * @see APanelSelectable
   */
  protected boolean selectable;
  /**
   * Whether the panel is selected.
   * @see APanelSelectable
   */
  protected boolean selected;

  /**
   * A public constructor.
   * @param bi A {@link BufferedImage} object, representing ... ?
   * @see APanelSelectable
   */
  public APanelSelectable(BufferedImage bi, boolean b0, boolean b1, boolean b2) {
    this(bi, b0, b1, b2, 0, 0, 0, ScreenStatic.getFullWidth(), ScreenStatic.getFullHeight());
  }

  /**
   * A public constructor.
   * @param bi A {@link BufferedImage} object, representing ... ?
   * @see APanelSelectable
   */
  public APanelSelectable(BufferedImage bi, boolean b0, boolean b1, boolean b2, int ii) {
    this(bi, b0, b1, b2, ii, ii, ii, ScreenStatic.getFullWidth(), ScreenStatic.getFullHeight());
  }

  /**
   * A public constructor.
   * @param bi A {@link BufferedImage} object, representing ... ?
   * @see APanelSelectable
   */
  public APanelSelectable(BufferedImage bi, boolean b0, boolean b1, boolean b2, int sx, int sy, int sz, int sw, int sh) {
    super(b0, sx, sy, sz, sw, sh);
    selectable = b1;
    selected = b2;
  }

  /**
   * Whether the panel is selectable.
   * @return A {@link Boolean} condition.
   * @see APanelSelectable
   */
  public boolean isSelectable() {
    return selectable;
  }

  /**
   * Whether the panel is selected.
   * @return A {@link Boolean} condition.
   * @see APanelSelectable
   */
  public boolean isSelected() {
    return selected;
  }

  /**
   * Set the panel selectable.
   * @param b A {@link Boolean} condition, representing the {@link #selectable selectable} state.
   * @see APanelSelectable
   */
  public void setSelectable(boolean b) {
    selectable = b;
  }

  /**
   * Set the panel selected.
   * @param b A {@link Boolean} condition, representing the {@link #selected selected} state.
   * @see APanelSelectable
   */
  public void setSelected(boolean b) {
    selected = b;
  }
}
