package brm.platform.screenui.window.overlay;


/**
 * <h2>OverlayMapInfo</h2>
 * The overlay map info. This is for displaying of an informational overlay.
 * @author Gregory
 */
public class OverlayMapInfo extends APanelOverlay {
  /**
   * The map name. This is the village name, when we are entering it.
   * <p/>
   * If this is empty, {@link #noteH noteH} and {@link #noteW noteW} will be 0, and this string will not be drawn. If
   * both this and {@link #mapnote mapnote} are empty, {@link #draw() draw()} will skip drawing this entirely.
   */
  private final String mapname;
  /**
   * The map note. This is the village note, when we are entering it. It could describe the village's prosperity level,
   * or something foreboding. It could be blank, if nothing more needs to be shown.
   * <p/>
   * If this is empty, {@link #noteH noteH} and {@link #noteW noteW} will be 0, and this string will not be drawn. If
   * both this and {@link #mapname mapname} are empty, {@link #draw() draw()} will skip drawing this entirely.
   */
  private final String mapnote;
  /**
   * The name width.
   */
  private final int nameW;
  /**
   * The name height.
   */
  private final int nameH;
  /**
   * The note width.
   */
  private final int noteW;
  /**
   * The note height.
   */
  private final int noteH;

  public OverlayMapInfo(boolean b1, String[] s, int x, int y, int i) {
    super(false, s, x, y, 0, 0, i);
    mapname = text[0];
    mapnote = text[1];
    // now, get metrics for width and height of each object....
    nameW = 0;
    nameH = 0;
    noteW = 0;
    noteH = 0;

    setTargets(x, y, i, 1);
  }

  @Override
  public boolean isAtTarget() {
    return super.isAtTarget();
  }

  @Override
  public void draw() {
    if(!mapname.isEmpty() && !mapnote.isEmpty()) {
      super.draw();
    }
  }

  @Override
  public void update() {
    super.update();
  }
}
