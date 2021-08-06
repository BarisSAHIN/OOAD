/**
 * Interface for commands
 *
 * */
public interface Command {
    /**
     * @return execute function returns 1 on failed command return 0 on successful one
     * */
    public int execute();
}
