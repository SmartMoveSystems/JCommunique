package com.notification;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Notification {
	private List<NotificationListener> m_listeners;

	public Notification() {
		m_listeners = new CopyOnWriteArrayList<NotificationListener>();
	}

	/**
	 * Listens for events on the Notification (e.g., a click).
	 *
	 * @param listener
	 */
	public void addNotificationListener(NotificationListener listener) {
		m_listeners.add(listener);
	}

	/**
	 * Removes a listener for events on the Notification (e.g., a click).
	 *
	 * @param listener
	 */
	public void removeNotificationListener(NotificationListener listener) {
		m_listeners.remove(listener);
	}

	protected void fireListeners(String action) {
		for (NotificationListener nl : m_listeners) {
			nl.actionCompleted(this, action);
		}
	}

	public abstract int getX();

	public abstract int getY();

	public abstract void setLocation(int x, int y);

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract void setSize(int width, int height);

	public abstract double getOpacity();

	public abstract void setOpacity(double opacity);

	/**
	 * Reveals the Notification on the desktop.
	 */
	public abstract void show();

	/**
	 * Hides the Notification on the desktop.
	 */
	public abstract void hide();

	/**
	 * @return whether the Notification is being shown
	 */
	public abstract boolean isShown();
}
