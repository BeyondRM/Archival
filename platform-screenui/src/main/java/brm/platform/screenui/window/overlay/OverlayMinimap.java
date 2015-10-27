package brm.platform.screenui.window.overlay;
import brm.platform.screenui.enums.ScreenAnchorMode;


/**
 * <h2>OverlayMinimap</h2>
 * The overlay mini-map. This is for displaying of an informational overlay. For maps smaller than the window size (for
 * where the whole map is seen, such as a building's interior room, a store or home), a mini-map will be automatically
 * not be shown.
 * <p/>
 * This naturally depends upon the existence of a mini-map tilesheet for each normal tilesheet; as the normal tiles are
 * 32x32 sized graphics, the mini-map tiles must be an abstracted miniaturization, such as 2x2, 4x4, or 8x8 in size. We
 * should perhaps prefer the 4x4 size, as each pixel across and down represent one-eighth of the full tile.
 * <p/>
 * To show more on a mini-map overlay than is visible in the game window, the overlay must be larger than one-eighth of
 * the window's visible width and height. For a game window sized 800x600, an equivalent mini-map overlay of 100x75 can
 * show everything the player already sees. But should the overlay be increased to 200x150, the player could see twice
 * the width of the screen; and if we have a mini-map "secret" mode that, with a key-press that expands to the screen's
 * full width and height, the mini-map would effectively be showing eight times the screen's visible portion.
 * @author Gregory
 */
public class OverlayMinimap extends APanelOverlay {
  // this typically has somewhere around half opacity, and is made from miniaturized tiles.

  /**
   *
   * @param i An {@link Integer} value, representing the anchor mode.
   * @param x
   * @param y
   * @param w
   * @param h
   */
  public OverlayMinimap(ScreenAnchorMode i, int x, int y, int w, int h) {
    super(false, null, x, y, w, h, 1);
  }

  @Override
  public void draw() {
  }

  @Override
  public boolean isAtTarget() {
    return super.isAtTarget();
  }
}
