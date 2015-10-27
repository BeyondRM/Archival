package brm.platform.screenui.window;
import brm.platform.screenui.ScreenStatic;
import brm.platform.screenui.enums.ScreenObjectMode;


/**
 * <h2>AControl</h2>
 * The abstract screen object.
 * @author Gregory
 */
abstract public class AControl {
  //==========================================================================
  //  The private fields.
  private double moveMomentumX = 0.0D; // how quick we move on the x plane
  private double moveMomentumY = 0.0D; // how quick we move on the y plane
  private double moveMomentumZ = 0.0D; // how quick we move on the z plane
  private double sizeMomentumX = 0.0D; // how quick we size on the x plane
  private double sizeMomentumY = 0.0D; // how quick we size on the y plane
  private double sizeMomentumZ = 0.0D; // how quick we size on the z plane
  //==========================================================================
  //  The protected fields.
  /**
   * Whether it is resizable. If this object is able to be resized, a few of the class methods will handle resizing it
   * to the target size, if target sizes are not the same as the current sizes.
   * @see AControl
   */
  protected final boolean resizable;
  /**
   * The screen object mode. This may be used internally to determine this object's overall state of operation.
   * @see AControl
   */
  protected ScreenObjectMode mode;
  protected ScreenObjectMode modeMove;
  protected ScreenObjectMode modeScale;
  protected ScreenObjectMode modeSize;
  /**
   * Whether we are visible. If this is visible, it is drawn on the screen at the specified coordinates and sizes.
   * @see AControl
   */
  protected boolean visible;
  /**
   * The movement direction. This is the direction that movement should occur, if any movement is possible. Generally,
   * movement is not possible when the current X, Y, Z, and Scale are equal to the target X, Y, Z, and Scale values.
   * @see AControl
   */
  protected int moveDirection;
  /**
   * The source position X coordinate.
   * @see AControl
   */
  protected int sourcePosX; // the x within the graphics space, relative to the initial
  /**
   * The source position Y coordinate.
   * @see AControl
   */
  protected int sourcePosY;
  /**
   * The source position Z coordinate.
   * @see AControl
   */
  protected int sourcePosZ;
  /**
   * The source scale.
   * @see AControl
   */
  protected int sourceScale;
  /**
   * The source X size.
   * @see AControl
   */
  protected int sourceSizeX;
  /**
   * The source Y size.
   * @see AControl
   */
  protected int sourceSizeY;
  /**
   * The target position X.
   * @see AControl
   */
  protected int targetPosX;
  /**
   * The target position Y.
   * @see AControl
   */
  protected int targetPosY;
  /**
   * The target position Z.
   * @see AControl
   */
  protected int targetPosZ;
  /**
   * The target scale.
   * @see AControl
   */
  protected int targetScale;
  /**
   * The target X size.
   * @see AControl
   */
  protected int targetSizeX;
  /**
   * The target Y size.
   * @see AControl
   */
  protected int targetSizeY;

  public AControl(boolean b) {
    this(b, 0, 0, 0, ScreenStatic.getFullWidth(), ScreenStatic.getFullHeight());
  }

  public AControl(boolean b, int i) {
    this(b, i, i, i, ScreenStatic.getFullWidth(), ScreenStatic.getFullHeight());
  }

  /**
   * A public constructor.
   * @param b A {@link Boolean} condition, representing whether it is {@link #resizable resizable}.
   * @param x An {@link Integer} value, representing the {@link #sourcePosX sourcePosX} value.
   * @param y An {@link Integer} value, representing the {@link #sourcePosY sourcePosY} value.
   * @param z An {@link Integer} value, representing the {@link #sourcePosZ sourcePosZ} value.
   * @param w An {@link Integer} value, representing the {@link #sourceSizeX sourceSizeX} value.
   * @param h An {@link Integer} value, representing the {@link #sourceSizeY sourceSizeY} value.
   * @see AControl
   */
  public AControl(boolean b, int x, int y, int z, int w, int h) {
    resizable = b;
    mode = ScreenObjectMode.initializing;

    sourcePosX = x;
    sourcePosY = y;
    sourcePosZ = z;
    sourceSizeX = w;
    sourceSizeY = h;

    targetPosX = sourcePosX;
    targetPosY = sourcePosY;
    targetPosZ = sourcePosZ;
    targetSizeX = sourceSizeX;
    targetSizeY = sourceSizeY;

    mode = ScreenObjectMode.opening;
    visible = true;

    moveDirection = 0; // 0 = no move; 1 = N; 2 = E; 3 = S; 4 = W; 5 = NE; 6 = SE; 7 = SW; 8 = NW;
    targetPosX = 0;
    targetPosY = 0;
    targetPosZ = 0;
  }

