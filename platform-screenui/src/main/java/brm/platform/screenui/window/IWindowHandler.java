package brm.platform.screenui.window;
import java.awt.Graphics2D;


/**
 * <h2>IWindowHandler</h2>
 * Definition of component methodology. This is useful for handling various initialization, layout, and updating of its
 * contents.
 * @author Gregory
 * @see #componentRender() componentRender()
 * @see #initializeLayout() initializeLayout()
 * @see #onComponentBegin() onComponentBegin()
 * @see #onComponentClose() onComponentClose()
 * @see #onComponentOpen() onComponentOpen()
 * @see #onComponentUpdateBefore() onComponentUpdateBefore()
 * @see #onComponentUpdateDuring() onComponentUpdateDuring()
 * @see #onComponentUpdateFinish() onComponentUpdateFinish()
 */
public interface IWindowHandler {
  /**
   * Handle component drawing. Rendering includes translating both static and dynamic content into a graphical format
   * @param g2 A {@link Graphics2D} object, representing the drawable surface.
   * @see IWindowHandler
   */
  abstract public void componentRender(Graphics2D g2);

  /**
   * Whether layout is centerable.
   * @return A {@link Boolean} condition.
   * @see IWindowHandler
   */
  abstract public boolean isCenterable();

  /**
   * Whether layout is expandable.
   * @return A {@link Boolean} condition.
   * @see IWindowHandler
   */
  abstract public boolean isExpandable();

  /**
   * Whether layout is horizontal.
   * @return A {@link Boolean} condition.
   * @see IWindowHandler
   */
  abstract public boolean isHorizontal();

  /**
   * Get the maximum X size.
   * @return A {@link Double} value.
   * @see IWindowHandler
   */
  abstract public double getMaxX();

  /**
   * Get the maximum Y size.
   * @return A {@link Double} value.
   * @see IWindowHandler
   */
  abstract public double getMaxY();

  /**
   * Get the minimum X size.
   * @return A {@link Double} value.
   * @see IWindowHandler
   */
  abstract public double getMinX();

  /**
   * Get the minimum Y size.
   * @return A {@link Double} value.
   * @see IWindowHandler
   */
  abstract public double getMinY();

  /**
   * Initialize the layout. This calculates the initial size and position of this component and any sub-components.
   * @see IWindowHandler
   */
  abstract public void initializeLayout();

  /**
   * Begin populating content. This is performed after initializing layout; it allows loading the data contents of each
   * object in the hierarchy.
   * @see IWindowHandler
   */
  abstract public void onComponentBegin();

  /**
   * Handle component closing. Functionality should be enclosed within an "if" block to ensure it is only performed
   * once.
   * @see IWindowHandler
   */
  abstract public void onComponentClose();

  /**
   * Handle component closing. Functionality should be enclosed within an "if" block to ensure it is only performed
   * once.
   * @see IWindowHandler
   */
  abstract public void onComponentOpen();

  /**
   * Handle component "before" update. This is performed first in each tick update cycle. It might be used to calculate
   * the sizing and positioning of expanding or contracting components.
   * @see IWindowHandler
   */
  abstract public void onComponentUpdateBefore();

  /**
   * Handle component "during" update. This is performed second in each tick update cycle. It might be used for input
   * handling,
   * @see IWindowHandler
   */
  abstract public void onComponentUpdateDuring();

  /**
   * Handle component "finish" update. This is performed last in each tick update cycle. It might be used determining
   * whether the object and its contents are valid.
   * @see IWindowHandler
   */
  abstract public void onComponentUpdateFinish();
}
