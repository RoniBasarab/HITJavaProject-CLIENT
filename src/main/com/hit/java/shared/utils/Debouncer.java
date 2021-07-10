package main.com.hit.java.shared.utils;
import java.util.concurrent.*;

public class Debouncer {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentHashMap<Object, Future<?>> delayedMap = new ConcurrentHashMap<>();
    /**
     * create a seperate thread and an object hashmap
     * @param runnable
     * @param delay
     * @param unit
     */
    public void debounce(final Runnable runnable, long delay, TimeUnit unit) {
        //delayedmap.put start the runnable in a new thread and cancels the previous
        final Future<?> prev = delayedMap.put(Void.class, scheduler.schedule(() -> {
            try {
                runnable.run();
            } finally {
                delayedMap.remove(Void.class);
            }
        }, delay, unit));
        if (prev != null) {
            prev.cancel(true);
        }
    }
    public void shutdown() {
        scheduler.shutdownNow();
    }
}
