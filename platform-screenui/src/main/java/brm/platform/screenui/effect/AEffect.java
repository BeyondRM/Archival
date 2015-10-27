package brm.platform.screenui.effect;
import java.awt.image.BufferedImage;


/**
 * <h2>AEffect</h2>
 * A visual effect definition. This abstract class defines the attributes relevant to a visual effect, which may apply
 * to either the whole screen, or to one part of it, such as only one character or tile on a map. It is useful to setup
 * changes in opacity, transparency, or in changes to brightness or color values. Some effects can also be used by the
 * Camera class to render transitions, such as going from one state to another.
 * <p/>
 * The following list of visual effects is incomplete, but may be useful in creating the classes which handle an effect
 * for usage.
 * <ul>
 * <li/>Fade. An object can be faded in or out over a number of ticks using some kind of algorithm to compute the speed
 * of a fade. For fading in, we should first set the opacity to minimal, and increase it from that.
 * <li/>Flash. An object can be made to "flash" by masking it with some bright color, such as a full-on white color. It
 * is often used to represent some kind of "stun damage" or sudden and shocking action. The duration of a flash perhaps
 * represent different things; a short duration could be used for a brief hit, while a longer flash duration could mean
 * a character is knocked unconscious and is recuperating.
 * <li/>Tint. An object can be tinted to a new color, perhaps even darkened somewhat, to provide an effect of low light
 * (such as in caves and interiors); or the color could be modified to change the 'feel' or tone of the area.
 * <li/>
 * <li/>
 * </ul>
 * @author Gregory
 */
abstract public class AEffect {
  /**
   * Whether the effect is finished. This is set to true when the time (number of ticks) has expired.
   * @see AEffect
   * @see #isFinished() isFinished()
   */
  protected boolean finished;
  /**
   * @see AEffect
   */
  protected int opacity;
  /**
   * @see AEffect
   */
  protected int time = 0;

  /**
   * @see AEffect
   */
  public AEffect() {
  }

  /**
   * Render the effect.
   * @param bi A {@link BufferedImage} object, representing a source to render the effect upon.
   * @return A {@link BufferedImage} object.
   * @see AEffect
   */
  abstract public BufferedImage renderEffect(BufferedImage bi);

  /**
   * Whether the effect is finished.
   * @return A {@link Boolean} condition.
   * @see AEffect
   * @see #finished finished
   */
  public boolean isFinished() {
    return finished;
  }

  /**
   * Update the effect. This is for updating any aspect of the overall effect that requires updating, such as a current
   * time in the chain of effects, and the state of things.
   * @see AEffect
   */
  public void update() {
    // A bare minimum of processing should occur here, so that if we want to extend this, we handle some things safely.
  }
}
