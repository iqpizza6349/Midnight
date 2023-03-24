package me.iqpizza6349.midnight.core.event.lifecycle;

import me.iqpizza6349.midnight.event.listener.EventListener;
import org.reflections.Reflections;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Register util class that register all {@link EventListener}
 * implements with {@link Reflections}
 * and make singleton with {@link ConfigurableListableBeanFactory} which
 * is bean-factory <br>
 * <strong>
 *     CAUTION
 * </strong>
 * <br>
 * this register util class is not intervene in {@link me.iqpizza6349.midnight.event.handler.EventHandler}
 * which is register in event container. <br>
 * so, if you want to register with this util class, you have to registry
 * with {@link me.iqpizza6349.midnight.event.handler.EventHandler#addListener(EventListener)}
 * <br>
 * or inherit with {@link me.iqpizza6349.midnight.event.listener.AbstractEventListener}
 * which is automatically register in EventHandler
 * @author iqpizza6349
 * @since 1.0
 * @see me.iqpizza6349.midnight.event.listener.AbstractEventListener
 * @see me.iqpizza6349.midnight.event.handler.EventHandler
 */
public final class ListenerDynamicRegister {

    public static void dynamicRegister(GenericApplicationContext context) {
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        Set<Class<? extends EventListener>> eventListeners = new Reflections("")
                .getSubTypesOf(EventListener.class);
        for (Class<? extends EventListener> listener : eventListeners) {
            if (listener.isInterface()) {
                continue;
            }

            try {
                factory.registerSingleton(listener.getSimpleName(), listener.getDeclaredConstructor().newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