  public final boolean isAt() {
    return isAtPosition() && isAtScale() && isAtSize();
  }

  public final boolean isAtPosition() {
    return sourcePosX == targetPosX
        && sourcePosY == targetPosY
        && sourcePosZ == targetPosZ;
  }

  public final boolean isAtScale() {
    return sourceScale == targetScale;
  }

  public final boolean isAtSize() {
    return sourceSizeX == targetSizeX
        && sourceSizeY == targetSizeY;
  }

  public final boolean isVisible() {
    return visible;
  }

  public final void setVisible(boolean b) {
    visible = b;
  }

  /**
   * Update the panel movement.
   * <p/>
   * This is called from the {@link #update() update()} method, so it does not need to be called again.
   * @param b A {@link Boolean} condition, representing whether to constrain to within screen borders.
   * @see AControl
   */
  public final void updateMove(boolean b) {
    boolean mobile = !isAtPosition();
    if(mobile) {
      if(modeMove != ScreenObjectMode.moving) {
        modeMove = ScreenObjectMode.moving;
      }
      //TODO: Need to determine a methodology for incorporating momentum on panel moving
      if(sourcePosX != targetPosX) {
        int offX = targetPosX - sourcePosX;
        if(offX >= -1 && offX <= 1) {
          sourcePosX = targetPosX;
        } else if(offX > 1) {
          sourcePosX += 2;
        } else if(offX < -1) {
          sourcePosX -= 2;
        }
      }
      if(sourcePosY != targetPosY) {
        int offY = targetPosY - sourcePosY;
        if(offY >= -1 && offY <= 1) {
          sourcePosY = targetPosY;
        } else if(offY > 1) {
          sourcePosY += 2;
        } else if(offY < -1) {
          sourcePosY -= 2;
        }
      }
      if(sourcePosZ != targetPosZ) {
        int offZ = targetPosZ - sourcePosZ;
        if(offZ >= -1 && offZ <= 1) {
          sourcePosZ = targetPosZ;
        } else if(offZ > 1) {
          sourcePosZ += 2;
        } else if(offZ < -1) {
          sourcePosZ -= 2;
        }
      }
    }
    if(mobile && isAtPosition()) {
      if(modeMove != ScreenObjectMode.moved) {
        modeMove = ScreenObjectMode.moved;
      }
    }
  }

  public final void updateScale(boolean b) {
    boolean scaling = !isAtScale();
    if(scaling) {
      if(modeScale != ScreenObjectMode.scaling) {
        modeScale = ScreenObjectMode.scaling;
      }
      //TODO: Need to determine a methodology for incorporating sizing and scaling constraints.
      if(sourceScale != targetScale) {
        int offScale = targetScale - sourceScale;
//      if(offX >= -1 && offX <= 1) {
//        sourcePosX = targetPosX;
//      } else if(offX > 1) {
//        sourcePosX += 2;
//      } else if(offX < -1) {
//        sourcePosX -= 2;
//      }
      }
    }
    if(scaling && isAtScale()) {
      if(modeScale != ScreenObjectMode.scaled) {
        modeScale = ScreenObjectMode.scaled;
      }
    }
  }

  public final void updateSize(boolean b) {
    boolean sizing = !isAtSize();
    if(sizing) {
      if(modeSize != ScreenObjectMode.sizing){
        modeSize = ScreenObjectMode.sizing;
      }
      //TODO: Need to determine a methodology for incorporating momentum on panel sizing
    }
  }

  /**
   * Draw the panel.
   * @see AControl
   */
  public void draw() {
  }

  /**
   * Move the screen object.
   * @param x An {@link Integer} value, representing the {@link #sourcePosX sourcePosX} value.
   * @param y An {@link Integer} value, representing the {@link #sourcePosY sourcePosY} value.
   * @param z An {@link Integer} value, representing the {@link #sourcePosZ sourcePosZ} value.
   * @param w An {@link Integer} value, representing the {@link #sourceSizeX sourceSizeX} value.
   * @param h An {@link Integer} value, representing the {@link #sourceSizeY sourceSizeY} value.
   * @see AControl
   */
  public void move(int x, int y, int z, int w, int h) {
  }

  /**
   * Update the panel. This will update the move cycle, then check the scale.
   * @see AControl
   */
  public void update() {
    // update the panel movement here.
    updateMove(true);
    // update the panel scaling here.
    if(modeScale == ScreenObjectMode.closed) {
      updateScale(true);
    }
  }
}
