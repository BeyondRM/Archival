package brm.platform.screenui.window.overlay;
import brm.platform.screenui.window.AControl;


/**
 * <h2>APanelOverlay</h2>
 * The screen overlay definition.
 * <p/>
 * This abstract class contains fields and methods for managing a panel overlay, which is shown over the map screen, as
 * the player is playing the map. It is not persistent if the player pulls up the main menu in the game, as that screen
 * is typically launched from another game state.
 * @author Gregory
 */
abstract public class APanelOverlay extends AControl {
  /**
   * The text to show.
   */
  protected final String[] text;
  /**
   * The current scale.
   */
  protected int currentScale;
  /**
   * The target speed.
   */
  protected int targetSpeed;
  /**
   * The target X coordinate.
   */
  protected int targetX;
  /**
   * The target Y coordinate.
   */
  protected int targetY;

  {
    currentScale = 1;
    sourcePosX = 0;
    sourcePosY = 0;
    targetScale = currentScale;
    targetSpeed = 0;
    targetX = 0;
    targetY = 0;
  }

  /**
   * A public constructor.
   */
  public APanelOverlay() {
    this(false, new String[] {""}, 0, 0, 0, 0, 1);
  }

  /**
   * A public constructor. Takes parameters for the starting X, Y, and scale values.
   * @param b A {@link Boolean} condition, representing if object is {@link #resizable resizable}.
   * @param s A {@link String} array, representing the {@link #text text} value.
   * @param x An {@link Integer} value, representing the {@link #sourcePosX sourcePosX} value.
   * @param y An {@link Integer} value, representing the {@link #sourcePosY sourcePosY} value.
   * @param w An {@link Integer} value, representing the {@link #sourceSizeX sourceSizeX} value.
   * @param h An {@link Integer} value, representing the {@link #sourceSizeY sourceSizeY} value.
   * @param i An {@link Integer} value, representing the {@link #currentScale sourceScale} value.
   */
  public APanelOverlay(boolean b, String[] s, int x, int y, int w, int h, int i) {
    super(b, x, y, w, h, i);
    text = s;
    currentScale = i;
    APanelOverlay.this.setTargets(x, y, i, 2);
  }

  /**
   * Draw the overlay.
   */
  @Override
  public void draw() {
    // draw the background / skin (if any)
    // draw the foreground borders (if any)
    // draw the contents, if any
  }

  /**
   * Update the overlay.
   * <p/>
   * This method updates the overlay position and scale.
   */
  @Override
  public void update() {
    if(sourcePosX != targetX) {
      // set the current X if different from the target value
    }
    if(sourcePosY != targetY) {
      // set the current Y if different from the target value
    }
    if(currentScale != targetScale) {
      // set the current scale as a portion of the difference
      // if the difference is > 1, ...
      // if the difference is < 1, ...
    }
    if(targetSpeed != 0) {
      // define how to abate the speed...
    }
  }

  /**
   * Set the target values.
   * @param x An {@link Integer} value, representing the {@link #targetX targetX} value.
   * @param y An {@link Integer} value, representing the {@link #targetY targetY} value.
   * @param i An {@link Integer} value, representing the {@link #targetScale targetScale} value.
   * @param j An {@link Integer} value, representing the {@link #targetSpeed targetSpeed} value.
   */
  public final void setTargets(int x, int y, int i, int j) {
    targetX = x;
    targetY = y;
    targetScale = i;
    targetSpeed = j;
  }

  /**
   * Overlay is at target.
   * @return A {@link Boolean} condition.
   */
  public boolean isAtTarget() {
    return currentScale == targetScale
        && sourcePosX == targetX
        && sourcePosY == targetY
        && targetSpeed == 0;
  }
}
