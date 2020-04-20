package collectionandmap.sc.interfaced;


import java.util.Objects;
import java.util.function.Consumer;

/**
 * Iterator 取代Enumeration
 * @param <E>
 */
public interface Iterator<E> {
	
   boolean hasNext();

   E next();

   default void remove() {
       throw new UnsupportedOperationException("remove");
   }

   default void forEachRemaining(Consumer<? super E> action) {
       Objects.requireNonNull(action);
       while (hasNext())
           action.accept(next());
   }
}
