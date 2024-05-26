package domainapp.webapp.quartz.job;

/*@Component
public class SampleJob implements Job {

    private final InteractionService interactionService;
    private final TransactionalProcessor transactionalProcessor;
    private final SimpleObjects simpleObjects;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final List<SimpleObject> all = all();
        log.info("{} objects in the database", all.size());
    }

    List<SimpleObject> all() {
        return call("sven", simpleObjects::listAll)
                .orElse(Collections.<SimpleObject>emptyList());
    }

    private <T> Optional<T> call(
            final String username,
            final Callable<T> callable) {

        return interactionService.call(
                InteractionContext.ofUserWithSystemDefaults(UserMemento.ofName(username)),
                () -> transactionalProcessor.callWithinCurrentTransactionElseCreateNew(callable))
                .ifFailureFail()
                .getValue();
    }
}*/