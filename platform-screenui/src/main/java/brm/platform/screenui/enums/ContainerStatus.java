package brm.platform.screenui.enums;


/**
 * <h2>ContainerStatus</h2>
 * The container modality. This keeps track of whether a container or overlay has appeared or is opening or closing, or
 * disappeared. It is very particularly used in the container update methodology to advanced to the next mode.
 * @author Gregory
 * @see #unopened unopened
 * @see #opening opening
 * @see #opened opened
 * @see #unclosed unclosed
 * @see #closing closing
 * @see #closed closed
 * @see #unknown unknown
 * @see #ContainerStatus() ContainerStatus()
 */
public enum ContainerStatus {
  /**
   * The container is unopened. This is the default and initialized state of containers. It could be either invisible,
   * or visible but at the minimum size.
   * <p/>
   * Input handling should remain not-handled until fully opened. Delta positioning and sizing will be computed for the
   * next phase. Afterward, processing should go to the {@code opening} modality.
   * @see ContainerStatus
   * @see #opening opening
   */
  unopened,
  /**
   * The container is opening. It is made visible (if initialized invisible), sized to a minimum size, and might expand
   * to the maximum size.
   * <p/>
   * Input handling should remain not-handled until fully opened. Afterward, processing should go to the {@code opened}
   * modality.
   * @see ContainerStatus
   * @see #opened opened
   */
  opening,
  /**
   * The container is opened. It remains visible, and at the final size, until it is set to be modally closing. An open
   * container or component should be fully activated and displaying its contents.
   * <p/>
   * Input handling should be enabled for interaction for this mode only. Afterward, processing should go to the
   * {@code unclosed} modality.
   * @see ContainerStatus
   * @see #unclosed unclosed
   */
  opened,
  /**
   * The container is unclosed. It will begin calculating the target sizes and positions for the closing process.
   * <p/>
   * Input handling should be halted, and remain not-handled for the duration of its existence. Afterward, processing
   * should go to the {@code closing} modality.
   * @see ContainerStatus
   * @see #closing closing
   */
  unclosed,
  /**
   * The container is closing. It will update sizes and positions based upon the previous calculations.
   * <p/>
   * Input handling should remain not-handled for the duration of its existence. Afterward, processing should go to the
   * {@code closed} modality.
   * @see ContainerStatus
   * @see #closed closed
   */
  closing,
  /**
   * The container is closed. This will result in the object being ready to be disposed.
   * <p/>
   * Input handling should remain not-handled for the duration of its existence. Afterward, processing should go to the
   * {@code unknown} modality, if everything within it is no longer used.
   * @see ContainerStatus
   * @see #unknown unknown
   */
  closed,
  /**
   * The container is unknown. This is for when the container is closed and can subsequently be "deleted" or removed as
   * an object.
   * <p/>
   * Input handling should remain not-handled for the duration of its existence.
   * @see ContainerStatus
   */
  unknown;

  private ContainerStatus() {
  }
}
