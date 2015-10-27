package brm.platform.screenui;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * <h2>ScreenStatic</h2>
 * Screen static methods.
 * @author Gregory
 */
public class ScreenStatic {
  // first, the static-final fields, won't change once initialized:
  private static final DisplayMode[] displayModes;
  // next, the static non-final fields, initialized in "absoluteInitialization()", values might change at runtime:
  private static Graphics2D graphics2D;
  private static GraphicsDevice graphicsDevice;
  private static Window window;
  private static boolean initialized;

  static {
    // a simple array of display modes; can be added to.
    displayModes = new DisplayMode[] {
      new DisplayMode(1920, 1080, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1920, 1080, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1920, 1080, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1366, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1366, 768, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1366, 768, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 768, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 768, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 720, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 720, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(1024, 720, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(800, 600, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(640, 480, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(640, 480, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
      new DisplayMode(640, 480, 16, DisplayMode.REFRESH_RATE_UNKNOWN)
    };
    initialized = false;
  }

  private ScreenStatic() {
  }
  private static JFrame defaultFrame(String s) {
    JFrame frame = new JFrame(s);
    frame.setUndecorated(true);
    frame.setIgnoreRepaint(true);
    frame.setResizable(false);
//  frame.pack();
//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  frame.setLocationRelativeTo(null);
//  frame.setVisible(true);
    return frame;
  }
  private static boolean displayModesMatch(DisplayMode s, DisplayMode t) { // s = source mode; t = target mode;
    return (s.equals(t))
        && (s.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI || t.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI)
        && (s.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || t.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN);
  }
  public static final BufferedImage createCompatibleImage(int w, int h) {
    return window.getGraphicsConfiguration().createCompatibleImage(w, h);
  }
  public static final Dimension asDimension() {
    if(!initialized) {
      absoluteInitialization();
    }
    return window.getSize();
  }
  public static final DisplayMode findFirstCompatibleMode() {
    DisplayMode[] goodModes = graphicsDevice.getDisplayModes();
    for(DisplayMode displayMode : displayModes) {
      for(DisplayMode goodMode : goodModes) {
        if(displayModesMatch(goodMode, displayMode)) {
          return displayMode;
        }
      }
    }
    return goodModes.length > 0 ? goodModes[0] : null;
  }
  public static final DisplayMode getCurrentDisplayMode() {
    return graphicsDevice.getDisplayMode();
  }
  public static final Graphics2D getGraphics2D() {
    return graphics2D;
  }
  public static final Point toScreenCenter() {
    Point point = new Point(getHalfWidth(), getHalfHeight());
    SwingUtilities.convertPointToScreen(point, window);
    return point;
  }
  public static final Window getWindow() {
    return window;
  }
  public static final int getFullHeight() {
    return window.getHeight();
  }
  public static final int getFullWidth() {
    return window.getWidth();
  }
  public static final int getHalfHeight() {
    return getFullHeight() / 2;
  }
  public static final int getHalfWidth() {
    return getFullWidth() / 2;
  }
  public static final void absoluteInitialization() {
    if(!initialized) {
      // setup graphics device to be the default device (monitor), and window to fullscreen
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      graphicsDevice = ge.getDefaultScreenDevice();
      window = graphicsDevice.getFullScreenWindow();
      graphics2D = (Graphics2D)window.getGraphics();
      initialized = graphicsDevice != null && window != null && graphics2D != null;
    }
  }
  public static final void addKeyListener(KeyListener kl) {
    window.addKeyListener(kl);
  }
  public static final void initialize(DisplayMode d, JFrame f, String s) {
    JFrame frame = f != null ? f : defaultFrame(s);
    graphicsDevice.setFullScreenWindow(frame);
    if(d != null && graphicsDevice.isDisplayChangeSupported()) {
      graphicsDevice.setDisplayMode(d);
    }
    window.createBufferStrategy(2);
  }
  public static final void restoreScreen() {
    if(window != null) {
      window.dispose();
    }
  }
  public static final void updateBuffer() {
    if(window != null) {
      BufferStrategy bs = window.getBufferStrategy();
      if(!bs.contentsLost()) {
        bs.show();
      }
    }
  }
}
