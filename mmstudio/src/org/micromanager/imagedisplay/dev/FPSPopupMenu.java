package org.micromanager.imagedisplay.dev;

import com.google.common.eventbus.EventBus;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

/**
 * This class provides an interface for selecting the FPS at which to display
 * animations for the ScrollerPanel.
 */
public class FPSPopupMenu extends JPopupMenu {
   /**
    * Signifies a change in the current FPS.
    */
   public class FPSEvent {
      private int fps_;

      public FPSEvent(int fps) {
         fps_ = fps;
      }

      public int getFPS() {
         return fps_;
      }
   }

   /**
    * Implementation adapted from
    * http://www.onjava.com/pub/a/onjava/excerpt/swing_14/index6.html?page=2
    */
   private class FPSSlider extends JSlider implements MenuElement {
      public FPSSlider() {
         super(1, 100);
         setBorder(new TitledBorder("Animation FPS"));
         setMajorTickSpacing(20);
         // Set up custom labels, because otherwise we end up with ticks at
         // 21, 41, etc.
         Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
         labels.put(1, new JLabel("1"));
         for (int i = 20; i < 101; i += 20) {
            labels.put(i, new JLabel(String.valueOf(i)));
         }
         setLabelTable(labels);
         setPaintLabels(true);
      }
      
      @Override
      public MenuElement[] getSubElements() {
         return new MenuElement[0];
      }

      @Override
      public Component getComponent() {
         return this;
      }

      /**
       * Forward mouse motion events to our slider. Well actually we forward
       * *all* mouse events to our slider, but it seems to work okay.
       */
      @Override
      public void processMouseEvent(MouseEvent e, MenuElement[] path,
            MenuSelectionManager manager) {
         super.processMouseMotionEvent(e);
      }
      @Override
      public void processKeyEvent(KeyEvent e, MenuElement[] path,
            MenuSelectionManager manager) {}
      @Override
      public void menuSelectionChanged(boolean isIncluded) {}
   }

   private FPSSlider slider_;

   public FPSPopupMenu(final EventBus bus, int initialVal) {
      slider_ = new FPSSlider();
      slider_.setValue(initialVal);
      slider_.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            bus.post(new FPSEvent(slider_.getValue()));
         }
      });
      add(slider_);
   }
}
