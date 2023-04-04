package ai.openfabric.api.service;

import ai.openfabric.api.repository.WorkerRepository;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.exception.DockerClientException;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    // Creating a new docker client instance to enable communication with docker
    private DockerClient dockerClient = DockerClientBuilder.getInstance().build();

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    //  This service fetches all workers
    public List<Container> fetchAllWorkers () {
        return dockerClient.listContainersCmd().exec();
    }

    //  This service returns the details for a particular worker
    public InspectContainerResponse fetchWorkerDetails (String workerId) {
        return dockerClient.inspectContainerCmd(workerId).exec();
    }


    //  This service starts a worker
    public String startWorker (String workerId) throws DockerClientException {
        try {
            // Starting the docker worker with the workerId Provided
            dockerClient.startContainerCmd(workerId).exec();
            return "Worker with id " + workerId + " started successfully.";
        } catch(Error error) {
            // Throwing an error if this fails
            throw new Error(error);
        }
    }

    //  This service stops a worker
    public String stopWorker (String workerId) throws DockerClientException {
        try {
            // Stopping the docker worker with the workerId Provided
            dockerClient.stopContainerCmd(workerId).exec();
            return "Worker with id " + workerId + " stopped successfully.";
        } catch(Error error) {
            // Throwing an error if this fails
            throw new Error(error);
        }
    }
}
