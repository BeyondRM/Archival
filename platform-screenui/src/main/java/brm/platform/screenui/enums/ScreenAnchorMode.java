package brm.platform.screenui.enums;


/**
 * <h2>ScreenAnchorMode</h2>
 * The screen anchor mode. This is for specifying the screen anchor-point attachment mode.
 * <p/>
 * Normally, we would consider starting with the cardinal screen points; however, with this enumeration we are starting
 * from our screen center, our screen corners, and then the center of the screen sides.
 * @author Gregory
 * @see #center00 center00
 * @see #cornerNE cornerNE
 * @see #cornerSE cornerSE
 * @see #cornerSW cornerSW
 * @see #cornerNW cornerNW
 * @see #edgeNorth edgeNorth
 * @see #edgeEast edgeEast
 * @see #edgeSouth edgeSouth
 * @see #edgeWest edgeWest
 * @see #midnortheast midnortheast
 * @see #midsoutheast midsoutheast
 * @see #midsouthwest midsouthwest
 * @see #midnorthwest midnorthwest
 */
public enum ScreenAnchorMode {
  /**
   * The screen center point.
   * @see ScreenAnchorMode
   */
  center00,
  /**
   * The screen northeast corner.
   * @see ScreenAnchorMode
   */
  cornerNE,
  /**
   * The screen southeast corner.
   * @see ScreenAnchorMode
   */
  cornerSE,
  /**
   * The screen southwest corner.
   * @see ScreenAnchorMode
   */
  cornerSW,
  /**
   * The screen northwest corner.
   * @see ScreenAnchorMode
   */
  cornerNW,
  /**
   * The screen north edge center.
   * @see ScreenAnchorMode
   */
  edgeNorth,
  /**
   * The screen east edge center.
   * @see ScreenAnchorMode
   */
  edgeEast,
  /**
   * The screen south edge center.
   * @see ScreenAnchorMode
   */
  edgeSouth,
  /**
   * The screen west edge center.
   * @see ScreenAnchorMode
   */
  edgeWest,
  /**
   * The screen northeast quadrant center.
   * @see ScreenAnchorMode
   */
  midnortheast,
  /**
   * The screen southeast quadrant center.
   * @see ScreenAnchorMode
   */
  midsoutheast,
  /**
   * The screen southwest quadrant center.
   * @see ScreenAnchorMode
   */
  midsouthwest,
  /**
   * The screen northwest quadrant center.
   * @see ScreenAnchorMode
   */
  midnorthwest;

  private ScreenAnchorMode() {
  }
}
