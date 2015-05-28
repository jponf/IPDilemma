package cat.udl.ipdilemma;

import cat.udl.ipdilemma.exceptions.CurrentlyExistingException;
import cat.udl.ipdilemma.exceptions.NonExistingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Register {

    private static Register register;
    Map<String, PlayerStrategy> strategiesmap;

    /**
     * Gets the strategies register
     *
     * @return The strategies register
     */
    public static Register getRegister() {
        if (register == null) {
            synchronized (Register.class) {
                if (register == null) {
                    register = new Register();
                }
            }
        }
        return register;
    }

    private Register() {
        strategiesmap = new HashMap<>();
    }

    /**
     * Add the specified strategy associated to the given name
     *
     * @param ps
     *
     * @throws CurrentlyExistingException If the name is already used
     */
    public void addStrategy(PlayerStrategy ps)
            throws CurrentlyExistingException {

        if (strategiesmap.containsKey(ps.getName())) {
            throw new CurrentlyExistingException(
                    "There are another strategy under the name: " + ps.getName()
                    + ", remove it before add the new one");
        }
        strategiesmap.put(ps.getName(), ps);
    }

    /**
     * Remove the strategy associated to the given name
     *
     * @param name
     */
    public void removeStrategy(String name) {
        strategiesmap.remove(name);
    }

    /**
     *
     * @param name
     * @return The strategy associated to the given name
     * @throws NonExistingException If the given name is not associated to any
     * strategy
     */
    public PlayerStrategy getStrategy(String name) throws NonExistingException {
        if (!strategiesmap.containsKey(name)) {
            throw new NonExistingException(
                    "There isn't any strategy under the name: " + name);
        }
        return strategiesmap.get(name).copy();
    }

    /**
     *
     * @return A set with the name of all the registered strategies
     */
    public Set<String> getRegisteredNames() {
        return strategiesmap.keySet();
    }
}
