package ai.openfabric.api.repository;

import ai.openfabric.api.model.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkerRepository extends CrudRepository<Worker, String> {
    @Query("SELECT w from Worker w WHERE w.name = ?1")
    Optional <Worker> findWorkerByName (String name);
}
